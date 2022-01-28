package com.dci.exercises.mvcAnnotations.Controller;

import com.dci.exercises.mvcAnnotations.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;


//The main goal for the controller is to provide methods to operate on Employee entity, such as: adding, modifying, removing and listing all employees.
//All endpoints related to employee management should use /employees mapping at the beginning.



//@RequestMapping. is one of the most common annotation used in Spring Web applications.
// This annotation maps HTTP requests to handler methods of MVC and REST controllers. It`s on class or on method level possible
@Controller  //check why we don`t use @restcontroller
@RequestMapping("/employee")  //All endpoints related to employee management should use /employees mapping at the beginning.
public class EmployeeController {

  private final Set<Employee> employees = new HashSet<>();

  //define@PostMapping for creating new employee
  //@PutMapping to update the content of the employee based on the request URI.

  //@ResponseBody binds a method return value to the web response body. --> @RestController annotation; therefore, the @ResponseBody isn't required.
  //The @ResponseBody tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
  @PostMapping(value = "/add")
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  //If we want to specify the response status of a controller method, we can mark that method with @ResponseStatus
  Employee createNewEmployee(@RequestBody Employee employee) {
    employees.add(employee);
    return employee;
  }

  // List all employees
  //Provide a method that will list all employees when hitting an endpoint /employees.
  // Provide the possibility to limit the number of elements in the list
  // For the sake of the simplicity, implement business logic in the same method (you will modify it later)
  // Chose proper mapping type
  // Hint: Use @RequestParam annotation with required = false to make parameters optional
  @GetMapping
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public Set<Employee> listEmployees(@RequestParam(required = false) Integer limit) {
    if (limit == null) {
      return employees;
    }
    final Set<Employee> limitedEmployeesList = new HashSet<>();
    final Iterator<Employee> iterator = employees.iterator();
    int i = 0;
    while (i <= limit && iterator.hasNext()) {
      limitedEmployeesList.add(iterator.next());
      i++;
    }
    return limitedEmployeesList;
  }


  //Provide a method that will allow selecting employee by its id.
  //Provide id as a part of the URL, so the endpoint should look like this: /employees/1
  //Return dummy employee as a result of this method- Chose proper mapping type
  @GetMapping("/{id}")
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public Employee selectEmployee(@PathVariable String id) {
    for (Employee e : employees) {
      if (e.getId().equals(id)) {
        return e;
      }
    }
    throw new NoSuchElementException("No employee present with given id: " + id);

  }
//Provide a method that will allow deleting employee by its id.
//Provide id as a part of the URL, so the endpoint should look like this: /employees/1
//Chose proper mapping type  - //Hint: You can have the same endpoints available as soon as they refer to different mapping types!

  @DeleteMapping("/{id}")
  @ResponseBody
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void removeEmployee(@PathVariable String id) {
    final Iterator<Employee> iterator = employees.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().getId().equals(id)) {
        iterator.remove();
      }
    }
  }
}


