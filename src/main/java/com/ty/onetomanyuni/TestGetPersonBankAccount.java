package com.ty.onetomanyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetPersonBankAccount {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Person person = entityManager.find(Person.class, 1);
		System.out.println("");
		System.out.println("Name is " + person.getName());
		System.out.println("Address is " + person.getAddress());
		System.out.println("Phone num is " + person.getPhone());
		System.out.println("-----------------------------------");

		List<BankAccount> bankAccounts = person.getBankAccount();
		if (bankAccounts.size() >0) {
			for (BankAccount bankAccount : bankAccounts) {
				System.out.println("Bank name is " + bankAccount.getBankName());
				System.out.println("Bank name is " + bankAccount.getBranch());
				System.out.println("Bank name is " + bankAccount.getCity());
				System.out.println("Bank name is " + bankAccount.getState());
				System.out.println("Bank name is " + bankAccount.getAccountNumber());
				System.out.println("Bank name is " + bankAccount.getIfscCode());
				System.out.println("-----------------------------------");

			}
		} else {
			System.out.println("No Person exists for given Id");
		}

	}

}
