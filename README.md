# fourthwall-movie-db
A simple REST API application made in Spring Boot Starter.
I am using Spring Boot Start with REST-API and Websockets on everyday basis.

I am also using Redis in my everyday job, that is why Redis was chosen as the DB for this solution.

The layers has been divided to controllers (with separate model classes),
business logic (with separate model classes)
and database layer.

I have decided to used Docker with Docker-compose to provide an easy to setup solution.

In order to get the OpenMovie DB Rest API working,
please set an OMDBKEY environment variable.

For an out of the box experience, please
 - set the environment variable
 - run mvn clean install and confirm all tests are passing
 - run docker build -t movie-db .
 - run docker-compose up -d

All the movie id's in the initialized DB match the OMDB movie ids.