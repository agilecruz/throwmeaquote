package com.throwmeaquote.category.bo;

import com.throwmeaquote.category.Category;

public interface CategoryBo {
	Category findById(Long id);
	void save(Category category);
	void delete(Category category);
}
