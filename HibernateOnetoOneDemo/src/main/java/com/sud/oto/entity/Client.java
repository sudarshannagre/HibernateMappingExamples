package com.sud.oto.entity;

import java.util.Date;

import org.hibernate.Session;

import com.sud.oto.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one exmple using Annotation");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("101");
		stock.setStockName("Salt");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("Tata Salt");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);
		
		session.save(stock);
		session.getTransaction().commit();
		session.close();

		System.out.println("Done");
	}
}
