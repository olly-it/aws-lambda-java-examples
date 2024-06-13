# simple lambda function (with spring-boot)

# build
mvn package -DskipTests

# lambda - handler
lambda handler on aws web console has to be configured as:
``it.olly.lambda.ollyplayground.MainHandler::handleRequest``


# test
tests can be done by passing directly the json inside aws-console -> lambda -> tests


tests can be done also with junit