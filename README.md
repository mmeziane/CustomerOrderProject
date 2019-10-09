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

## pom.xml file

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.9.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.mmeziane.demo</groupId>
	<artifactId>CustomerOrderProject</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>CustomerOrderProject</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.restdocs</groupId>
			<artifactId>spring-restdocs-mockmvc</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.asciidoctor</groupId>
				<artifactId>asciidoctor-maven-plugin</artifactId>
				<version>1.5.8</version>
				<executions>
					<execution>
						<id>generate-docs</id>
						<phase>prepare-package</phase>
						<goals>
							<goal>process-asciidoc</goal>
						</goals>
						<configuration>
							<backend>html</backend>
							<doctype>book</doctype>
						</configuration>
					</execution>
				</executions>
				<dependencies>
					<dependency>
						<groupId>org.springframework.restdocs</groupId>
						<artifactId>spring-restdocs-asciidoctor</artifactId>
						<version>${spring-restdocs.version}</version>
					</dependency>
				</dependencies>
			</plugin>
			<plugin>
		      <groupId>com.spotify</groupId>
		      <artifactId>docker-maven-plugin</artifactId>
		      <configuration>
		        <imageName>dockerboot</imageName>
		        <baseImage>java:8</baseImage>
		        <entryPoint>["java", "-jar", "/${project.build.finalName}.jar"]</entryPoint>
		        <!-- copy the service's jar file from target into the root directory of the image --> 
		        <resources>
		           <resource>
		             <targetPath>/</targetPath>
		             <directory>${project.build.directory}</directory>
		             <include>${project.build.finalName}.jar</include>
		           </resource>
		        </resources>
		      </configuration>
		    </plugin>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

