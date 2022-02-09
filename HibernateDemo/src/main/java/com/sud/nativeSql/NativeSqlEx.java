package com.sud.nativeSql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sud.entity.Book;
import com.sud.util.HibernateUtility;

public class NativeSqlEx {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		//String sql = "select * from book";
		String sql = "select * from book where book_id=?";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter(0, 114L);
		sqlQuery.addEntity(Book.class);
		List list = sqlQuery.list();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Book b=(Book)it.next();
			System.out.println(b);
		}
		session.close();
		factory.close();
	}
}
