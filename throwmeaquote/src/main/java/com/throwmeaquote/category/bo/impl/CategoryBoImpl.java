package com.throwmeaquote.category.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.throwmeaquote.category.Category;
import com.throwmeaquote.category.bo.CategoryBo;
import com.throwmeaquote.category.dao.CategoryDao;
import com.throwmeaquote.category.dao.impl.CategoryDaoImpl;

@Service("categoryBo")
@Transactional
public class CategoryBoImpl implements CategoryBo {

	@Autowired
	private CategoryDao categoryDao;
	
	public CategoryBoImpl(){}
	
	public CategoryBoImpl(CategoryDao categoryDao2){
		this.categoryDao = categoryDao2;
	}
	
	public void setCategoryDao(CategoryDao categoryDao){
		this.categoryDao = categoryDao;
	}
	public Category findById(Long id) {
		return categoryDao.findById(Category.class, id);
	}

	public void save(Category category) {
		categoryDao.save(category);

	}

	public void delete(Category category) {
		categoryDao.delete(category);
	}
}
