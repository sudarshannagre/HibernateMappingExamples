package com.sud.criteriaAPI;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.sud.entity.Book;
import com.sud.util.HibernateUtility;

public class ProjectionEx {

	//reading partial entity using projection
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Criteria ct = session.createCriteria(Book.class);
		Projection pj1 = Projections.property("title");
		Projection pj2 = Projections.property("price");
		
		ProjectionList pjList = Projections.projectionList();
		pjList.add(pj1);
		pjList.add(pj2);
		
		ct.setProjection(pjList);
		List list = ct.list();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Object[] b = (Object[]) it.next();
			System.out.println(b[0]+" "+b[1]);
		}
	}

}
