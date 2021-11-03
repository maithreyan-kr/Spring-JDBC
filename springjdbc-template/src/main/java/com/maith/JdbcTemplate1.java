package com.maith;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maith.spjdbc.Org;
import com.maith.spjdbc.dao.OrganisationDao;

public class JdbcTemplate1 {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beanss.xml");
		
		OrganisationDao dao = (OrganisationDao) ac.getBean("orgDao");
		List<Org> orgs = dao.getAllOrganisations();
		for (Org org : orgs) {
			System.out.println(org);
		}
		
		((ClassPathXmlApplicationContext) ac).close();

	}

}
