# simple lambda function (with spring context for spring-cloud-functions)
see: https://docs.spring.io/spring-cloud-function/reference/adapters/aws-intro.html

# build
mvn package

upload then the *-aws.jar file

# lambda - handler
lambda handler on aws web console has to be configured as:
``org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest``

# test
tests can be done by passing directly the json inside aws-console -> lambda -> tests
