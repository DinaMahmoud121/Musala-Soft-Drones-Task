# Musala-Soft-Drones-Task

### Requirments:

[Drones-v1.pdf](https://github.com/DinaMahmoud121/Musala-Soft-Drones-Task/files/11361787/Drones-v1.pdf)

### Tools used:
  * Spring boot 3
  * Java 17
  * Swagger
  * H2 database
  * Hibernate

## To Run the Spring boot application:
```
* you can use Buildpacks and run it in docker, use: mvn spring-boot:build-image
* you can run it locally, you just need java 17 and maven.
* in Intellij add "--add-opens java.base/java.lang=ALL-UNNAMED" to maven configuration.
![image](https://user-images.githubusercontent.com/79382156/235365699-12257473-18ac-47af-a8c1-bb79cb8a4814.png)
![image](https://user-images.githubusercontent.com/79382156/235365795-8e4e2dfa-9ba6-4084-9e07-29c7f9a04282.png)
![image](https://user-images.githubusercontent.com/79382156/235365874-aa92ae07-ff38-4bbe-9bbb-2f17f6f3168e.png)
![image](https://user-images.githubusercontent.com/79382156/235365938-c1f99a59-0109-441c-ad05-dabd83061acc.png)

```

## to test the app: 
```
to access swagger: localhost:8080/swagger-ui.htm
to access h2 DB console: http://localhost:8080/h2-console
db username: sa
no db password(leave it empty)
```
