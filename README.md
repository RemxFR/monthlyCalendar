# MONTHLY CALENDAR - REST Controller

## Fonctionnement

Contrôleur Rest construit avec la jdk 1.8 et le Framework Spring.
Un Contrôleur reçoit les requêtes HTTP et en se basant sur la librairie personnelle CalendarLibJava, 
il renvoie un calendrier mensuel avec ou sans évènements.

## installation

### Avec docker
Il suffit d'être dans un terminal, dans le dossier monthlyCalendar et de lancer la commande : 
docker-compose up

Le projet se lancera automatiquement dans un conteneur docker et sera prêt à l'utilisation.
Niveau back, il n'y a rien à faire étant donné que les intéractions se font depuis la partie front.

### Sans docker
Pour faire fonctionner le projet, il faut clôner le dépôt, avoir la JDK 1.8 installer sur son ordinateur.
Puis lancer l'application directement via son IDE. 
Sur IntelliJ le serveur Apache TomCat déploiera directement l'application sur le port 8080.
Sur Eclipse il faudra configurer un serveur Apache Tomcat pour déployer l'application sur le port 8080 également pour 
correspondre à l'url inscrit dans la partie front.