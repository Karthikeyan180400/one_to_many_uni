package com.ty.onetomanyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetAccountPage {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		UserAccount userAccount = entityManager.find(UserAccount.class, 2);
		List<Page> pages = userAccount.getPage();

		if (userAccount != null) {
			
			
				System.out.println("");
				System.out.println("Account Name is " + userAccount.getName());
				System.out.println("Account Email Id is " + userAccount.getEmail());
				System.out.println("Mobil num is " + userAccount.getMobile());

				for (Page page : pages) {
					System.out.println("Page Title is " + page.getTitle());
					System.out.println("Page Name is " + page.getName());
					System.out.println("------------------------------");
				
		} else {

		}

	}
}
