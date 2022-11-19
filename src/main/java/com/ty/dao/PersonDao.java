package com.ty.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.ty.dto.Person;

public class PersonDao 
{
	
	public Person insertPerson(Person person) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tharun");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();

		return person;
	}

}
