package com.jo.sndp.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: adi
 * Date: 23.04.12
 * Time: 18:17
 * To change this template use File | Settings | File Templates.
 */
public interface GenericDAO<T, ID extends Serializable> extends Serializable
{
   /**
    * Save or updates the collection of entities.
    *
    * @param entities collection of entities
    */
   public void saveOrUpdateAll(Collection<T> entities);

   /**
    * Save or Update an entity.
    *
    * @param entity entity
    */
   public void saveOrUpdate(T entity);

   /**
    * Update an entity.
    *
    * @param entity entity to update
    */
   public void update(T entity);

   /**
    * Persist an entity.
    *
    * @param entity entity
    * @return id of persisted entity
    */
   public ID save(T entity);

   /**
    * Delete an entity.
    *
    * @param entity entity to delete
    */
   public void delete(T entity);

   /**
    * Delete an entity.
    *
    * @param entityId entity identifier
    */
   public void delete(ID entityId);

   /**
    * Hard delete the collection of entities.
    * @param entities - collection of entities.
    */
   public void deleteAll(Collection<T> entities);

   /**
    * Persists the detached object
    * @param entity - entity to be persisted
    * @return - merged entity
    */
   public T merge(T entity);

   /**
    * Returns a list of entities for the specified entity class.
    *
    * @return list of all entities in database
    */
   public List<T> findAll();

   /**
    * Find an entity by its PK.
    *
    * @param entityId entity identifier
    * @return entity
    */
   public T findByPrimaryKey(ID entityId);

}
