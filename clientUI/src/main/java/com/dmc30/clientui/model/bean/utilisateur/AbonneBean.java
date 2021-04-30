package com.dmc30.clientui.model.bean.utilisateur;

import com.dmc30.clientui.model.bean.bibliotheque.BibliothequeBean;
import com.dmc30.clientui.model.bean.bibliotheque.PretBean;
import com.dmc30.clientui.model.bean.commun.AdresseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AbonneBean {

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
    private String numAbonne;
    private BibliothequeBean bibliothequePrefere;
    private List<PretBean> prets;
}
