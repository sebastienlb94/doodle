# Programmation Web orienté mobile

Un site faisant office d'annuaire regroupant différent employer d'une societé.

----------------
## Membre de l'équipe 

- Andy Tagne
- Sébastien Soto
- Yannis Boughali

----------------
## Run 
----------------
## Stack technique
----------------
### Front-end : HTML/CSS/Jquery
----------------
### Back-end : Java

Storage : Base de donné Hibernet

----------------
### NB : 

Notre méthodologie de travail tout au long du projet était la suivante : deux personnes s’occupaient essentiellement des APIs avec une troisième personne en support en cas d’aide et cette dernière s’occupait essentiellement du Front. Certaines erreurs principalement dûes à des versions java pas compatibles ou à des erreurs avec Maven faisaient en sorte que pour certains projets, il n’y ait qu’une seule personne qui puisse travailler ; dans ce sens cette dernière faisait un partage d’écran avec les autres en support dans le cas où il commet des erreurs ou nécessite de se documenter.

## API 1 : Login


Notre objet User n’est constitué que d’un nom et d’un mot de passe.

Sur ce premier projet nous avons pour une première partie parfaitement réussie le login d’un utilisateur avec la création d’un token ; lorsqu’on a décidé d’améliorer notre projet en y intégrant l’authentification, nous avons eu des soucis avec notre Maven et malgré nos recherches intensives, bous n’avons pas pu découvrir d’où provenait l’erreur.

Vous pouvez voir ci-dessous des captures d’écran du fonctionnement de notre API sur le site POSTMAN.

| 1) GET Sécurité par le token|
|     :---:    |
|![Features](static/cap1.png)|

1) Il est impossible de faire un GET sur 127.0.0.1:8080/hello, l'accès est sécurisé par un tocken.

*Dispositif électronique que l'on transporte avec soi et qui sert à produire des codes ou des mots de passe à partir desquels l'appareil qui les reçoit peut reconnaître l'identité de la personne qui désire obtenir l'accès à un réseau, à un système ou à un ordinateur.*

| 2) POST login password|
|     :---:    |
|![Features](static/cap2.png)|

2) POST sur 127.0.0.1:8080/user si le user password est bon alors alors le tocken renvoi sur clé secret. Le tocken à un temps limité de 10 minutes.

| 3) Accès autoriser à l'api|
|     :---:     |
|![Features](static/cap3.png)|

3) GET sur 127.0.0.1:8080/hello possible grace à la clé secrete obtenu par le tocken seul les users autorisés on accès à cette api.

## End point
----------------
#API 2 : Gestion des utilisateurs

127.0.0.1:8080/employees : G elle reçois un login et un mots de passe et renvoie un token d'authentification qui pourra être utilisé pour identifier l'utilisateur sur les autres API


### Gestion des sondages 

127.0.0.1:8080/employees: GET l'api renvoi les objets employee stocker dans la class database

127.0.0.1:8080/employees/<int:id>: GET l'api renvoi l'objets employee dont l'ID correspond si l'api est vide alors message d'erreur

127.0.0.1:8080/employees: POST création d'un objets employee ajouter à l'api

127.0.0.1:8080/employees/<int:id>: PUT modifie l'objets employee dont l'ID correspond

----------------
##  Modèle de donnée

Employee :

- String : Nom
- String : Prénom
- String : Role
- String : Mail
- String : Site
- Int : Numero
----------------
## Maquette Web

