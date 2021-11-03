package com.maith;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maith.spjdbc.Org;
import com.maith.spjdbc.dao.OrganisationDao;

public class JdbcTemplate2 {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beanss.xml");
		
		OrganisationDao dao = (OrganisationDao) ac.getBean("orgDao");
//		List<Org> orgs = dao.getAllOrganisations();
//		for (Org org : orgs) {
//			System.out.println(org);
//		}
		DaoUtils.createSeedData(dao);
		
		List<Org> orgs = dao.getAllOrganisations();
		DaoUtils.printOrganisations(orgs, DaoUtils.readOperation);
		
		Org o = new Org("amazon", "arya", "2081");
		boolean isCreated = dao.create(o);
		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganisations(dao.getAllOrganisations(), DaoUtils.readOperation);
		
		Org o2 = dao.getOrg(1);
		DaoUtils.printOrganisation(o2, "getOrg");
		
		Org o3 = dao.getOrg(2);
		o3.setEmployeeId("6757");
		boolean isUpdated = dao.update(o3);
		DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganisation(dao.getOrg(2), DaoUtils.updateOperation);
		
		boolean isDeleted = dao.delete(dao.getOrg(3));
		DaoUtils.printSuccessFailure(DaoUtils.deleteOperation, isDeleted);
		DaoUtils.printOrganisations(dao.getAllOrganisations(), DaoUtils.cleanupOperation);
		
		dao.cleanup();
		DaoUtils.printOrganizationCount(dao.getAllOrganisations(), DaoUtils.cleanupOperation);
		
		
		((ClassPathXmlApplicationContext) ac).close();

	}

}
