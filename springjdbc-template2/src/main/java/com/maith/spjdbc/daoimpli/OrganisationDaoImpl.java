package com.maith.spjdbc.daoimpli;

import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.maith.spjdbc.Org;
import com.maith.spjdbc.dao.OrganisationDao;

@Repository("orgDao")
public class OrganisationDaoImpl implements OrganisationDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		jdbcTemplate =new JdbcTemplate(datasource);

	}

	public boolean create(Org org) {
		String sqlQuery = "INSERT INTO employee_1(org_name, employee_name, emp_id) " + "VALUES(?,?,?)";
		Object[] args = new Object[] {  org.getOrgName(), org.getEmployeeName(), org.getEmployeeId()};
		return jdbcTemplate.update(sqlQuery, args)==1;
	}

	public Org getOrg(Integer id) {
		String sqlQuery = "SELECT id, org_name, employee_name, emp_id" + "FROM employee_1 WHERE id = ?";
		Object[] args = new Object[] {id};
		Org or = jdbcTemplate.queryForObject(sqlQuery, args, new OrgRowMap());
		
		return or;
	}

	public List<Org> getAllOrganisations() {
		String sqlQuery = "SELECT * FROM employee_1";
		List<Org> orgList = jdbcTemplate.query(sqlQuery, new OrgRowMap());
		return orgList;
	}

	public boolean delete(Org org) {
		String sqlQuery = "DELETE FROM employee_1 WHERE id = ?";
		Object[] args = new Object[] { org.getId() };
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public boolean update(Org org) {
		String sqlQuery = "UPDATE employee_1 SET emp_id = ? where id = ?";
		Object[] args =  new Object[] { org.getEmployeeId(), org.getId()};
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public void cleanup() {
String sqlQuery = "TRUNCATE TABLE employee_1";
jdbcTemplate.execute(sqlQuery);
	}

}
