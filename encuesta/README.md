# Title of the project

_service to create survey to get feedback from your customers._

## Starting 🚀

_You can find the documentation to consume the api in the following location:_
* http://localhost:9000/swagger-ui/index.html#/survey-controller
* url post 
 - http://localhost:9000/robinfood
 - body: {"question": [{"optionAnswer": [{"id": "a", "value": "coffe"}, {"id": "b", "value": "yellow"}, {"id": "c", "value": "red"}], "questionType": "multi", "questionSurvey": "what is color the lion"}, {"optionAnswer": [{"id": "a", "value": "coffe"}, {"id": "b", "value": "yellow"}, {"id": "c", "value": "red"}], "questionType": "multi", "questionSurvey": "what is color the tiger"}, {"optionAnswer": [{"id": "1", "value": ""}], "questionType": "open", "questionSurvey": "what is color the tiger"}], "nameSurvey": "Animales", "descriptionSurvey": "for view animals"}

* url get 
  - http://localhost:9000/robinfood/consult/Animales


### Pre requirements 📋

* Have java 11 installed
* install MySQL version 8 database and run the following script to create the table

* CREATE TABLE SURVEY(
  IDSURVEY INT(10)  AUTO_INCREMENT PRIMARY KEY,
  DESCRIPTION VARCHAR(200) NULL,
  NAME VARCHAR(30) NOT NULL,
  REG_DATE TIMESTAMP
  );

* CREATE TABLE QUESTION(
IDQUESTION INT(10) AUTO_INCREMENT PRIMARY KEY,
QUESTION_SURVEY JSON,
REG_DATE TIMESTAMP
);

* CREATE TABLE QUESTION_SURVEY(
IDQUESTION_SURVEY INT(10) AUTO_INCREMENT PRIMARY KEY,
QUESTIONFK INT(10),
SURVEYFK INT(10),
INDEX(SURVEYFK),
FOREIGN KEY (QUESTIONFK) REFERENCES QUESTION(IDQUESTION),
FOREIGN KEY (SURVEYFK) REFERENCES SURVEY(IDSURVEY)
);



## Running the tests ⚙️

_This project has acceptance tests developed with the soap ui, to run the tests you must have the aforementioned applications installed and import the projects that you will find in the encuesta / TestPruebaAceptacion folder_


## Deployment 📦

_To deploy the application you must take into account send the profile to be used by java arg, example -Dspring.profiles.active = dev_

* The database is mounted in aws for greater ease and not having to use external applications to have to configure the database.

## Built with 🛠️

* [Spring boot](https://spring.io/guides#getting-started-guides) - framework used
* [gradle](https://docs.gradle.org/current/userguide/userguide.html) - Dependency manager
* [Java](https://docs.oracle.com/en/java/javase/11/) - Programming language

## Author ✒️

* **Juan David Arcila Campaz** - *Work Starts* - [JuanArcila](https://co.linkedin.com/in/juan-david-arcila-campaz-a5799657)


## Expressions of Gratitude 🎁

* I want to thank the free market team for the opportunity to present this project.

