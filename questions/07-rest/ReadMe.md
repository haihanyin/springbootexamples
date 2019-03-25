## What does REST stand for?
Representational State Transfer.

## What is a resource?


## What does CRUD mean?
Create, read, update, delete

## Is REST secure? What can you do to secure it?
No.
- https
- authentication and authorization
- JWT
- Access control
- API keys
- Input validation/ content types
- Security headers: nosniff, cors
- Return code restrictions

[REST Security Cheat Sheet](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/REST_Security_Cheat_Sheet.md)

## What are safe REST operations?
Safe operations have zero side effect.
GET, HEAD, OPTIONS are safe operations.

[What are idempotent and/or safe methods?](http://restcookbook.com/HTTP%20Methods/idempotency/)
[Idempotent and Safe HTTP Methods - Why Do They Matter?](https://codeahoy.com/2016/06/30/idempotent-and-safe-http-methods-why-do-they-matter/)

## What are idempotent operations? Why is idempotency important?
"idempotent" means whether the operation can be repeatedly executed without
changing the end status of the operation.

Idempotent operations are GET, HEAD, OPTIONS, PUT, DELETE 

## Is REST scalable and/or interoperable?
??

## Which HTTP methods does REST use?
[Using HTTP Methods for RESTful Services](https://www.restapitutorial.com/lessons/httpmethods.html)

## What is an HttpMessageConverter?
It serialize response and deserialize input from/to text. 

[Http Message Converters with the Spring Framework](https://www.baeldung.com/spring-httpmessageconverter-rest)

## Is REST normally stateless?
Yes

## What does @RequestMapping do?
Map url to endpoint (methods in controller)

## Is @Controller a stereotype? Is @RestController a stereotype?
Yes.
@RestController is a combination of @Controller and @ResponseBody

### What is a stereotype annotation? What does that mean?
stereotype annotation gives the role information of a bean.

## What is the difference between @Controller and @RestController?
@Controller is designed for mvc. By default, the response returns view.
@RestController is designed for rest. By default, the response returns text, such as, json.

## When do you need @ResponseBody?
By pass view resolver, serialize responsed object to text and put it to response.
[Spring’s RequestBody and ResponseBody Annotations](https://www.baeldung.com/spring-request-response-body)

## What does @PathVariable do?
Maps variable in path into parameter of method

## What are the HTTP status return codes for a successful GET, POST, PUT or DELETE operation?
top used status code
- 200 ok
- 201 created
- 204 no content
- 400 bad request
- 401 unauthorized
- 403 forbidden
- 404 not found
- 500 internal server error

[Using HTTP Methods for RESTful Services](https://www.restapitutorial.com/lessons/httpmethods.html)

## When do you need @ResponseStatus?
controller method
exception handler
[Using Spring @ResponseStatus to Set HTTP Status Code](https://www.baeldung.com/spring-response-status)

## Where do you need @ResponseBody? What about @RequestBody? Try not to get these muddled up!
Automatically serialize and deserialize request body and response body.

## If you saw example Controller code, would you understand what it is doing? Could you tell if it was annotated correctly?

## Do you need Spring MVC in your classpath?
## What Spring Boot starter would you use for a Spring REST application?
spring-boot-starter-web

## What are the advantages of the RestTemplate?
client side to call rest apis

[The Guide to RestTemplate](https://www.baeldung.com/rest-template)

## If you saw an example using RestTemplate would you understand what it is doing?