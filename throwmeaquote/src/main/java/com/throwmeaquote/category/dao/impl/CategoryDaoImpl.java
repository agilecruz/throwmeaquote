package com.throwmeaquote.category.dao.impl;

import org.springframework.stereotype.Repository;

import com.throwmeaquote.category.Category;
import com.throwmeaquote.category.dao.AbstractDaoImpl;
import com.throwmeaquote.category.dao.CategoryDao;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDaoImpl<Category, Long> implements CategoryDao {

	protected CategoryDaoImpl() {
		super();
	}
}
