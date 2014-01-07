package com.throwmeaquote.interfaces.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface AbstractDao<E, I> {

	E findById(Class<E> entityClass, I id);
	void save(E e);
	void delete(E e);
	List findByCriteria(Class<E> entityClass, Criterion criterion);
}
