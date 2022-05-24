package com.ty.onetomanyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetMobileSim {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Mobile mobile = entityManager.find(Mobile.class, 6);
		if (mobile != null) {
			List<Sim> sims = mobile.getSim();
			System.out.println("");
			System.out.println("Mobile name is " + mobile.getName());
			System.out.println("Cost is " + mobile.getCost());
			System.out.println("Sim Details :------------------------");

			for (Sim sim : sims) {
				System.out.println("Sim id " + sim.getId());
				System.out.println("Sim Proivder " + sim.getProvider());
				System.out.println("Sim type " + sim.getType());
				System.out.println("-------------------------------------------");
			}
		} else {
			System.out.println("No Mobile existing for given Id");
		}

	}

}
