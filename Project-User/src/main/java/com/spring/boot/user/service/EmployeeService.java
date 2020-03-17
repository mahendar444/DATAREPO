/**
 *
 */
package com.spring.boot.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.user.dao.EmployeeDao;
import com.spring.boot.user.eo.Employee;

/**
 * @author mahendar
 *
 */
@Service(value = "employeeService")
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public Employee addEmployee(final Employee employee) {
		return this.employeeDao.save(employee);
	}

	public List<Employee> getListOfEmployees() {
		return this.employeeDao.findAll();
	}

	public Optional<Employee> findEmployeeById(final int id) {
		return this.employeeDao.findById(id);
	}

	public void deleteEmployeeId(final int id) {
		this.employeeDao.deleteById(id);

	}

	public boolean employeeExist(final int id) {
		return this.employeeDao.existsById(id);
	}

}
