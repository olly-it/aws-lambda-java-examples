# simple lambda function (non-spring, managing http calls)

NOTE: an ApiGateway proxy is not needed. a simple "http"-enabled lambda can be created (with function URL)

# build
mvn package

# lambda - handler
lambda handler on aws web console has to be configured as:
``it.olly.lambda.ollyplayground.TestHandler::handleRequest``

NOTE: [function] URL must be enabled on lambda

# test
tests can be done by calling via HTTP the <function URL>/path?parameters
