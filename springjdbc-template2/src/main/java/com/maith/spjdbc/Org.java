package com.maith.spjdbc;

public class Org {
	
	private int id;
	private String org_name;
	private String employee_name;
	private String emp_id;
	public Org() {
		
	}
	public Org( String orgName, String employeeName, String employeeId) {
		super();
		this.id = id;
		this.org_name = orgName;
		this.employee_name = employeeName;
		this.emp_id = employeeId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrgName() {
		return org_name;
	}
	public void setOrgName(String orgName) {
		this.org_name = orgName;
	}
	public String getEmployeeName() {
		return employee_name;
	}
	public void setEmployeeName(String employeeName) {
		this.employee_name = employeeName;
	}
	public String getEmployeeId() {
		return emp_id;
	}
	public void setEmployeeId(String employeeId) {
		this.emp_id = employeeId;
	}
	@Override
	public String toString() {
		return "Org [id=" + id + ", org_name=" + org_name + ", employee_name=" + employee_name + ", emp_id="
				+ emp_id + "]";
	}

}
