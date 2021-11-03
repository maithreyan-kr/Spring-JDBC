package com.maith.spjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.maith.spjdbc.Org;

public interface OrganisationDao {
	
	public void setDataSource(DataSource ds);
	
	public boolean create(Org org);
	
	public Org getOrg(Integer id);
	
	public List<Org> getAllOrganisations();
	
	public boolean delete(Org org) ;
	
	public boolean update(Org org);
	
	public void cleanup();

}
