# simple lambda function (non-spring)
see: https://docs.aws.amazon.com/lambda/latest/dg/java-package.html

# build
mvn package

# lambda - handler
lambda handler on aws web console has to be configured as:
``it.olly.lambda.ollyplayground.TestHandler::handleRequest``

# test
tests can be done by passing directly the json inside aws-console -> lambda -> tests
