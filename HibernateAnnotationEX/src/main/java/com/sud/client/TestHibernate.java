package com.sud.client;

import org.hibernate.Session;

import com.sud.entity.EmployeeEntity;
import com.sud.util.HibernateUtil;

public class TestHibernate {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		//Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		//emp.setEmployeeId(1);
		emp.setEmail("demo-user@gmail.com");
		emp.setFirstName("test");
		emp.setLastName("user");
		
		session.save(emp);
		
		EmployeeEntity emp1 = new EmployeeEntity();
		//emp.setEmployeeId(1);
		emp1.setEmail("demo-user@gmail.com");
		emp1.setFirstName("test");
		emp1.setLastName("user");
		
		session.save(emp1);
		EmployeeEntity ee = session.get(EmployeeEntity.class, 2);
		System.out.println(ee);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}