<h1>
  <img src="http://haeralis.com/includes/img/home/logo-default-web.png" alt="Haeralis">
</h1>

# Cyberpunk Clone Tools App (Angular 5/Spring Boot)

  This is a simple Angular/Spring Boot application created for the Solutis Talent Sprint 2018, city of Salvador, Brazil.
  It provides a CRUD that's made with Angular 5 in the front-end, as well as Bootstrap 4 and other necessary tools.
  In the back-end it has an api developed with Spring Boot and JPA frameworks using Java 8, it also saves and retrieve data from a H2 in memory database.

# Getting started

## For [haeralis-cp-api](haeralis-cp-api) (Spring Boot - Java 8)

Make sure you have [JDK 8 or higher](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) installed.

Make sure you have [Maven](https://maven.apache.org/download.cgi) installed.

Download and unpack [Spring Tools Suit](https://spring.io/tools/sts/all).

Import the project [haeralis-cp-api](haeralis-cp-api) into STS.

Run Maven -> Update on STS to download all maven dependencies for the project.

After all, run the application on the STS Local Server.
(Make sure the server is running on port :8080, because the app [haeralis-cp-ui](haeralis-cp-ui) will look for it. If not, you'll need to change the port number on the '...service.ts' files)


## For [haeralis-cp-ui](haeralis-cp-ui) (Angular 5)

Make sure you have the [Angular CLI](https://github.com/angular/angular-cli#installation) installed globally, navigate to project folder then run `npm install` to resolve all dependencies (might take a minute).

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/` and enjoy!
The app will automatically reload if you change any of the source files.


## Functionality overview

- Menu navigation with routes
- List Attributes and Display on Table
- Create new, and Delete existent Attributes
- List Default Models that can be Cloned
- CRUD existent Clones
- Add additional Attributes to Clones

## Author

**[Haeralis](mailto:gledson@haeralis.com) (aka GledsonMotta)** - [Linkedin](https://www.linkedin.com/in/gledson-motta-03a3312b/)

**[Gmail](mailto:gledsonivomotta@gmail.com)**  - gledsonivomotta@gmail.com


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

