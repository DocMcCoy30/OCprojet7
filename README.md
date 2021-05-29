## OpenClassrooms Projet 7 - Developpeur d'Application Java

###Développez le nouveau système d’information de la bibliothèque d’une grande ville

*Créer une API web avec un microservice REST*

*Concevoir une application web avec une approche par composants*

*Respecter les bonnes pratiques de développement en vigueur*

*Sélectionner les langages de programmation adaptés pour le développement de l’application*

*Interagir avec des composants externes*


###Architecture du projet (microservice) : 

![](.README_images/26d22c6c.png)

###Documentation 
La documentation se trouve dans le dossier "1-Documents" : 
+ sql : structure et data de la base de données PostgreSQL
+ uml : diagrammes UML (classes, MPD, arborescence, usecase, activité)



###application.properties => modification de la configuration
+ configuration du port server :

![](.README_images/3844bc63.png)

+ configuration de la base de données (livre-service, utilisateur-service- emprunt-service) :

![](.README_images/5be63c66.png)



## Installation

IntelliJ = File -> New ->Project from Version Control

url : https://github.com/DocMcCoy30/OCprojet7.git

file : dossier de destination

ou

```
$ cd ../chemin/vers/le/dossier/de/destination
$ git clone https://github.com/DocMcCoy30/OCprojet7.git

$mvn install pour chaque service si nécessaire
```

## Demarrage des services



1- eureka-server

2- gateway-server

3- clientUI

4- utilsateur-service / livre-service / emprunt-service

Pour chaque service
```
$ cd ../path/to/the/file/target
$ java -jar nom-du-service.jar
```

## Utilisation et fonctionnalités

2 utilisateurs sont créés dans la base de données :
+ abonné : login : / password :
+ employé : login : / password :

Les nouveaux utilisateurs crées dans "s'inscrire" seront toujours des abonnés.

*Fonctionnalités d'un USER non connecté :*
+ s'inscrire / se connecter
+ effectuer une recherche
+ consulter le détail d'un livre

*Fonctionnalités d'un ABONNE connecté :*
+ consulter et modifier son profil
+ prolonger un emprunt

*Fonctionnalités d'un EMPLOYE connecté :*
+ enregistrer un emprunt
+ enregistrer un retour