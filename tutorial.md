# Tutorial: JUnit
JUnit is an open-source unit testing framework for the Java programming language.
In this tutorial I will show how to use the most recent version JUnit5, 
also called JUnit Jupiter.

![JUnit5](img/junit5.png)

#  Setup
For using JUnit you need Java and your favourite IDE. I recommend 
IntelliJ and the instructions in this tutorial are for IntelliJ as well.

You can create a plain java project and add JUnit as *.jar or create a maven 
project and add JUnit as dependency.

As I will show you that Hamcrest Matchers makes writing assertions much
easier, you need to add that to your project too.

## Add as jar

Download the jars for 
[JUnit](https://search.maven.org/artifact/org.junit.jupiter/junit-jupiter/5.6.2/jar)
and [Hamcrest](https://search.maven.org/artifact/org.hamcrest/hamcrest/2.2/jar).

After downloading the jar import them to your project:

- Navigate to [File] -> [Project Structure] -> [Libraries] and click the “+“ button.
- Choose „Java“ as New Project Library and specify the location of the JUnit jar files
you want to import
- Now	click	on	„OK“	and	confirm	your	imports	by	clicking	on	„Apply“

## Maven

Create a maven project and add the following dependencies in the dependencies 
section of your pom.xml:

``` xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter</artifactId>
  <version>5.6.2</version>
</dependency>

<dependency>
  <groupId>org.hamcrest</groupId>
  <artifactId>hamcrest</artifactId>
  <version>2.2</version>
</dependency>
```

# Write tests with JUnit

## Create a test
- IntelliJ: alt + enter on class name -> create test
- write a void method with the annotation `@Test` 

Tests usually consist out of three parts

1. Arrange
    - setup the required objects for your test
2. Act
    - perform the operation (method) you want to test
3. Assert
    - check with an assertion, if the actual value equals the expected value
    
### Example
``` java
@Test
void calcAddTest() {
    Calculator calculator = new Calculator(); // arrange
    result = calculator.add(3, 4);            // act
    assertThat(result, is(7));                // assert
}
```

## TDD
When writing tests an often used method is test-driven development:
- The first step in this process is not to write the productive code but to write
the test for that function
- after that you execute the test and make sure it fails
- now you can start with implementing the function and executing the test again, until its
execution succeeds
- after this step you have some functioning code, but the next step is essential to
produce good code: the refactoring
- now you can refactor the code you just wrote und after that make sure everything is still 
working by executing the test again

Below you can see a graphic of the TDD cycle:

![TDD Cycle](img/tdd.png)

## Annotations
You can mark tests with more than just the `@Test` annotation, here is a list of the most
important and most used annotations:

|Annotation|Usage|
|---|---|
`@Test` | marks a method as test method
`@RepeatedTest()` | method is a repeated test, value in () is number of executions
`@TestMethodOrder` | you can specify the order in which the tests are executed
`@BeforeEach` | method is executed before each test
`@AfterEach` | method is executed after each test
`@BeforeAll` | executed one time before all tests
`@AfterAll` | executed one time after all tests
`@Disabled` | disables test
`@Timeout` | sets timeout after that the test fails

## Assertions

JUnit5 comes with built in Assertions:

|Assertion|Usage|
|---|---|
`assertFalse` | checks if provided value is false
`assertTrue` | checks if provided value is true
`assertEquals` | checks if provided values are equal
`assertSame` | checks if the provided values have the same method reference
`assertNotSame` | checks if the provided values fave not the same method reference
`assertArrayEquals` | checks if provided arrays are equal
`assertNull` | checks if provided value is null
`assertNotNull` | checks if provided is not null
`assertThrows` |  checks if exception is thrown

It is very common to use Hamcrest or AssertJ for better human
readable assertions and more understandable error messages, if a test fails.

In this tutorial I will use Hamcrest, which provides an `assertThat()`-method, 
includes many different matchers and allows to write own Matchers.

Usage:
`assertThat(<actualValue>, <expectedValue>);`

The matchers are used to wrap the expected value. The most often used matcher
is the `is()` matcher, which is a wrapper for the `equalTo()`-matcher.

Here's a list of the most important Hamcrest matchers:

| Matcher | Usage |
|---|---|
`not()` | matches if wrapped matchers dont match 
`equalTo()` | objects are equal using equals() method 
`instanceOf()` | test type 
`notNullValue() and nullValue()` | test for null or not null 
`sameInstance()` | test object identity 
`hasEntry(), hasKey(), hasValue()` | test a map contains an entry, key or value
`hasItem(), hasItem()` | test a collection contains elements
`containsInAnyOrder()` | tests for items in a collection
`closeTo()` | test floats 
`greaterThan(), greaterThanOrEqualTo(), lessThan(), lessThanOrEqualTo()` | tests if value is greater or less

## Run tests
- IntelliJ: Shift + F10 or click run
- Eclipse: Crtl + F11 or click run

### Result
- 🟢 all tests passed
- 🔴 one or more tests failed

# Further Reading
Take a look at the JUnit5 
[User Guide](https://junit.org/junit5/docs/current/user-guide/)
and [Website](https://junit.org/junit5/) as well as the
[Hamcrest Website](http://hamcrest.org/JavaHamcrest/).
Also take a look at [Mockito](https://site.mockito.org/) for mocking.

