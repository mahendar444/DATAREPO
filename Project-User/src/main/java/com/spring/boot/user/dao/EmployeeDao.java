/**
 *
 */
package com.spring.boot.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.user.eo.Employee;

/**
 * @author mahendar
 *
 */
@Repository(value = "employeeDao")
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
