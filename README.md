# CustomerOrderProject

## 4 Gebruikte tools en technologieën

* Spring boot 2+
* JDK 1.8+
* Maven 3+
* IDE - STS or Eclipse
* REST API
* Spring Data JPA
* Actuator
* Spring Security
* JSR303 Bean validation
* Spring REST Docs
* Docker Image (Dockerfile)

 
## 1 Wat ga ik bouwen

Ik ga een demo bouwen om informatie over alle customers en orders op teslaan.
We zullen een CRUD RESTFul API's bouwen voor een Simple Customer Management System met behulp van Spring Boot 2 JPA- en H2-database. Hierna worden vijf REST API's (Controller handler-methoden) gemaakt.

## 2 Business Rules


Een Customer kan nul of meer Orders hebben, terwijl een Order is aan één Customer  toegewezen. Een Customer heeft dus een One-to-Many relation met een Order, terwijl een Order een Many-to-One relatie heeft met de Customer.
De Order entity is gemapped aan de Customer door CUST_ID foreign key.
Het omgekeerde van Many-to-One relationship is One-to-Many relationship. De Customer entity omvat One-to-Many relationship.
De annotation @OneToMany  introduceert een nieuw attribute: fetch. Het standaard ophaaltype voor one-to-Many relationship is LAZY.


## 3 Database Schema


Om een dergelijke schema te implementeren, heb ik “Cust_id” attribute as foreign key in de tabel Order toegevoegd. Deze key is verantwoordelijk voor het bijhouden van welke customer de order heeft besteld.
![image](https://user-images.githubusercontent.com/36681851/66329651-27ae9b80-e92f-11e9-9512-7284d3f1c2f1.png)




![image](https://user-images.githubusercontent.com/36681851/66445775-418fd180-ea48-11e9-84a0-b90c2bb51f36.png)
