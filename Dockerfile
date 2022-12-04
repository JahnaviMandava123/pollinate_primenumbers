FROM openjdk:11
ADD target/primenumbers-0.0.1-SNAPSHOT.jar primenumbers.jar
ENTRYPOINT ["java", "-jar", "primenumbers.jar"]