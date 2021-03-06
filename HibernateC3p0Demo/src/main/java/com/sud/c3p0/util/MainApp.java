package com.sud.c3p0.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sud.c3p0.entity.Person;

public class MainApp {

   public static void main(String[] args) {
      Session session = null;
      Transaction transaction = null;
      try {
         session = HibernateUtil1.getSessionFactory().openSession();
         transaction = session.getTransaction();
         transaction.begin();

         Person person = new Person();
         person.setName("Mike Lewis");
         session.save(person);

         transaction.commit();
      } catch (Exception e) {
         if (transaction != null) {
            transaction.rollback();
         }
      } finally {
         if (session != null) {
            session.close();
         }
      }

      HibernateUtil1.shutdown();
   }
}
