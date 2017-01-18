package com.jo.sndp.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jo.sndp.dao.GenericDAO;

/**
 * <pre>
 * A DAO implementation for the {@link GenericDAO} using Hibernate.
 * All methods use {@link #getSession()} to get a {@link Session}.
 * 
 * &#64;param <T> the entity class related to this DAO.
 * &#64;param <ID> the type of the field that represents the entity class' primary key.
 * 
  * <h5>&copy; 2015 Sar inventions. All rights reserved.</h5>
 * </pre>
 * 
 * @author : JIJESH
 * @since : Oct 12, 2015
 * @version : 1.0
 * 
 */

@Repository
@Transactional
public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
	private static final long serialVersionUID = -5104946294490148817L;

	private Class<T> entityClass;

	private String entityClassName;

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		Type genericSuperclass;
		Class<?> parametrizedClass = getClass();
		do {
			genericSuperclass = parametrizedClass.getGenericSuperclass();
			if (genericSuperclass instanceof Class) {
				parametrizedClass = (Class<?>) genericSuperclass;
			}
		} while (genericSuperclass != null && !(genericSuperclass instanceof ParameterizedType));
		this.entityClass = (Class<T>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
		if (entityClass != null) {
			entityClassName = entityClass.getSimpleName();
		}
	}

	@SuppressWarnings("unchecked")
	protected T findByUniqueField(String fieldName, Object value) {
		return (T) getSession().createCriteria(entityClass).add(Restrictions.eq(fieldName, value)).uniqueResult();
	}

	@Override
	public void saveOrUpdateAll(Collection<T> entities) {
		Session session = getSession();
		for (T entity : entities) {
			session.saveOrUpdate(entity);
		}
	}

	@Override
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ID save(T entity) {
		return (ID) getSession().save(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public void delete(ID entityId) {
		Session session = getSession();
		Object entity = session.load(entityClass, entityId);
		session.delete(entity);
	}

	

	@Override
	public void deleteAll(Collection<T> entities) {
		Session session = getSession();
		for (T entity : entities) {
			session.delete(entity);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T entity) {
		return (T) getSession().merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return (List<T>) getSession().createQuery("from " + entityClassName).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByPrimaryKey(ID entityId) {
		return (T) getSession().get(entityClass, entityId);
	}

	

	public Class<T> getEntityClass() {
		return entityClass;
	}

}
