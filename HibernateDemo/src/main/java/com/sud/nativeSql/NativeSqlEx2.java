package com.sud.nativeSql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sud.entity.Book;
import com.sud.util.HibernateUtility;

public class NativeSqlEx2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//String sql = "delete from book where book_id=?";
		String sql = "update book set title=? where book_id=?";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter(0, "PHP");
		sqlQuery.setParameter(1, 114L);
		sqlQuery.addEntity(Book.class);
		
		int record = sqlQuery.executeUpdate();
		
		System.out.println(record);
		tx.commit();
		session.close();
		factory.close();
		
	}

}
