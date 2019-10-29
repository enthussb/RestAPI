# RestAPI
RestAPI to catch a JSON response and store in MySQL database or retrieve data from MySQL database in JSON format.
<p align ="center"><img src = "https://raw.githubusercontent.com/enthussb/RestAPI/master/RestAPI.jpg"></p>  

This project contains a sample customer model which can be changed as per the application's needs.\
There are two tables -
- records - Contains the data which was stored previously and used to get JSON response.
- records1 - Used to save the data received as JSON response.

## Development Environment
- JDK 8
- Mysql Server
- Eclipse IDE with web tools platform package
- Required JARs
  - mysql-connector-java-5.1.46
  - Jersey JAX-RS 2.1 RI bundle
  - gson-2.2.2
- Apache Tomcat v8.5

## Database Schema
```
CREATE TABLE `records` (
  `Cust_name` varchar(50) DEFAULT NULL,
  `Cust_phone_no` bigint(20) DEFAULT NULL,
  `Cust_city` varchar(30) DEFAULT NULL,
  `Cust_country` varchar(35) DEFAULT NULL
)

CREATE TABLE `records1` (
  `Cust_name` varchar(50) DEFAULT NULL,
  `Cust_phone_no` bigint(20) DEFAULT NULL,
  `Cust_city` varchar(30) DEFAULT NULL,
  `Cust_country` varchar(35) DEFAULT NULL
)
```

## Steps to deploy RestAPI on Tomcat Server:
1. Export the web project as Web Archive file (WAR)
2. Add the war file to web apps folder of tomcat
3. Start tomcat and MySQL server
4. Navigate to the URL - `http://localhost:8080/RestAPI/api/*`  where * can be **storeJSON** or **getJSON**  
Two functions - storeJSON and getJSON to store and retrieve respectively.
5. Check the browser and the database for the results
