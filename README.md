# ManagementLibrary
P7 - OCR Gestion d'un bibliothèque d'une grande ville
---
Description :

    Client UI : module library
    3 Microservices : modules mbooks, mfile et musers
    Edge service : module config-server , eureka-server
    Gateway : module zuul-server
    - authentification basic : user = utilisateur - password = mdp
    Properties : https://github.com/RomainDavidS/ManagementLibrary.git
    Base de donées : postgresql pour tous les microservices
    - mfile : user = adm_file - password = root
    - mbooks : user = adm_books - password = root
    - musers : user = adm_user - password = root   
    
---

### Etapes de déploiement

    Attention bien suivre l'ordre de déploiement

#### Etape 1 - Les edges service
    1 - déployer config-server
    2 - déployer eureka-server
    3 - déployer zuul-server
---
#### Etape 2 - Les services
    1 - déployer springadmin
    2 - déployer mbooks
    3 - déployer mfile :
        Après le déploiement de mfile il faudra depuis pgadmin réaliser un backup (option : only-data)
        de data-dump.sql présent dans le répertoire resources du microservice
    4 - déployer musers 
    5 - déployer library




