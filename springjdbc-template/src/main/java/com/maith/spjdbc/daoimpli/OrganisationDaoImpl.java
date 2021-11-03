package com.maith.spjdbc.daoimpli;

import java.util.List;

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
		return false;
	}

	public Org getOrg(Integer id) {
		return null;
	}

	public List<Org> getAllOrganisations() {
		String sqlQuery = "SELECT * FROM employee_1";
		List<Org> orgList = jdbcTemplate.query(sqlQuery, new OrgRowMap());
		return orgList;
	}

	public boolean delete(Org org) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Org org) {
		// TODO Auto-generated method stub
		return false;
	}

	public void cleanup() {
		// TODO Auto-generated method stub

	}

}
