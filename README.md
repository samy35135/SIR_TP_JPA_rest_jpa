# SIR_TP_JPA_rest_jpa

SIR_JPA
=====================

/!\ Attention ce projet est lié au TP_angular, veuillez suivre les indications /!\
Une fois que la partie JPA - REST tourne, vous pouvez faire tourner l'application angular disponible ici :
https://github.com/samy35135/TP_SIR_ANGULAR


PARTIE - JPA - REST 
--------------------

Bienvenue dans ce magnifique projet représentant un mini-jeu à faire en TP.
Le projet n’est pas complet, nous avons essayé de montrer que nous étions capable de le produire en entier si nous avions assez de temps.


##### Présentation des packages :
`
###### client  
    ├─ Main.java  : Main de l’application, notamment appelé à par GenerateData  

###### dao  
    ├─ PersonDAO.java : Traite les requêtes JPA propre à Person  
 
###### metier  
    ├─ Chauffage.java  
    ├─ Equipement.java  
    ├─ FactoryData.java    : Permet de générer des données pour remplir la base  
    ├─ Home.java  
    ├─ PeripheriqueIntelligents.java     : Abstract class  
    ├─ Person.java  
    ├─ View.java  

###### rest : Représente les urls possibles d’accès aux données  
    ├─ Rest_Person.java       : Concerne l’accès aux urls de Person  
    ├─ Rest_Home.java         : Concerne l’accès aux urls de Home  
    ├─  GenerateData.java     : Permet de peupler la base  
`

##### Pour faire tourner le projet vous devez : 
- créer une Database « tp_sir_base »
- importer le projet git sous eclipse


##### Effectuer les modifications suivantes :
- Dans le persistence.xml (/src/main/java/resources/META-INF/) 
  sous "<!--  éléments à modifier —>"
- Mettre l’URL de votre base MYSQL à la place de « localhost:8889 » 
- Pensez à changer les identifiants d’accès à la base
- Attention au « update » à mettre en minuscule sous OSX. 

##### A ce stade le projet est prêt à tourner.
- `tomcat7:run`
- Aller dans l’url de votre navigateur à l’adresse indiquée par la console
- Ajouter "/rest/home" à l’url et un message devra apparaître.
- Peuplons la base : «/rest/generatedata/main » 
- Vous pouvez alors voir dans votre base les données enregistrés en base.
- Maintenant nous pouvons aussi la consulter via l’url : "rest/personne/id/1" 


Maintenant que ce TP marche, il vous reste  à mettre 20/20 !  



PARTIE JPA - SERVLET 
--------------------

Insérons un utilisateur en base de données :
- `tomcat7:run`
- La liste des personnes insérées dans la base à l'adresse : "http://localhost:8080/personneinfo".
- Aller à l'url "http://localhost:8080/myform.html"  et remplissez le formulaire. (il n'y a aucune vérification sur la saisie des champs), appuyer sur "send"
- Vous pouvez voir dans votre base le nouvel utilisateur.




