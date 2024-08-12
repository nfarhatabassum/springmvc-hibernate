package com.learning.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.entities.Product;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionfactory;
	Session session;
	boolean flag;

	@Override
	public boolean addProduct(Product p) {
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			session.save(p);// insert query
			session.getTransaction().commit();
			//session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Product> getAllProducts() {
		session = sessionfactory.openSession();
		session.beginTransaction();
		Query query =  session.createQuery("from Product");
		session.getTransaction().commit();
		//session.close();
		List<Product> prodcuts =query.list();
		return prodcuts;
	}

	@Override
	public boolean deleteProductById(int id) {
		List<Product> productList = getAllProducts();
		Optional<Product> productOpt = productList.stream().filter(p->p.getProductId()==id).findAny();
		if(productOpt.isPresent()) {
			sessionfactory.getCurrentSession();
			session.beginTransaction();
			session.delete(productOpt.get());
			session.getTransaction().commit();
			//session.close();
			flag = true;
		}
		return flag;
	}

}
