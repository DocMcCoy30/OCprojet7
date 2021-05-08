package com.dmc30.userapi.service.impl;

import com.dmc30.userapi.data.entity.*;
import com.dmc30.userapi.data.repository.AbonneRepository;
import com.dmc30.userapi.data.repository.EmployeRepository;
import com.dmc30.userapi.data.repository.PaysRepository;
import com.dmc30.userapi.data.repository.RoleRepository;
import com.dmc30.userapi.security.PasswordEncoderHelper;
import com.dmc30.userapi.service.contract.UsersService;
import com.dmc30.userapi.shared.AdresseDto;
import com.dmc30.userapi.shared.PaysDto;
import com.dmc30.userapi.shared.RoleDto;
import com.dmc30.userapi.shared.UsersDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    private AbonneRepository abonneRepository;
    private EmployeRepository employeRepository;
    private RoleRepository roleRepository;
    private PaysRepository paysRepository;
    private PasswordEncoderHelper passwordEncoderHelper;

    @Autowired
    public UsersServiceImpl(AbonneRepository abonneRepository,
                            EmployeRepository employeRepository,
                            RoleRepository roleRepository,
                            PaysRepository paysRepository,
                            PasswordEncoderHelper passwordEncoderHelper) {
        this.abonneRepository = abonneRepository;
        this.employeRepository = employeRepository;
        this.roleRepository = roleRepository;
        this.paysRepository = paysRepository;
        this.passwordEncoderHelper = passwordEncoderHelper;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        EmployeEntity employeEntity;
        AbonneEntity abonneEntity = abonneRepository.findByEmail(email);
        List<GrantedAuthority> abonneAuthorities = abonneEntity.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
        if (abonneEntity == null) {
            employeEntity = employeRepository.findByEmail(email);
            List<GrantedAuthority> employeAuthorities = employeEntity.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRole()))
                    .collect(Collectors.toList());
            if (employeEntity == null) {
                throw new UsernameNotFoundException(email + " n'existe pas dans la base de données.");
            } else return new User(employeEntity.getEmail(),
                    employeEntity.getEncryptedPassword(),
                    true,
                    true,
                    true,
                    true,
                    employeAuthorities);
        }
        return new User(abonneEntity.getEmail(),
                abonneEntity.getEncryptedPassword(),
                true,
                true,
                true,
                true,
                abonneAuthorities);
    }

    @Override
    public UsersDto createAbonne(UsersDto usersDto, Long paysId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        usersDto.setPublicId(UUID.randomUUID().toString());
        //get Adresse de l'abonné
        AdresseDto adresseDto = usersDto.getAdresse();
        //set Pays France to Adresse
        Optional<PaysEntity> result1 = paysRepository.findById(paysId);
        PaysDto paysDto = modelMapper.map(result1.get(), PaysDto.class);
        adresseDto.setPays(paysDto);
        //set Date de Création Compte
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        usersDto.setDateCreationCompte(new Date());
        //Mapping AbonneEntity
        AbonneEntity abonneEntity = modelMapper.map(usersDto, AbonneEntity.class);
        //Set Role
        Optional<RoleEntity> result = roleRepository.findById(2L);
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(result.get());
        abonneEntity.setRoles(roles);
        //set Adresse
        abonneEntity.setAdresseEntity(modelMapper.map(adresseDto, AdresseEntity.class));
        //Save Abonne in DB
        abonneRepository.save(abonneEntity);
        //Map Return VAlue
        UsersDto returnValue = modelMapper.map(abonneEntity, UsersDto.class);
        return returnValue;
    }

    @Override
    public UsersDto createEmploye(UsersDto usersDto) {
        usersDto.setPublicId(UUID.randomUUID().toString());
//        usersDto.setEncryptedPassword(passwordEncoderHelper.encodePwd(usersDto.getEncryptedPassword()));

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        EmployeEntity employeEntity = modelMapper.map(usersDto, EmployeEntity.class);

        employeRepository.save(employeEntity);

        UsersDto returnValue = modelMapper.map(employeEntity, UsersDto.class);

        return returnValue;
    }

    @Override
    public UsersDto getUserDetailsByEmail(String email) {
        EmployeEntity employeEntity;
        AbonneEntity abonneEntity = abonneRepository.findByEmail(email);
        if (abonneEntity == null) {
            employeEntity = employeRepository.findByEmail(email);
            if (employeEntity == null) {
                throw new UsernameNotFoundException(email + " n'existe pas dans la base de données.");
            } else return new ModelMapper().map(employeEntity, UsersDto.class);
        }
        return new ModelMapper().map(abonneEntity, UsersDto.class);
    }

}
