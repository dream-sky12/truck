# Food Truck

The repository contains some basic APIs to get food trucks information of San Francisco.

Author: Zhang Zhe, Dream_Sky12@hotmail.com

## Table of Contents
- [Overview](#overview)
- [Develop Guide](#developguide)
- [Build / Deploy](#build)
- [Access Data](#access)
- [Notes](#notes)

## Overview

This project mainly focuses on getting data of food trucks of San Francisco which are open data online.

## Develop Guide

This is a Spring boot project with Maven based on Java 8. When the application runs, it will send GET request to get data from offical data URL: https://data.sfgov.org/resource/rqzj-sfat.json

Steps for development:

1. Get project from Github via git.
   ```sh
   git clone git@github.com:dream-sky12/truck.git
   ```
2. You must have installed JDK 8+ and Maven.   
   
3. Currently, there are 5 APIs for user/endpoint to call. 
   - Get all trucks data  
     Request Path: `/truck/all`
   
   - Get truck by id
     Request Path: `/truck/objectid?id={id}` OR `/truck/locationid?id={id}`  
     Example: `/truck/objectid?id=735318`

   - Get trucks by applicant  
     Request Path: `/truck/applicant?applicant={applicant}`  
     Example: `/truck/applicant?applicant=Ziaurehman+Amini`
  
   - Get trucks by FacilityType  
     Request Path: `/truck/type?type={type}`  
     Example: `/truck/type?type=Truck`
   
   - Get trucks by Status
     Request Path: `/truck/status?status={status}`  
     Example: `/truck/type?type=REQUESTED`

3. Directly run in command
   
   - For Windows
     ```sh
     mvnw spring-boot:run
     ```
   - For Linux / MacOS
     ```sh
     ./mvnw spring-boot:run
     ```
 


## Build / Deploy

### Build
- For Windows 

  ```sh
  mvnw clean package
  ```

- For Linux / MacOS

  ```sh
  ./mvnw clean package
  ```

### Directly run without Docker

   ```sh
   java -jar target/truck-0.0.1-SNAPSHOT.jar
   ```

### Deploy in Docker and run

First, go to the directory of the project.  
Use image of openjdk 8, if the image does not exist, please pull it from hub by running the command:  
```sh
docker image pull openjdk:8
```
Then build a image for the application: 
```sh
docker build -t app .
```  
Start the image and run the application: 
```sh
docker run -p 8181:8080 app
```
The application run on port 8181 on your host computer.

## Access Data

- If you directly run the application without docker
  
  Please send GET request to `localhost:8080/{Path}`  
  Example: Send GET request to `localhost:8080/trucks/all` to get all trucks data.

- If you deploy in docker and run in docker

  On your host computer/server, please send GET request to `localhost:8181/{Path}`
  Example: Send GET request to `localhost:8181/trucks/all` to get all trucks data.

## Notes

- For get truck by id, it will return ONE truck or NULL.

- For other requests, it will return a list of trucks or Empty list.

## Owner and Maintainer

- Zhang Zhe, Email: Dream_Sky12@hotmail.com 




