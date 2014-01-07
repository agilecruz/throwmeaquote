package com.throwmeaquote.author.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.throwmeaquote.author.bo.AuthorBo;
import com.throwmeaquote.author.dao.AuthorDao;

@Service("authorBo")
@Transactional
public class AuthorBoImpl implements AuthorBo {

	@Autowired
	AuthorDao dao;
	
	public AuthorBoImpl(){}
	
	public AuthorBoImpl(AuthorDao dao){
		this.dao = dao;
	}
	
	public AuthorBo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(AuthorBo author) {
		// TODO Auto-generated method stub
		
	}

	public void delete(AuthorBo author) {
		// TODO Auto-generated method stub
		
	}

}
