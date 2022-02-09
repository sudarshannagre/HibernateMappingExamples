package com.sud.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sud.entity.Book;
import com.sud.util.HibernateUtility;

public class BookClient {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		SessionFactory factory = conf.buildSessionFactory();//HibernateUtility.getSessionFactory();// 
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		  Book b = new Book(); 
		  b.setId(115); 
		  b.setTitle("dfrqw"); 
		  b.setAuthor("mno");
		  b.setPrice(2120.29f);
		  
		  session.save(b);//
		//  session.update(b);
		  
		  //session.delete(b);
		 
		
	//	Book b = (Book)session.get(Book.class, 113L);
	/*
	 * Book b1 = (Book)session.load(Book.class, 113L); System.out.println(b1);
	 */
		tx.commit();
		System.out.println(session.contains(b));
		
		session.evict(b);
		session.clear();
		
		System.out.println(session.contains(b));
		session.close();
		factory.close();
	}
}


/*
 * CREATE TABLE `book` ( `book_id` int(11) NOT NULL AUTO_INCREMENT, `title`
 * varchar(128) NOT NULL, `author` varchar(45) NOT NULL, `price` float NOT NULL,
 * PRIMARY KEY (`book_id`) ) ENGINE=InnoDB;
 */