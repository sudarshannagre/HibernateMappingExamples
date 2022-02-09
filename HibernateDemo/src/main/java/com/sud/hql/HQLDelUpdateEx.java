package com.sud.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sud.util.HibernateUtility;

public class HQLDelUpdateEx {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//update book set title='java' where id=114;
		String hql = "update Book b set b.title='java' where b.id=114";
		
		//delete from book where id=113;
		//String hql = "delete from Book b where b.id=115";
		Query query = session.createQuery(hql);
		int record = query.executeUpdate();
		System.out.println(record);
		tx.commit();
		session.close();
		factory.close();
	}
}
