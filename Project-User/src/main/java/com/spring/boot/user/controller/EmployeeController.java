/**
 *
 */
package com.spring.boot.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.user.eo.Employee;
import com.spring.boot.user.service.EmployeeService;

/**
 * @author mahendar
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/add", produces = "application/json")
	public Employee persistEmployee(@RequestBody final Employee request) {
		final Employee employee = new Employee();
		employee.setFirstname(request.getFirstname());
		employee.setLastname(request.getLastname());
		employee.setEmail(request.getEmail());
		employee.setPhone(request.getPhone());
		employee.setSalary(request.getSalary());
		return this.employeeService.addEmployee(employee);

	}

	@GetMapping(value = "/getAll", produces = "application/json")
	@ResponseBody
	public List<Employee> getEmployeeList() {
		return this.employeeService.getListOfEmployees();
	}

	@GetMapping(value = "/get/{id}", produces = "application/json")
	@ResponseBody
	public Optional<Employee> getEmployeeById(@PathVariable("id") final int id) {
		return this.employeeService.findEmployeeById(id);
	}

	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public void deleteEmployeeById(@PathVariable("id") final int id) {
		this.employeeService.deleteEmployeeId(id);
	}

	@PutMapping(value = "/update/{id}", produces = "application/json")
	public Employee updateEmployeeById(@RequestBody final Employee request, @PathVariable("id") final int id) {
		final Employee employee = new Employee();
		final boolean find = this.employeeService.employeeExist(id);
		if (find) {
			employee.setEmp_id(id);
			employee.setFirstname(request.getFirstname());
			employee.setLastname(request.getLastname());
			employee.setEmail(request.getEmail());
			employee.setPhone(request.getPhone());
			employee.setSalary(request.getSalary());
		} else {
			this.persistEmployee(request);
		}
		return this.employeeService.addEmployee(employee);
	}

}
