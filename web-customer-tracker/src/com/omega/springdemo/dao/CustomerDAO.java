package com.omega.springdemo.dao;

import java.util.List;

import com.omega.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
