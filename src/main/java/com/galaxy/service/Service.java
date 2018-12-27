package com.galaxy.service;

import java.util.List;

//Interface for all services
public interface Service<T> {

	public void get(T p);
	public void put(T p);
	public void post();
	public void remove(int id);
	
}
