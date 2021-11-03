package com.employee.org.service;

import java.util.List;

import com.employee.org.model.Employee;

public interface EmployeeService {
	public abstract void createEmployee(Employee employee);
	public abstract Employee getEmployeeById(Integer employeeId);
	public abstract List<Employee> getAllEmployees();
	public abstract void updateEmployeeEmailById(String newEmail,Integer employeeId);
	public abstract void deleteEmployeeById(Integer employeeId);
}


