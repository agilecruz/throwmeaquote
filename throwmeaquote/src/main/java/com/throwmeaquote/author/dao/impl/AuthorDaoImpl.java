package com.throwmeaquote.author.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import com.throwmeaquote.author.Author;
import com.throwmeaquote.author.dao.AuthorDao;

@Repository("authorDao")
public class AuthorDaoImpl implements AuthorDao {

	public Author findById(Class<Author> entityClass, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Author e) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Author e) {
		// TODO Auto-generated method stub
		
	}

	public List findByCriteria(Class<Author> entityClass, Criterion criterion) {
		// TODO Auto-generated method stub
		return null;
	}

}
