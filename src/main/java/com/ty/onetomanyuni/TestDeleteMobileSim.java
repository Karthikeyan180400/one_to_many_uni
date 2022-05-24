package com.ty.onetomanyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeleteMobileSim {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Mobile mobile = entityManager.find(Mobile.class, 4);
		List<Sim> sims = mobile.getSim();

		entityTransaction.begin();
		for (Sim sim : sims) {
			entityManager.remove(sim);
		}
		entityManager.remove(mobile);
		entityTransaction.commit();
	}

}
