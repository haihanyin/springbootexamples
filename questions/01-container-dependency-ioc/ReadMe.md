## What is dependency injection and what are the advantages?
Spring manages the dependencies (beans) and inject it to instances. 

Advantages:
- Client behavior remains fixed and the dependencies configuration is decoupled from client behavior. 
- Reduce complexity of architect
- Easy for mocking in testing
- Make component more reusalbe

[How Dependency Injection (DI) Works In Spring Java Application Development](https://dzone.com/articles/how-dependency-injection-di-works-in-spring-java-a)
[Intro to Inversion of Control and Dependency Injection with Spring](https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring)

## What is a pattern? What is an anti-pattern. Is dependency injection a pattern?
A pattern is a regularly used solution. Yes, dependency injection is a pattern.

## What is an interface and what are the advantages of making use of them in Java? Why are they recommended for Spring beans
Interface decouples the client code and the implementation. ??

## What is meant by “application-context?
Application context in spring is a more advanced bean factory.

The ApplicationContext provides:
- Accessing application components.
- Loading resources
- Publising events to registered listeners. (application context events, obeserver)
- Resovling messages to support internationalization (class MessageSource)
- Inheriting a parent context

[Understanding Application Context](https://spring.io/understanding/application-context)
[The ApplicationContext](https://docs.spring.io/spring/docs/3.0.0.M3/reference/html/ch04s08.html)

## What is the concept of a “container” and what is its lifecycle?
Container virtualize the things that the container manages. 

Initialization life cycle:
- constructor, setter (own)
- BeanNameAware, BeanFactoryAware (aware) 
- BeanPostProcessor.postProcessBeforeInitiailization (bpp.before)
- @PostConstruct, InitializingBean.afterPropertiesSet, init-method (Annotation,Interface,Xml - AIX)
- BeanPostProcessor.postProcessAfterInitiailization (bpp.after)

Destroying life cycle:
- @PreDestroy
- DisposableBean.destroy()
- destroy-method (AIX)
- finalize()

Life cycle hooks:
- A bunch of 'Aware' Interfaces.
- @PreDestroy, @PostConstruct
- factory init-method
- BeanPostProcessor
- InitializingBean interface, afterPropertiesSet()

[Spring Bean Life Cycle Explained](https://howtodoinjava.com/spring-core/spring-bean-life-cycle/)

## How are you going to create a new instance of an ApplicationContext?
[Spring application context example](https://alvinalexander.com/blog/post/java/load-spring-application-context-file-java-swing-application)

- Corresponding ApplicationContext(annotation, classpath, filesystem, groovy, etc) class location resources
- Get bean from that applicationContext

## Can you describe the lifecycle of a Spring Bean in an ApplicationContext?
[Spring Bean Life Cycle Explained](https://howtodoinjava.com/spring-core/spring-bean-life-cycle/)

## How are you going to create an ApplicationContext in an integration test?
@RunWith(SpringRunner.class) and @ContextConfiguration

## What is the preferred way to close an application context? Does Spring Boot do this for you?
- Downcast `ApplicationContext` to `ConfigurableApplicationContext`, then call `close()`
- Register a shutdown hoot, like `((AbstractApplicationContext)appCtx).registerShutdownHook();`

[How to close a spring ApplicationContext?](https://stackoverflow.com/questions/14423980/how-to-close-a-spring-applicationcontext)

## Can you describe:
### Dependency injection using Java configuration?
@Configuration with @Bean inside
### Dependency injection using annotations (@Component, @Autowired)?
@Component, @Service ..., @Autowired for injection, if name is required add @Qualifier with @Component
### Component scanning, Stereotypes and Meta-Annotations?
- @ComponentScan(basePackages)
- @Service, @Controller, @Repository are @Component stereotypes
- @Meta-Annotation is the annotation for annotation

### Scopes for Spring beans? What is the default scope?
- Singleton
- Prototype
- Per-request
- Per-session
- Global session

Default is singleton.

[Bean scopes](https://docs.spring.io/spring/docs/3.0.0.M3/reference/html/ch04s04.html)

## Are beans lazily or eagerly instantiated by default? How do you alter this behavior?
By default eagerly instantiated.
To alter, use @Lazy.
- On @Configuration annotated class
- On @Autowired, but it requres @Lazy on both bean and client.

[A Quick Guide to the Spring @Lazy Annotation](https://www.baeldung.com/spring-lazy-annotation)

## What is a property source? How would you use @PropertySource?
@ProertySource is for loading property file, used on class level.

[Properties with Spring and Spring Boot](https://www.baeldung.com/properties-with-spring) !!

## What is a BeanFactoryPostProcessor and what is it used for? When is it invoked?
It can be used for changing the creation of any bean as a "BeanFactory"

[Spring的BeanFactoryPostProcessor和BeanPostProcessor](https://blog.csdn.net/caihaijiang/article/details/35552859)

### Why would you define a static @Bean method?
??

### What is a ProperySourcesPlaceholderConfigurer used for?
It resolves ${...} placeholder in @Value annotation.
[Spring PropertySourcesPlaceholderConfigurer工作原理](https://blog.csdn.net/qyp199312/article/details/54313784) !!

## What is a BeanPostProcessor and how is it different to a BeanFactoryPostProcessor? What do they do? When are they called?
- BeanFactoryPostProcessor processes beans after it's configuration is loaded and before it is instantiated. 
It can change for example the scope type, the property values, etc.
- BeanPostProcessor processes beans after it is instantiated. It pre/post-apply afterPropertiesSet/init-method. 

[Spring的BeanFactoryPostProcessor和BeanPostProcessor](https://blog.csdn.net/caihaijiang/article/details/35552859)

### What is an initialization method and how is it declared on a Spring bean?
initialization method has two types:
- implement InitializingBean interface, it has afterPropertiesSet()
- @PostConstruct, init-method

### What is a destroy method, how is it declared and when is it called?
@PreDestroy
interface DisposableBean.destroy

---
- Consider how you enable JSR-250 annotations like @PostConstruct and
- @PreDestroy? When/how will they get called?
- How else can you define an initialization or destruction method for a Spring bean?


## What does component-scanning do?
Component-scanning find all beans declared in a certain package and automatically resolve them in application context.
Configuration `annotation-config` only resolve dependencies with @Autowired, bean instantiation needs to be made. 

## What is the behavior of the annotation @Autowired with regards to field injection, constructor injection and method injection?
[Field Dependency Injection Considered Harmful](https://www.vojtechruzicka.com/field-dependency-injection-considered-harmful/)

## What do you have to do, if you would like to inject something into a private field? Ho does this impact testing?
Field injection is hard for testing, can only use reflection. Not recommended.

## How does the @Qualifier annotation complement the use of @Autowired?
@Qualifier gives a name for the bean. @Autowired needs to use that name.

## What is a proxy object and what are the two different types of proxies Spring can create?
- Jdk dynamic proxy, if the object implements an interface
- Cglib proxy, otherwise, or configured with `proxy-target-class="true"`.

[Proxying mechanisms](https://docs.spring.io/spring/docs/3.0.0.M3/reference/html/ch08s06.html)

### What are the limitations of these proxies (per type)?
- Jdk dynamic proxy, need interface, proxy is on sibling class of the target object
- Cglib proxy, subclass of the target object, final methods cannot be subclassed, internal call `this` cannot be applied.

### What is the power of a proxy object and where are the disadvantages?
- pros: seperation of concerns, transparency
- cons: slower, local behavioural visibility is decreased.

## What are the advantages of Java Config? What are the limitations?
??

## What does the @Bean annotation do?
Creates a bean and put the bean into the application context

## What is the default bean id if you only use @Bean? How can you override this?
override by @Qualifier
default name: 
- same as bean method
- if it is from a class, lower the first letter, if two initial consecutive capital in class name, bean name is the same as class name.

## Why are you not allowed to annotate a final class with @Configuration
Spring creates proxy on @Configuration class. Therefore, `final` is not allowed

### How do @Configuration annotated classes support singleton beans?
Just annotate as @Bean

### Why can’t @Bean methods be final either?
proxy needs to be created on @Configuration class

## How do you configure profiles? What are possible use cases where they might be useful? !!


## Can you use @Bean together with @Profile? !!


## Can you use @Component together with @Profile? !!
## How many profiles can you have?
## How do you inject scalar/literal values into Spring beans?
## What is @Value used for?
Inject value, from proterty of Spel expression result to fields. 

## What is Spring Expression Language (SpEL for short)?
SpEL is a language quering object references.

## What is the Environment abstraction in Spring? !!

## Where can properties in the environment come from – there are many sources for properties – check the documentation if not sure. Spring Boot adds even more.
## What can you reference using SpEL?
## What is the difference between $ and # in @Value expressions?
`${...}` is the property placeholder syntax. It can only be used to dereference properties.
`#{...}` is SpEL syntax, which is far more capable and complex. It can also handle property placeholders, and a lot more besides.

[A Quick Guide to Spring @Value](https://www.baeldung.com/spring-value-annotation)