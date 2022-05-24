package com.ty.onetomanyuni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonBankAccount {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		BankAccount banckAccount1 = new BankAccount();
		banckAccount1.setBankName("SBI");
		banckAccount1.setBranch("Musiri");
		banckAccount1.setCity("Trichy");
		banckAccount1.setState("Tamil Nadu");
		banckAccount1.setAccountNumber(33344446444l);
		banckAccount1.setIfscCode("SBIN000321");

		BankAccount banckAccount2 = new BankAccount();
		banckAccount2.setBankName("ICICI");
		banckAccount2.setBranch("Basavanangudi");
		banckAccount2.setCity("Bangalore");
		banckAccount2.setState("Karnataka");
		banckAccount2.setAccountNumber(44440872288l);
		banckAccount2.setIfscCode("ICICIN00324");

		Person person = new Person();
		person.setName("Karthi");
		person.setAddress("16th cross,BTM Layout");
		person.setPhone(1111222211);

		List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		bankAccounts.add(banckAccount1);
		bankAccounts.add(banckAccount2);

		person.setBankAccount(bankAccounts);

		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(banckAccount1);
		entityManager.persist(banckAccount2);
		entityTransaction.commit();

	}

}
