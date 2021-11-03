package com.maith.spjdbc.daoimpli;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maith.spjdbc.Org;

public class OrgRowMap implements RowMapper<Org> {

	public Org mapRow(ResultSet rs, int rowNum) throws SQLException {
		Org org = new Org();
		org.setId(rs.getInt("id"));
		org.setOrgName(rs.getString("org_name"));
		org.setEmployeeName(rs.getString("employee_name"));
		org.setEmployeeId(rs.getString("emp_id"));
		
		return org;
		
	}
	
	

}
