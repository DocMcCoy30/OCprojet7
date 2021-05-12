package com.dmc30.userservice.service.impl;

import com.dmc30.userservice.data.entity.AdresseEntity;
import com.dmc30.userservice.data.entity.PaysEntity;
import com.dmc30.userservice.data.entity.RoleEntity;
import com.dmc30.userservice.data.entity.UtilisateurEntity;
import com.dmc30.userservice.data.repository.PaysRepository;
import com.dmc30.userservice.data.repository.RoleRepository;
import com.dmc30.userservice.data.repository.UtilisateurRepository;
import com.dmc30.userservice.security.PasswordEncoderHelper;
import com.dmc30.userservice.service.contract.UsersService;
import com.dmc30.userservice.shared.AdresseDto;
import com.dmc30.userservice.shared.PaysDto;
import com.dmc30.userservice.shared.UtilisateurDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    private UtilisateurRepository utilisateurRepository;
    private RoleRepository roleRepository;
    private PaysRepository paysRepository;
    private PasswordEncoderHelper passwordEncoderHelper;

    @Autowired
    public UsersServiceImpl(UtilisateurRepository utilisateurRepository,
                            RoleRepository roleRepository,
                            PaysRepository paysRepository,
                            PasswordEncoderHelper passwordEncoderHelper) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.paysRepository = paysRepository;
        this.passwordEncoderHelper = passwordEncoderHelper;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findByEmail(email);
        List<GrantedAuthority> authorities = utilisateurEntity.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
        if (utilisateurEntity == null) {
            throw new UsernameNotFoundException(email + " n'existe pas dans la base de données.");
        } else return new User(utilisateurEntity.getEmail(),
                utilisateurEntity.getEncryptedPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }

    @Override
    public UtilisateurDto createAbonne(UtilisateurDto utilisateurDto, Long paysId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        utilisateurDto.setPublicId(UUID.randomUUID().toString());
        //get Adresse de l'abonné
        AdresseDto adresseDto = utilisateurDto.getAdresse();
        //set Pays France to Adresse
        Optional<PaysEntity> result1 = paysRepository.findById(paysId);
        PaysDto paysDto = modelMapper.map(result1.get(), PaysDto.class);
        adresseDto.setPays(paysDto);
        //set Date de Création Compte
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        utilisateurDto.setDateCreationCompte(new Date());
        //Mapping AbonneEntity
        UtilisateurEntity utilisateurEntity = modelMapper.map(utilisateurDto, UtilisateurEntity.class);
        //Set Role
        Optional<RoleEntity> result = roleRepository.findById(2L);
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(result.get());
        utilisateurEntity.setRoles(roles);
        //set Adresse
        utilisateurEntity.setAdresse(modelMapper.map(adresseDto, AdresseEntity.class));
        //Save Abonne in DB
        utilisateurRepository.save(utilisateurEntity);
        //Map Return VAlue
        UtilisateurDto returnValue = modelMapper.map(utilisateurEntity, UtilisateurDto.class);
        return returnValue;
    }

    @Override
    public UtilisateurDto getUserDetailsByEmail(String email) {
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findByEmail(email);
        logger.info("AbonneEntity in getUserByEmail " + utilisateurEntity.toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if (utilisateurEntity == null) {
            throw new UsernameNotFoundException(email + " n'existe pas dans la base de données.");
        }
        return modelMapper.map(utilisateurEntity, UtilisateurDto.class);
    }


    @Override
    public UtilisateurDto getUtilisateurByPublicId(String publicId) {
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findByPublicId(publicId);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UtilisateurDto abonneDto = modelMapper.map(utilisateurEntity, UtilisateurDto.class);
        return abonneDto;
    }

}