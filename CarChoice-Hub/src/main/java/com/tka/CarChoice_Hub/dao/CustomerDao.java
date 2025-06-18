package com.tka.CarChoice_Hub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import com.tka.CarChoice_Hub2.dto.CustomerUpdateDTO;
import com.tka.CarChoice_Hub2.entity.Customer;

@Repository
public class CustomerDao {
	
	@Autowired
	SessionFactory factory;

	public String insertCustomer(Customer customer) {
		String msg = null;
		try(Session session = factory.openSession()){
			Transaction tx = session.beginTransaction();
			try {
				session.merge(customer);
				tx.commit();
				
				msg = "Customer Inserted Successfully...";
				
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Customer Inserted Failed : "+ e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String updateCustomer(long id, CustomerUpdateDTO dto) {
		String msg = null;
		try(Session session =  factory.openSession()){
			Transaction tx = session.beginTransaction();
			try {
				Customer customer = session.get(Customer.class, id);
				if (customer != null) {
					customer.setFullName(dto.getFullName());
					customer.setEmail(dto.getEmail());
					customer.setPhoneNumber(dto.getPhoneNumber());
					customer.setAddress(dto.getAddress());
					customer.setPinCode(dto.getPinCode());
					customer.setPaymentMethod(dto.getPaymentMethod());
					customer.setLoanApprovalStatus(dto.getLoanApprovalStatus());
					customer.setCar(dto.getCar());

					session.merge(customer);
					tx.commit();
					msg = "Customer Updated Successfully...";
				}
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Customer Updated Failed : "+ e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String deleteCustomer(long id) {
		String msg = null;
		try(Session session = factory.openSession()){
			Transaction tx = session.beginTransaction();
			try {
				Customer customer = session.get(Customer.class, id);
				if (customer != null) {
					session.remove(customer);
					tx.commit();
					msg = "Customer Deleted Successfully...";
				}
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Customer Deletd Failed : " + e.getMessage() ; 
				e.printStackTrace();
				
			
			}
		}
		return msg;
	}

	public Customer getCustomerById(long id) {
		Customer customer = null;
		try(Session session = factory.openSession()){
			customer = session.get(Customer.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public List<Customer> getAllCustomer() {
		
		List<Customer> customerList = null;
		
		String hqlQuery = "from Customer";
		
		try(Session session = factory.openSession()){
			Query<Customer> query = session.createQuery(hqlQuery, Customer.class);
			customerList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}

	public Customer loginUser(Customer c) {
		
		Customer customer = null;
		
		String hqlQuery = "from Customer WHERE email = :email and phoneNumber = :phoneNumber";
		
		try(Session session = factory.openSession()){
			Transaction tx = session.beginTransaction();
			try {
				Query<Customer> query = session.createQuery(hqlQuery, Customer.class);
				query.setParameter("email", c.getEmail());
				query.setParameter("phoneNumber", c.getPhoneNumber());
				customer = query.uniqueResult();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
		}
		return customer;
	}

	

}
