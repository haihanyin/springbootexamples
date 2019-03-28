## MVC is an abbreviation for a design pattern. What does it stand for and what is the idea behind it?
model-view-controller, separation of responsibilities
## Do you need spring-mvc.jar in your classpath or is it part of spring-core?
yes
## What is the DispatcherServlet and what is it used for?
DispatcherServlet is the entry point of all the requests. It directs the request to the corresponding servlet.

[An Intro to the Spring DispatcherServlet](https://www.baeldung.com/spring-dispatcherservlet)
[The dispatcherServlet](https://docs.spring.io/spring/docs/3.0.0.M3/reference/html/ch16s02.html)
 
## Is the DispatcherServlet instantiated via an application context?

load application context in spring mvc:
web.xml configs contextConfigLocation to refer to some applicationContext.xml/ context config class

## What is a web application context? What extra scopes does it offer?
Bean container which has web-related knowledge, such as, themes, mapping between servlet and urls.
Request, session, global
[Spring Web Contexts](https://www.baeldung.com/spring-web-contexts)

## What is the @Controller annotation used for?
Controller stereotype

## How is an incoming request mapped to a controller and mapped to a method?
request mapping on controller and methods (relative to controller mapping)

## What is the difference between @RequestMapping and @GetMapping?
@RequestMapping is more generic, it needs to specify http method

## What is @RequestParam used for?
map request parameter (GET/POST) to method parameter

## What are the differences between @RequestParam and @PathVariable?
@RequestParam is for parameters but @PathVariable is for url path

## What are some of the parameter types for a controller method?
request, response, 

### What other annotations might you use on a controller method parameter? (You can ignore form-handling annotations for this exam)
@PathVariable, @ModelAttribute, @RequestHeader, @RequestParam, @RequestBody

## What are some of the valid return types of a controller method?
## What is a View and what's the idea behind supporting different types of View?
## How is the right View chosen when it comes to the rendering phase?
## What is the Model?
## Why do you have access to the model in your View? Where does it come from?
## What is the purpose of the session scope?
## What is the default scope in the web context?
## Why are controllers testable artifacts?
## What does a ViewResolver do?