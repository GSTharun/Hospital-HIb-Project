package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Branches;


public class BranchDao
{
	public List<Branches> fetchBatch()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("tharun");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select s from Branches s");
		
		return query.getResultList();
		
		
		
	}

}
