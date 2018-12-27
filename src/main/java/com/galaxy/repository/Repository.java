package com.galaxy.repository;

import java.util.List;

//Interface for all daos
public interface Repository<T> {

	public void add(T t);
	public void update(T t);
	public List<T> getList();
	public T getById(int id);
	public void remove(int id);
}
