[spring-security-interview-questions-and-answers](https://www.dineshonjava.com/spring-security-interview-questions-and-answers/#11)
[Spring Security Reference](https://docs.spring.io/spring-security/site/docs/4.2.x/reference/html/)
## What are authentication and authorization? Which must come first?
authentication - who are you
authorization - what are you

## Is security a cross cutting concern? How is it implemented internally?
Yes. By filters.

## What is the delegating filter proxy?
A proxy filter which delegates requests to spring-aware filters 

## What is the security filter chain?
A chain of filters for security.

## What is a security context?


## Why do you need the intercept-url?


## In which order do you have to write multiple intercept-url's?
more specific one first

## What does the ** pattern in an antMatcher or mvcMatcher do?
## Why is an mvcMatcher more secure than an antMatcher?

## Does Spring Security support password hashing? What is salting?
yes, salting is adding a random number in hashing

## Why do you need method security? What type of object is typically secured at the method level (think of its purpose not its Java type).


## What do @PreAuthorized and @RolesAllowed do? What is the difference between them?
### What does Spring’s @Secured do?
@Secured specifies a list of roles, for example, @Secured({ "ROLE_VIEWER", "ROLE_EDITOR" })
@RoleAllowed is equivalent to @Secured in JSR-250
@PreAuthorize supports SpEL, for example, @PreAuthorize("hasRole('ROLE_VIEWER')")

[Introduction to Spring Method Security](https://www.baeldung.com/spring-security-method-security)

### How are these annotations implemented?
AOP

### In which security annotation are you allowed to use SpEL?
@PreAuthorized, @PostAuthorized

## Is it enough to hide sections of my output (e.g. JSP-Page or Mustache template)?
### Spring security offers a security tag library for JSP, would you recognize it if you saw it in an example?