# MailAnalyseApplication

## Test technique 

### Sujet 1 : 

Interroger l’API Microsoft Graph pour récupérer les données liées aux mails et les 
sauvegarder dans une base de données NoSQL. 
Pour cela tu as à disposition une application Microsoft pour interroger l'API Microsoft graph, 
une passerelle qui te permettra d’accéder aux données mail liées au compte de test 
Microsoft. 

Tu auras besoin de ces identifiants pour autoriser l'accès aux données: 

* clientId: dc516f84-9366-4edc-9c0a-8e038c26bd4b 
* clientSecret: beD7Q~rHtuvjVmN410Sve1zF5l4anOz615Jvf 
* tenant: d5d99b8a-61b5-40bd-975a-923eca104608 

Technos à utiliser: Java/Spring boot pour l'api REST, Mongodb pour la base de données 

### Sujet 2 (optionnel): 

Afficher l’évolution du nombre de mails envoyés sur un graphique. 
Technos à utiliser: React pour l'interface et ChartJs pour les graphique de préférence

## Pour commencer

Entrez ici les instructions pour bien débuter avec votre projet...

### Pré-requis

- Java 16
- Maven 3.8
- Node 16
- Yarn 1.22
- mongodb 5

### Installation

Executez la commande ``yarn install`` dans le repertoire frontend

Executez la commande ``mvn install`` dans le repertoire backend

## Démarrage


Executez la commande ``yarn start`` dans le repertoire frontend

Executez la commande ``java -jar MailAnalyseApplication-0.0.1-SNAPSHOT.jar `` dans le repertoire backend

## Dépendances et outils
Backend Généré avec [Spring Initialz](https://start.spring.io/) 

Dépendances Back :
* [Spring Boot](https://spring.io/projects/spring-boot) - Starter et configuration
* [Spring Data REST](https://spring.io/projects/spring-data) - Framework for Data Acess
* [Spring Security](https://spring.io/projects/spring-security) - Framework for Web Security Manager
* [Spring Web](https://mdbootstrap.com/docs/react) - Framework for REST Api 
* [Lombok](https://projectlombok.org/setup/maven) - Pojo utilitaire
* [Microsoft Graph](https://docs.microsoft.com/fr-fr/graph/tutorials/java) - Microsoft Email API Test

Dépendances Front :  
* [MDBootstrap](https://mdbootstrap.com/docs/react) - Framework CSS (front-end)
* moment js pour la gestions des dates
* react-chartjs pour l'afichage de graphs 
* redux pour la gestion des données dans un store 
* redux-dev-tool pour l'analyze du store dans le navigateur 
* react-router-dom pour la gestion des urls et la navigation 
* redux-thunk pour faciliter l'usage et l'écriture des events redux


