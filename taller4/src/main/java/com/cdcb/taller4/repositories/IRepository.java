package com.cdcb.taller4.repositories;

import java.util.List;

import com.cdcb.taller4.exceptions.CuentaNoEncontrada;

public interface IRepository<T> {
	void connect();
	void createTable();
	void executeQuery(String query);
	void insert(T entity);
	List<T> selectAll();
	T selectById(int id) throws CuentaNoEncontrada;
	void update(T entity , int id) throws CuentaNoEncontrada;
	void delete(int id) throws CuentaNoEncontrada;
}
