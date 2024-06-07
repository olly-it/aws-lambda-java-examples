# simple lambda function (with spring context, managing HTTP requests)
see: https://www.baeldung.com/spring-boot-aws-lambda

NOTE: an ApiGateway proxy is not needed. a simple "http"-enabled lambda can be created (with function URL)

# build
mvn package

# lambda - handler
lambda handler on aws web console has to be configured as:
``com.enginius.lambda.ollyplayground.http.awshandler.LambdaHandler::handleRequest``

# test
tests can be done by calling via HTTP the <function URL>/your-defined-path-inside-controllers
