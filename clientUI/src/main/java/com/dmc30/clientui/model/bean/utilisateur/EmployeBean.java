package com.dmc30.clientui.model.bean.utilisateur;

import com.dmc30.clientui.model.bean.commun.AdresseBean;

import java.util.Date;
import java.util.List;

public class EmployeBean {

    private int id;
    private String username;
    private String prenom;
    private String nom;
    private String email;
    private String password;
    private String numTelephone;
    private AdresseBean adresse;
    private List<RoleBean> roles;
    private Date dateCreationCompte;
    private String matricule;
    private Date dateEntree;
    private Date dateSortie;
}
