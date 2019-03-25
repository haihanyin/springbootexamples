## What is the difference between checked and unchecked exceptions?
Checked exceptions must be thrown or catched.
Unchecked exception does not have this requirement.

### Why does Spring prefer unchecked exceptions?

### What is the data access exception hierarchy?

[Consistent exception](https://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch11s02.html)

## How do you configure a DataSource in Spring? Which bean is very useful for development/test databases?
DataSource class.
Properties, apis, 

[Configure DataSource programmatically in Spring Boot](https://stackoverflow.com/questions/28821521/configure-datasource-programmatically-in-spring-boot)
[Configuring Separate Spring DataSource for Tests](https://www.baeldung.com/spring-testing-separate-data-source)

## What is the Template design pattern and what is the JDBC template?
Template design pattern, which base on a template, leaves the specific parts to clients to define.
The JDBC template contains get connection, error handling, rollback, commit. 
It leaves the actual database operation to the client.

[Data access with JDBC](https://docs.spring.io/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html)

## What is a callback? What are the three JdbcTemplate callback interfaces that can be used with queries? What is each used for? (You would not have to remember the interface names in the exam, but you should know what they do if you see them in a code sample).
A Callback is a method which is called not at the place where it is written but as a hook in the template.

JdbcTemplate callback interfaces:
- RowMapper. Map each row to an entity.
- ResultSetExtractor. Handle the result set as a whole.
- RowCallbackHandler. Handle result set. Do not return directly.

## Can you execute a plain SQL statement with the JDBC template?
Yes.

## When does the JDBC template acquire (and release) a connection - for every method called or once per template? Why?
without connection pool, every method call will acquire and release connection (no transaction)
with connection pool, the method call will use cached connection from the pool.
?? 
[Does Spring's JdbcTemplate close the connection after query timeout?](https://stackoverflow.com/questions/20419785/does-springs-jdbctemplate-close-the-connection-after-query-timeout)

## How does the JdbcTemplate support generic queries? How does it return objects and lists/maps of objects?

## What is a transaction? What is the difference between a local and a global transaction?
Local transaction is resource specific, like database instance, jms instance.
Global transaction crosses resources.

[Transaction Management](https://docs.spring.io/spring/docs/4.2.x/spring-framework-reference/html/transaction.html)

## Is a transaction a cross cutting concern? How is it implemented by Spring?
Yes. Spring uses AOP.

## How are you going to define a transaction in Spring?
@Tansactional, @EnableTransactionManagement, PlatformTransactionManager

Transaction configuration:
- Isolation
  - Dirty read: possible to read uncommited data. Modify lost problem.
  - Commit read: intermediate changes of a transaction cannot be read. Unrepeatable read problem
  - Repeatable read: repeatable read in current transaction no matter what other transactions do. Phantom read problem.
  - Serialization: Sequential execution. Some databases optimizes repeatable read to implement this.

- Propogation: depends on the current transation (none/exist) and how to support current (exception/new/suspend/inherit) 
  - mandatory
  - never
  - nested
  - not_supported
  - required
  - required_new
  - supports
  
- Timeout
- ReadOnly
- Rollback
  - specific classes


[透彻的掌握 Spring 中@transactional 的使用](https://www.ibm.com/developerworks/cn/java/j-master-spring-transactional-use/index.html)
[可能是最漂亮的Spring事务管理详解](https://juejin.im/post/5b00c52ef265da0b95276091)

### What does @Transactional do? What is the PlatformTransactionManager?
[Understanding the Spring Framework transaction abstraction](https://docs.spring.io/spring-framework/docs/3.0.0.RC3/spring-framework-reference/html/ch10s03.html)
[which transaction manager should I use (JTA vs JPA)?](https://stackoverflow.com/questions/26482495/which-transaction-manager-should-i-use-jta-vs-jpa)

## Is the JDBC template able to participate in an existing transaction?
Yes.

## What is a transaction isolation level? How many do we have and how are they ordered?
Isolation between two different transactions.
- Default. Depends on the datasource
- READ_UNCOMMITTED
- READ_COMMITTED
- REPEATABLE_READ
- SERIALIZABLE

## What is @EnableTransactionManagement for?
Same as `<tx:annotation-driven />`

## What does transaction propagation mean?
How a new transaction handles the current context (with/without existing transaction).

## What happens if one @Transactional annotated method is calling another @Transactional annotated method on the same object instance?
Dependes on the propagation configuration

## Where can the @Transactional annotation be used? What is a typical usage if you put it at class level?
All public non-final non-static methods will be applied with the class level @Transactional. Unless it
is overwritten in the specific methods.

## What does declarative transaction management mean?
Transaction management in configurations (annotation/xml)

## What is the default rollback policy? How can you override it?
Only unchecked exceptions (that is, subclasses of java.lang.RuntimeException) are rollbacked by default.

To override, e.g., `@Transactional(rollbackFor = Exception.class)`

## What is the default rollback policy in a JUnit test, when you use the @RunWith(SpringJUnit4ClassRunner.class) in JUnit 4 or @ExtendWith(SpringExtension.class) in JUnit 5, and annotate your @Test annotated method with @Transactional?
Rollback after every test.

## Why is the term "unit of work" so important and why does JDBC AutoCommit violate this pattern?
Commit after a transaction (when the unit of work is finished). AutoCommit breaks this rule.

## What does JPA stand for - what about ORM?
Java Persistence API
Object relationship mapping

### What is the idea behind an ORM? What are benefits/disadvantages or ORM?
bridge the gap between objects and tables
benefits: fast prototyping, datasource independent
disadvantage: complexity is increased, slower than jdbc

[What are the pros and cons of using raw SQL versus ORM for database development?](https://www.quora.com/What-are-the-pros-and-cons-of-using-raw-SQL-versus-ORM-for-database-development)

### What is a PersistenceContext and what is an EntityManager. What is the relationship between both?
The purpose of the EntityManager is to interact with the persistence context. The persistence context 
will then manage entity instances and their associated lifecycle. 

### Why do you need the @Entity annotation. Where can it be placed?
@Entity refers to a class mapped a table in database. It is placed at class level.
??
JPA stuff to be exercised

## What do you need to do in Spring if you would like to work with JPA?
## Are you able to participate in a given transaction in Spring while working with JPA?
## Which PlatformTransactionManager(s) can you use with JPA?
## What does @PersistenceContext do?
## What do you have to configure to use JPA with Spring? How does Spring Boot make this easier?

## What is an "instant repository"? (hint: recall Spring Data)
By naming conventions, instant repository can generate sql statements automatically.

Instant Repository is a term used in Spring Data. You create Instant Repository with these two steps 
1. Annotate Domain class 2. Define your repository as an interface by extending Repository interface.
Spring will implement instant repository at run time as it scans for all the interface extending springs Repository.

[“instant repository” concept in Spring Hibernate JPA](https://stackoverflow.com/questions/43249593/instant-repository-concept-in-spring-hibernate-jpa)

## How do you define an “instant” repository? Why is it an interface not a class?


## What is the naming convention for finder methods?
[JPA Repositories](https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html)

## How are Spring Data repositories implemented by Spring at runtime?
Proxy instance is created ??

## What is @Query used for?
@Query is for specifying a sql statement
[Spring Data JPA @Query](https://www.baeldung.com/spring-data-jpa-query)