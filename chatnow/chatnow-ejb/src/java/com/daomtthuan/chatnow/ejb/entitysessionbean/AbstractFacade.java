package com.daomtthuan.chatnow.ejb.entitysessionbean;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class AbstractFacade<T> {

  private final Class<T> entityClass;

  public AbstractFacade(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  protected abstract EntityManager getEntityManager();

  public void create(T entity) {
    this.getEntityManager().persist(entity);
  }

  public void edit(T entity) {
    this.getEntityManager().merge(entity);
  }

  public void remove(T entity) {
    this.getEntityManager().remove(this.getEntityManager().merge(entity));
  }

  public T find(Object id) {
    return this.getEntityManager().find(this.entityClass, id);
  }

  public List<T> findAll() {
    javax.persistence.criteria.CriteriaQuery cq = this.getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(this.entityClass));
    return this.getEntityManager().createQuery(cq).getResultList();
  }

  public List<T> findRange(int[] range) {
    javax.persistence.criteria.CriteriaQuery cq = this.getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(this.entityClass));
    javax.persistence.Query q = this.getEntityManager().createQuery(cq);
    q.setMaxResults(range[1] - range[0] + 1);
    q.setFirstResult(range[0]);
    return q.getResultList();
  }

  public int count() {
    javax.persistence.criteria.CriteriaQuery cq = this.getEntityManager().getCriteriaBuilder().createQuery();
    javax.persistence.criteria.Root<T> rt = cq.from(this.entityClass);
    cq.select(this.getEntityManager().getCriteriaBuilder().count(rt));
    javax.persistence.Query q = this.getEntityManager().createQuery(cq);
    return ((Long) q.getSingleResult()).intValue();
  }

}
