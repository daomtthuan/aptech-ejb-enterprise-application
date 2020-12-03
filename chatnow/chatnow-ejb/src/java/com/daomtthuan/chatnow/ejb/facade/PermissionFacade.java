package com.daomtthuan.chatnow.ejb.facade;

import com.daomtthuan.chatnow.ejb.entity.Permission;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PermissionFacade extends AbstractFacade<Permission> implements PermissionFacadeLocal {

  @PersistenceContext(unitName = "chatnow-ejbPU")
  private EntityManager entityManager;

  @Override
  protected EntityManager getEntityManager() {
    return this.entityManager;
  }

  public PermissionFacade() {
    super(Permission.class);
  }

}
