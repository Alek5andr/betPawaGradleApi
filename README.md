# Test execution
* Clone project as Gradle project
* Execute Gradle building to import dependencies
* Navigate to project's directory using Terminal

## 2 options to run tests
### 1st option
* Change value of _immediateFlush_ to _true_ in Log4j2 configuration file _src/main/resources/log4j2.xml_ to log tests' info to _logs/log.log_ file
* Execute command ```gradlew check```

### 2nd option
* Execute command ```gradlew check -i```

# Describe...
> what else you would like to test, but was unable to do this because there is not enough information provided in this test assignment or this just was not requested by this test assignment.

Test candidates:
* POST callback request
* Responses' check for invalid:
  * _payoutId_ for "/payouts/{payoutId}" endpoint (GET)
  * JSON body for "/payouts" endpoint (POST)
    * Schema
    * Parameters' type
    * Arbitrary long values

Improvement ideas:
* Implement (find out?) a possibility to merge JSON objects in order to test different occasions, where JSON objects share common part
* Extract value from request
  * Value usage in response body
  * Save value and compose new JSON-file with the value inside
* Since it's first time Gradle usage, there is a room for studying its possibilities further