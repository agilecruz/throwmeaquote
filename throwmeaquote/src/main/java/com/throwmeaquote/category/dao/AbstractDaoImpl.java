package com.throwmeaquote.category.dao;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class AbstractDaoImpl<E, I extends Serializable> implements AbstractDao<E,I> {
 
    public AbstractDaoImpl() { }

    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
 
    public void setSessionFactory(SessionFactory sessionFactory){
    	this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory(){
    	return this.sessionFactory;
    }
    
    public E findById(Class<E> entityClass, I id) {
        Session currentSession = getCurrentSession();
    	return (E) currentSession.get(entityClass, id);
    }
 
    public void save(E e) {
    	Session currentSession = getCurrentSession();
    	currentSession.saveOrUpdate(e);
    }
 
    public void delete(E e) {
        getCurrentSession().delete(e);
    }
 
    public List findByCriteria(Class<E> entityClass, Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
    
        return criteria.list();
    }
}