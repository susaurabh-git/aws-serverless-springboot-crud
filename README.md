# aws-serverless-springboot-crud

This is sample Springboot implementation with AWS Lambda and serverless framework.

## Pre-requisites
- java 11+
- maven 3.6+
- AWS CLI  
- Serverless framework CLI

## Build
Run following command to build and package
```
mvn clean package
```
## Deployment
Run following command to deploy the application in AWS.
```
serverless deploy
```
NOTE: AWS profile must be configured before running it. Use "aws configure" to configure.

Once the deployment is successful then it will provide the application URL. 
you can use CURL or postman to test application.

sample URL : https://xxxxxxxxx.execute-api.{region}.amazonaws.com/dev/users/

#### References:

- https://github.com/awslabs/aws-serverless-java-container
