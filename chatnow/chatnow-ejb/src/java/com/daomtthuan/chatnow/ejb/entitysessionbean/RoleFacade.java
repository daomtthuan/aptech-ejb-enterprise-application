package com.daomtthuan.chatnow.ejb.entitysessionbean;

import com.daomtthuan.chatnow.ejb.entity.Role;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RoleFacade extends AbstractFacade<Role> implements RoleFacadeLocal {

  @PersistenceContext(unitName = "chatnow-ejbPU")
  private EntityManager entityManager;

  @Override
  protected EntityManager getEntityManager() {
    return this.entityManager;
  }

  public RoleFacade() {
    super(Role.class);
  }

}
