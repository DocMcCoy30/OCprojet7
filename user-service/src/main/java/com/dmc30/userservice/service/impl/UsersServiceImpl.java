package com.dmc30.userservice.service.impl;

import com.dmc30.userservice.data.entity.AdresseEntity;
import com.dmc30.userservice.data.entity.PaysEntity;
import com.dmc30.userservice.data.entity.RoleEntity;
import com.dmc30.userservice.data.entity.UtilisateurEntity;
import com.dmc30.userservice.data.repository.PaysRepository;
import com.dmc30.userservice.data.repository.RoleRepository;
import com.dmc30.userservice.data.repository.UtilisateurRepository;
import com.dmc30.userservice.service.contract.UsersService;
import com.dmc30.userservice.service.dto.AdresseDto;
import com.dmc30.userservice.service.dto.PaysDto;
import com.dmc30.userservice.service.dto.UtilisateurDto;
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

    UtilisateurRepository utilisateurRepository;
    RoleRepository roleRepository;
    PaysRepository paysRepository;

    @Autowired
    public UsersServiceImpl(UtilisateurRepository utilisateurRepository,
                            RoleRepository roleRepository,
                            PaysRepository paysRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.paysRepository = paysRepository;
    }

    /**
     * SpringSecutity Method
     *
     * @param email l'email de l'utilisateur
     * @return l'utilisateur et ses roles
     * @throws UsernameNotFoundException
     */
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

    /**
     * Creation d'un abonné dans la BD
     *
     * @param utilisateurDto les caractéristique de l'abonné
     * @param paysId         l'identifiant du pays de résidence
     * @return l'utilisateur créé
     */
    @Override
    public UtilisateurDto createAbonne(UtilisateurDto utilisateurDto, Long paysId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        utilisateurDto.setPublicId(UUID.randomUUID().toString());
        //get Adresse de l'abonné
        AdresseDto adresseDto = utilisateurDto.getAdresse();
        //set Date de Création Compte
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        utilisateurDto.setDateCreationCompte(new Date());
        //Set Numero d'abonné
        utilisateurDto.setNumAbonne(utilisateurDto.getPrenom().substring(0,2).toUpperCase() + utilisateurDto.getNom().substring(0,2).toUpperCase() + "-" + utilisateurDto.getPublicId().substring(0,4));
        logger.info("Numéro Abonné de " + utilisateurDto.getPrenom() + " " + utilisateurDto.getNom() + " = " + utilisateurDto.getNumAbonne());
        //Mapping AbonneEntity
        UtilisateurEntity utilisateurEntity = modelMapper.map(utilisateurDto, UtilisateurEntity.class);
        //Set Role
        Optional<RoleEntity> result = roleRepository.findById(2L);
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(result.get());
        utilisateurEntity.setRoles(roles);
        //set Adresse
        AdresseEntity adresseEntity = modelMapper.map(adresseDto, AdresseEntity.class);
        Optional<PaysEntity> result1 = paysRepository.findById(paysId);
        if (result.isPresent()) {
            PaysEntity paysEntity = result1.get();
            adresseEntity.setPaysEntity(paysEntity);
        }
        utilisateurEntity.setAdresse(adresseEntity);
        //Save Abonne in DB
        utilisateurRepository.save(utilisateurEntity);
        //Map Return VAlue
        UtilisateurDto returnValue = modelMapper.map(utilisateurEntity, UtilisateurDto.class);
        return returnValue;
    }

    @Override
    public UtilisateurDto getUtilisateurById(Long utilisateurId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UtilisateurDto utilisateurDto = modelMapper.map(utilisateurRepository.findUtilisateurById(utilisateurId), UtilisateurDto.class);
        return utilisateurDto;
    }

    /**
     * recherche un utilisateur par son email
     *
     * @param email l'email de l'utilisateur
     * @return l'utilisateur recherché
     */
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


    /**
     * recherche un utilisateur par son identifiant public (UUID)
     *
     * @param publicId l'identifiant de l'utilisateur
     * @return l'utilisateur recherché
     */
    @Override
    public UtilisateurDto getUtilisateurByPublicId(String publicId) {
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findByPublicId(publicId);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UtilisateurDto abonneDto = modelMapper.map(utilisateurEntity, UtilisateurDto.class);
        return abonneDto;
    }

    @Override
    public UtilisateurDto GetUtilisateurByUsername(String username) {
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findByUsername(username);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UtilisateurDto abonneDto = modelMapper.map(utilisateurEntity, UtilisateurDto.class);
        return abonneDto;
    }

    @Override
    public void updateUtilisateur(UtilisateurDto utilisateurDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UtilisateurEntity oldUser = utilisateurRepository.findByPublicId(utilisateurDto.getPublicId());
        UtilisateurDto newUserDto = modelMapper.map(oldUser, UtilisateurDto.class);
//        newUserDto.setUsername(utilisateurDto.getUsername());
        newUserDto.setPrenom(utilisateurDto.getPrenom());
        newUserDto.setNom(utilisateurDto.getNom());
        newUserDto.setEmail(utilisateurDto.getEmail());
        newUserDto.setNumTelephone(utilisateurDto.getNumTelephone());
        //Adresse
        AdresseDto newAdresse = newUserDto.getAdresse();
        newAdresse.setRue(utilisateurDto.getAdresse().getRue());
        newAdresse.setCodePostal(utilisateurDto.getAdresse().getCodePostal());
        newAdresse.setVille(utilisateurDto.getAdresse().getVille());
        AdresseEntity adresseEntity = modelMapper.map(newAdresse, AdresseEntity.class);
        adresseEntity.setId(oldUser.getAdresse().getId());
        adresseEntity.setPaysEntity(oldUser.getAdresse().getPaysEntity());
        UtilisateurEntity utilisateurEntity = modelMapper.map(newUserDto, UtilisateurEntity.class);
        utilisateurEntity.setUsername(oldUser.getUsername());
        utilisateurEntity.setId(oldUser.getId());
        utilisateurEntity.setRoles(oldUser.getRoles());
        utilisateurEntity.setAdresse(adresseEntity);
        utilisateurRepository.save(utilisateurEntity);
    }

    @Override
    public UtilisateurDto getUtilisateurByNumAbonne(String numAbonne) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UtilisateurEntity utilisateurEntity = utilisateurRepository.findUtilisateurByNumAbonne(numAbonne);
        return modelMapper.map(utilisateurEntity, UtilisateurDto.class);
    }

    @Override
    public List<UtilisateurDto> getUtilisateursByNumAbonne(String numAbonne) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UtilisateurDto> abonnesDto = new ArrayList<>();
        List<UtilisateurEntity> abonnes = utilisateurRepository.findUtilisateursByNumAbonne(numAbonne);
        for (UtilisateurEntity abonne:abonnes) {
            UtilisateurDto abonneDto = modelMapper.map(abonne, UtilisateurDto.class);
            abonnesDto.add(abonneDto);
        }
        return abonnesDto;
    }

    @Override
    public List<UtilisateurDto> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UtilisateurDto> abonnesDto = new ArrayList<>();
        List<UtilisateurEntity> abonnes = utilisateurRepository.findAll();
        for (UtilisateurEntity abonne:abonnes) {
            UtilisateurDto abonneDto = modelMapper.map(abonne, UtilisateurDto.class);
            abonnesDto.add(abonneDto);
        }
        return abonnesDto;
    }

}
