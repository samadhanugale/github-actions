FROM openjdk:11
EXPOSE 8090
ADD target/springboot-dynamodb-cicd-github-actions.jar springboot-dynamodb-cicd-github-actions.jar
ENTRYPOINT ["java","-jar","springboot-dynamodb-cicd-github-actions.jar"]