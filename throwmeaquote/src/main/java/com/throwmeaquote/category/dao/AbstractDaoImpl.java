package com.throwmeaquote.category.dao;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
 
public abstract class AbstractDaoImpl<E, I extends Serializable> implements AbstractDao<E,I> {
 
    private Class<E> entityClass;
 
    protected AbstractDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
 
    public E findById(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }
 
    public void save(E e) {
        getCurrentSession().saveOrUpdate(e);
    }
 
    public void delete(E e) {
        getCurrentSession().delete(e);
    }
 
    public List findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
    
        return criteria.list();
    }
}