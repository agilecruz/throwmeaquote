package com.throwmeaquote.category.dao.impl;

import org.springframework.stereotype.Repository;

import com.throwmeaquote.category.Category;
import com.throwmeaquote.category.dao.CategoryDao;
import com.throwmeaquote.interfaces.dao.AbstractDaoImpl;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDaoImpl<Category, Long> implements CategoryDao {

	protected CategoryDaoImpl() {
		super();
	}
}
