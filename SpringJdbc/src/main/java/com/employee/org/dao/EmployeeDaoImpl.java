package com.employee.org.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
 
import com.employee.org.mapper.EmployeeRowMapper;
import com.employee.org.model.Employee;
 
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
 
	public void createEmployee(Employee employee) {
		String SQL = "INSERT INTO employee_table(employee_name ,email,gender,salary) VALUES (?,?,?,?)";
		int update = getJdbcTemplate().update(SQL, employee.getEmployeeName(),employee.getEmail(),employee.getGender(),employee.getSalary());
		if(update == 1) {
			System.out.println("Employee is created..");
		}
	}
 
	public Employee fetchEmployeeById(Integer employeeId) {
		System.out.println("Fetching Employee details from DB with ID = "+employeeId);
		String SQL = "SELECT * FROM employee_table WHERE employee_id = ?";
		return getJdbcTemplate().queryForObject(SQL, new EmployeeRowMapper(), employeeId);
	}
	public List<Employee> fetchAllEmployees() {
		System.out.println("Fetching All Employees details from DB");
		String SQL = "SELECT * FROM employee_table";
		return getJdbcTemplate().query(SQL, new EmployeeRowMapper());
	}
	public void updateEmployeeEmailById(String newEmail, Integer employeeId) {
		System.out.println("Updating email whose Id = "+employeeId);
		String SQL = "UPDATE employee_table set email = ? WHERE employee_id = ?";
		int update = getJdbcTemplate().update(SQL, newEmail,employeeId);
		if(update == 1) {
			System.out.println("Employee email is updated for ID = "+employeeId);
		}
	}
	public void deleteEmployeeById(Integer employeeId) {
		String SQL = "DELETE FROM employee_table WHERE employee_id = ?";
		int update = getJdbcTemplate().update(SQL,employeeId);
		if(update == 1) {
			System.out.println("Employee is deleted with ID = "+employeeId);
		}
	}
}
