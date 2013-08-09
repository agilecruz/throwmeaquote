package com.throwmeaquote.category.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface AbstractDao<E, I> {

	E findById(I id);
	void save(E e);
	void delete(E e);
	List findByCriteria(Criterion criterion);
}
