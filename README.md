# Springboot-MongoDb-CRUD-islemler

<h2>Overview</h2>

 * Spring Boot is an opinionated, convention-over-configuration focused addition to the Spring platform – highly useful to get started with minimum effort and create stand-alone, production-grade applications. This tutorial is a starting point for Boot – a way to get started in a simple manner, with a basic web application.

 * In this application, insertion deletion reading and update operations are performed.
 
 <h2>How to run the application?</h2>
 
  * You must have mongoDbinstalled on the computer.
  
  * The application.properties file is below. If your setting are different, change from the application.properties file.
  
        spring.data.mongodb.host=localhost
        spring.data.mongodb.port=27017
        spring.data.mongodb.database=example
        
 * For example : Request Body
 
        {
           "userFirstName" : "firstNameUser",
           "userLastName" : "lastNameUser",
           "userIdentityNumber" : "indentityNumberUser",
           "userNationality" : "nationalityUser",
           "userAge" : "userAge",
           "userPhoneNum" : "phoneNumUser"
        }
        
     Send Post Request;
     Address : http://localhost:8080/user/add
     

 * For Example :

     Send Get Request;
     Address : http://localhost:8080/user/getuserbyid?userid=1
     
 
 <h2>Used Technologies</h2>
 
 * Java 8
 
 * Spring Boot
 
 * MongoDb
 
 * Gradle
