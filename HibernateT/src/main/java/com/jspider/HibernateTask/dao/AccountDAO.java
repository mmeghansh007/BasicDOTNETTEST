package com.jspider.HibernateTask.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.TransactionException;

import com.jspider.HibernateTask.dto.AccountDTO;

public class AccountDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String query;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("Accounts");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();

		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			try {
				transaction.rollback();
			} catch (TransactionException e) {
				System.out.println("Transaction is committed.");
			}

		}
	}

	public static void main(String[] args) {
		try {

			openConnection();
			transaction.begin();

			AccountDTO account1 = new AccountDTO();
			account1.setAccountNo(93564879536L);
			account1.setAccountHolder("Vijay Malya");
			account1.setBranch("Banergutta");
			account1.setCity("Banglore");
			account1.setBank("Punjab National bank");
			account1.setIfsc("PNB1255554");

			AccountDTO account2 = new AccountDTO();
			account2.setAccountNo(93564874654L);
			account2.setAccountHolder("Nirav Modi");
			account2.setBranch("Gujrat bb");
			account2.setCity("gandhinagar");
			account2.setBank("SBI");
			account2.setIfsc("SBIN1255554");

			AccountDTO account3 = new AccountDTO();
			account3.setAccountNo(93544479536L);
			account3.setAccountHolder("Harshad Mehta");
			account3.setBranch("Dharavi");
			account3.setCity("Mumbai");
			account3.setBank("SBI");
			account3.setIfsc("SBI1255554");

			manager.persist(account1);
			manager.persist(account2);
			manager.persist(account3);

//			query="from AccountDTO where accountHolder like '%D%'";
//			
//			 Query createQuery= manager.createQuery(query);
//			 List accounts =createQuery.getResultList();
//			 
//			 for(int i=0; i<accounts.size(); i++)
//			 {
//				 System.out.println(accounts.get(i));
//				 
//			 }

//			query = "update AccountDTO set bank='PNB' where id=1";
//
//			Query createQuery = manager.createQuery(query);
//
//			int resultInt = createQuery.executeUpdate();
//			System.out.println(resultInt + "rows(s) Affected");

			query = "delete from AccountDTO  where id=1";

			Query createQuery = manager.createQuery(query);

			int resultInt = createQuery.executeUpdate();
			System.out.println(resultInt + "rows(s) Affected");

			transaction.commit();

		} finally {

			closeConnection();
		}

	}

}
