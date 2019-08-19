## What is the concept of AOP? Which problem does it solve? What is a cross cutting concern?
Modularization the cross-cutting concerns.
A cross-cutting concern is a concern that spreaded around the entire application.  

### Name three typical cross cutting concerns.
Logging, security, transaction, caching, error handling, persistence, bean management.

### What two problems arise if you don't solve a cross cutting concern via AOP?
repeated functionalities spreaded all over around
component are less reusable, 
readability is decreased, main business logic is blurred

## What is a pointcut, a join point, an advice, an aspect, weaving?
a pointcut is a point in the static program, such as a method
a joinpoint is a point in the running program, such as calling a method
a advice is an action on the joinpoint
an aspect represents a cross-cutting concern
weaving is the process of merging the execution of advices and the main application code.

## How does Spring solve (implement) a cross cutting concern?
cglib proxy, jdk dynamic proxy

## Which are the limitations of the two proxy-types?
### What visibility must Spring bean methods have to be proxied using Spring AOP?
proxy only works on external public calls,
proxy object must be instantiated by spring container

jdk proxy:
proxied object must implement interface

cglib proxy:
class and method cannot be final
need to have default constructor
proxy is final

## How many advice types does Spring support. Can you name each one?
### What are they used for?
before, around, after, afterReturning, afterThrowing

### Which two advices can you use if you would like to try and catch exceptions?
around, afterThrowing

## What do you have to do to enable the detection of the @Aspect annotation?
### What does @EnableAspectJAutoProxy do?
use `<aop:aspectj-autoproxy />` or @EnableAspectJAutoProxy

## If shown pointcut expressions, would you understand them?
### For example, in the course we matched getter methods on Spring Beans, what would be the correct pointcut expression to match both getter and setter methods?

## What is the JoinPoint argument used for?
to get the information, e.g., method signature, parameter values etc.,

## What is a ProceedingJoinPoint? When is it used?
`ProceedingJoinPoint` is used in around advice. it can execute the original method execution.