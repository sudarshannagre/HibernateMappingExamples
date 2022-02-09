package com.sud.criteriaAPI;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.sud.entity.Book;
import com.sud.util.HibernateUtility;

public class CriteriaAPIBasicEx {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		
		Criteria ct = session.createCriteria(Book.class);
		//Adding conditions to criteria
		//Criterion ctn = Restrictions.gt("id", 114L);
		Criterion ctn1 = Restrictions.eq("id", 114L);
		Criterion ctn = Restrictions.like("title", "java");
		Criterion ctn2 = Restrictions.and(ctn1, ctn);
				
		ct.add(ctn2);
		
		List list = ct.list();
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Book b = (Book)it.next();
			System.out.println(b);
		}
	}

}
