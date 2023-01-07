package com.jspider.HibernateTask.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspider.HibernateTask.dto.Student1DTO;

public class DAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Scanner scanner = new Scanner(System.in);

	private static void openConnections() {
		factory = Persistence.createEntityManagerFactory("Students");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnections() {
		factory.close();
		manager.close();
		try {
			transaction.rollback();
		} catch (TransactionException e) {
			System.out.println("Transaction cannot be rolled back");
		}
	}

	public static void main(String[] args) {
		openConnections();
		transaction.begin();
		updateStudent();
		removeStudent();
		transaction.commit();
		transaction.begin();
		displayStudents();
		transaction.commit();
		transaction.begin();
		removeStudent();

		closeConnections();

	}

	private static void addStudent() {
		Student1DTO student1 = new Student1DTO();
		System.out.println("Enter the student id:");
		int id = scanner.nextInt();
		student1.setRollNo(id);
		System.out.println("Enter the student name:");
		String name = scanner.next();
		student1.setName(name);
		System.out.println("Enter the student email:");
		String email = scanner.next();
		student1.setEmail(email);
		manager.persist(student1);
	}

	private static void displayStudents() {
		Student1DTO student = manager.find(Student1DTO.class, 3);
		System.out.println(student);
	}

	private static void removeStudent() {
		Student1DTO student = manager.find(Student1DTO.class, 5);
		manager.remove(student);
	}

	private static void updateStudent() {
		Student1DTO student = manager.find(Student1DTO.class, 5);
		student.setEmail("meghanshmamidi@gmail.com");
		manager.persist(student);
	}

}
