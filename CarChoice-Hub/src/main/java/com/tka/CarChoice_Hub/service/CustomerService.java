package com.tka.CarChoice_Hub.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.CarChoice_Hub2.dao.CustomerDao;
import com.tka.CarChoice_Hub2.dto.CustomerUpdateDTO;
import com.tka.CarChoice_Hub2.entity.Customer;

import jakarta.validation.Valid;


@Service
public class CustomerService {
	
	@Autowired
	CustomerDao dao;

	public String insertCustomer(Customer c) {
		String msg = dao.insertCustomer(c);
		return msg;
	}

	public String updateCustomer(long id, CustomerUpdateDTO dto) {
		String msg = dao.updateCustomer(id, dto);
		return msg;
	}

	public String deleteCustomer(long id) {
		String msg = dao.deleteCustomer(id);
		return msg;
	}

	public Customer getCustomerById(long id) {
		Customer customer = dao.getCustomerById(id);
		return customer;
	}

	public List<Customer> getAllCustomer() {
		List <Customer> customerList = dao.getAllCustomer();
		return customerList;
	}

	public Map loginUser(Customer c) {
		Customer customer = dao.loginUser(c);
		
		Map map = new HashMap<>();
		if (Objects.isNull(c)) {
			map.put("msg", "Invalid User");
			map.put("User", customer);
		}else {
			map.put("msg", "Valid User");
			map.put("User", customer);
		}
		return map;
	}

	public Map getCustomerByLoanApprovalStatus(String loanApprovalStatus) {
		
		List<Customer> allCustomer = dao.getAllCustomer();
		List<Customer> statusList = new ArrayList<Customer>();
		
		Map map = new HashMap<>(); 
		
		for (Customer c : allCustomer) {
			if (c.getLoanApprovalStatus().equalsIgnoreCase(loanApprovalStatus)) {
				statusList.add(c);
			}
		}
		
		if (!statusList.isEmpty()) {
			map.put("msg", "Status : "+ loanApprovalStatus);
			map.put("Customer Details", statusList);
		}else {
			map.put("msg", "Status : "+ loanApprovalStatus);
			map.put("Customer Details", statusList);
		}
		
		return map;
	}

}
