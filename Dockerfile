FROM eclipse-temurin:11-jre
COPY target/demo*.jar /usr/src/demo.jar
COPY src/main/resources/application.properties /opt/conf/application.properties
CMD ["java", "-jar", "/usr/src/demo.jar", "--spring.config.location=file:/opt/conf/application.properties"]