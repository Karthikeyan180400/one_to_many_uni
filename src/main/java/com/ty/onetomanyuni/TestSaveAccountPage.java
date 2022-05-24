package com.ty.onetomanyuni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAccountPage {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		UserAccount userAccount = new UserAccount();
		userAccount.setName("KarthiVishwanath");
		userAccount.setEmail("karthi@mail.com");
		userAccount.setPassword("121212");
		userAccount.setMobile(12121212);

		Page page1 = new Page();
		page1.setName("Reels");
		page1.setTitle("Home");
		page1.setDescription("Your Reels are saved here");

		Page page2 = new Page();
		page2.setName("Posts");
		page2.setTitle("Home");
		page2.setDescription("Here is your Posts");

		Page page3 = new Page();
		page3.setName("LogOut");
		page3.setTitle("Setting");
		page3.setDescription("You can logout here");

		List<Page> pages = new ArrayList<Page>();
		pages.add(page1);
		pages.add(page2);
		pages.add(page3);
		userAccount.setPage(pages);

		entityTransaction.begin();
		entityManager.persist(userAccount);
		entityManager.persist(page1);
		entityManager.persist(page2);
		entityManager.persist(page3);
		entityTransaction.commit();
	}

}
