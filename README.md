# Welcome to EmployeeBenefits Service

## Current version 1.0.0

## Microservice purpose:
This microservice totals employee's weekly benefit witholdings.

## ROUTES
- http://localhost:8099/
- **EUREKA SERVICE NAME**: EMPBENEFITS
## Currently supported APIs:
- /empBenefits/info
- /empBenefits/getbenefits

## Message formats and error handling
This microservice uses JSON for all input and output messages.
It uses POST methods.

## Sample input and output

- /empBenefits/getbenefits

Method: POST

**Input JSON:**
------------------------------------------------------------------
~~~
{
    "employeeId": "11111"
}
~~~
------------------------------------------------------------------

**Output JSON:**
------------------------------------------------------------------
~~~
{
    "employeeId": 11111,
    "totalWitholdings":  125,
    "currency": "USD"
}
~~~
------------------------------------------------------------------

**Error JSON:**
------------------------------------------------------------------
~~~
{
    "employeeId": 11111
    "errorMsg": "NOT_FOUND"
}
~~~
------------------------------------------------------------------

### Guides
The following guides illustrates how to use certain features correctly:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
