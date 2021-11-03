package com.maith;

import java.util.ArrayList;
import java.util.List;

import com.maith.spjdbc.Org;
import com.maith.spjdbc.dao.OrganisationDao;

public class DaoUtils {
	
	public static final String createOperation = "CREATE";
	public static final String readOperation = "READ";
	public static final String updateOperation = "UPDATE";
	public static final String deleteOperation = "DELETE";
	public static final String cleanupOperation = "TRUNCATE";

	public static void printOrganisations(List<Org> orgs, String operation) {
		System.out.println("\n********* printing organisations after" + operation + " operation *********");
		for(Org o : orgs) {
			System.out.println(o);
		}
	}
	public static void printOrganisation(Org org, String operation ) {
		System.out.println("\n*********printing organisation after invoking" + operation + " *********\n" + org);
	}
	
	public static void printSuccessFailure(String operation, boolean param){
	    if(param)
	        System.out.println("\nOperation " + operation + " successful");
	    else
	        System.out.println("\nOperation " + operation + " failed");
	}
	public static void createSeedData(OrganisationDao dao){
	    Org org1 = new Org("amazon", "arya", "2081");
	    Org org2 = new Org("cognizant", "keerthana", "1098");;
	    Org org3 = new Org("TCS", "dhiviya", "0980");
	    Org org4 = new Org("perficient", "Maithreyan", "4356");
	     
	    List<Org> orgs = new ArrayList<Org>();
	    orgs.add(0, org1); orgs.add(1, org2); orgs.add(2, org3); orgs.add(3, org4);
	    int orgCount = orgs.size();
	    int createCount = 0;
	    for(Org org : orgs){
	        boolean isCreated  = dao.create(org);
	        if(isCreated)
	            createCount += 1;
	    }
	             
	    System.out.println("Created "+ createCount + " organizations");
	}
	
	public static void printOrganizationCount(List<Org> orgs, String operation){
	    System.out.println("\n*********Currently we have " + orgs.size()+ " organizations after " + operation + " operation" + "   *********");
	     
	}
}
