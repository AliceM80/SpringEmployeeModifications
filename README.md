# Java-Spring-web-1

You will create here your first API.

You will be able to test how annotations like `@Controller`, `@RequestMapping`, `@RequestParam` and `@PathVariable` work.

#

## Task 1: Clone this repository and import the application into your IDE

Take a look at all the given code. The `Application` class is our an entry point to the
application.

Run the application and make sure it works.

Take a look on **pom.xml** file.
You need to have this dependency to be able to create a controller:

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Before you go to the next tasks, go to the `Employee` class. This is just simple POJO that represents one employee.
Each employee has given attributes:

```java
private final String id;
private final String firstName;
private final String lastName;
private final Integer age;
private final String position;
```

#

## Task 2: Create Controller

The main goal for the controller is to provide methods to operate on `Employee` entity, such as: adding, modifying, removing and listing all employees.

You can name it `EmployeeController`.

All endpoints related to employee management should use `/employees` mapping at the beginning. 

##

### Task 2.1: Add a new employee

Provide a method that will add a new employee.

* Endpoint should look like this: `/employees/add`
* Provide first name, last name, age and position for every new employee
* Chose proper mapping type

> **Hint:** Use `@RequestBody` annotation to provide the whole object to the request


### Task 2.2: List all employees

Provide a method that will list all employees when hitting an endpoint `/employees`.  
* Provide the possibility to **limit** the number of elements in the list
* For the sake of the simplicity, implement business logic in the same method (you will modify it later)
* Chose proper mapping type

> **Hint:** Use `@RequestParam` annotation with **required = false**  to make parameters optional

##

### Task 2.3: Select employee by id

Provide a method that will allow selecting employee by its **id**.

* Provide id as a part of the URL, so the endpoint should look like this: `/employees/1`
* Return dummy employee as a result of this method
* Chose proper mapping type



##

### Task 2.4: Remove employee by id

Provide a method that will allow deleting employee by its **id**.

* Provide id as a part of the URL, so the endpoint should look like this: `/employees/1`
* Chose proper mapping type

> **Hint:** You can have the same endpoints available as soon as they refer to different mapping types!


##

## Task 3: Test the Application!

Run your application.
You can use **Postman** for testing purposes.

## **Optional** Task 4: Find out how to make a good API and refactor your code!

You can read more about how to make good REST APIs here:
https://medium.com/@mwaysolutions/10-best-practices-for-better-restful-api-cbe81b06f291

