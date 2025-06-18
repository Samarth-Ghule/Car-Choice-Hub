package com.tka.CarChoice_Hub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import com.tka.CarChoice_Hub2.dto.CarUpdateDTO;
import com.tka.CarChoice_Hub2.entity.Car;

@Repository
public class CarDao {
	
	@Autowired
	SessionFactory factory;

	public String insertCar(Car car) {
		String msg = null;
		try(Session session = factory.openSession()){
			Transaction tx = session.beginTransaction();
			try {
				session.persist(car);
				tx.commit();
				
				msg = "Car Inserted Successfully...";
				
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Car Inserted Failed : "+ e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String updateCar(long id, CarUpdateDTO dto) {
		String msg = null;
		try(Session session = factory.openSession()){
			Transaction tx = session.beginTransaction();
			try {
				Car c = session.get(Car.class, id);
				if (c != null) {
					c.setFuelType(dto.getFuelType());
					c.setEnginePower(dto.getEnginePower());
					c.setPrice(dto.getPrice());
					session.merge(c);
					tx.commit();
					msg = "Car Updated Successfully...";
				}
				
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Car Updated Failed : "+ e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String deleteCar(long id) {
		String msg = null;
		try(Session session = factory.openSession()){
			Transaction tx = session.beginTransaction();
			try {
				Car car = session.get(Car.class, id);
				if (car != null) {
					session.remove(car);
					tx.commit();
					
					msg = "Car Deleted Successfully...";
				}
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Car Deleted Failed : "+ e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}

	public Car getCarById(long id) {
		Car car = null;
		try(Session session = factory.openSession()){
			car = session.get(Car.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}

	public List<Car> getAllCar() {
		String hqlQuery = "from Car";
		List <Car> carList = null;
		try(Session session  = factory.openSession()){
			Query<Car> query = session.createQuery(hqlQuery, Car.class);
			carList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carList;
	}
	
	
}
