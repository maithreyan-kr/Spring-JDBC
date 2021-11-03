package com.employee.org.dao;
import java.util.List;

import com.employee.org.model.Employee;
public interface EmployeeDao {
	public abstract void createEmployee(Employee employee);
	public abstract Employee fetchEmployeeById(Integer employeeId);
	public abstract List<Employee> fetchAllEmployees();
	public abstract void updateEmployeeEmailById(String newEmail,Integer employeeId);
	public abstract void deleteEmployeeById(Integer employeeId);
}
