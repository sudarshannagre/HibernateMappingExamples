package com.sud.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sud.entity.Book;
import com.sud.util.HibernateUtility;

public class HQLBasicEx {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		//select * from book;
		//String hql = "from Book";
		
		//select title,price from book;
		//String hql = "select b.title, b.price,b.author from Book b";
		
		//slect title,price from book where id=114;
		//String hql = "select b.title,b.price from Book b where b.id=114";
		
		//Named parameter
		//slect title,price from book where id=114;
		String hql = "select b.title,b.price from Book b where b.id=?";
		Query query = session.createQuery(hql);
		query.setLong(0, 114);
		List list = query.list();
				
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] b = (Object[]) it.next();
			System.out.println(b[0]+" "+b[1]);
		}

		session.close();
		factory.close();
		
	}

}
