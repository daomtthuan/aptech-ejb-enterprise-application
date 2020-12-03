package com.daomtthuan.chatnow.ejb.facade;

import com.daomtthuan.chatnow.ejb.entity.Role;
import java.util.List;
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

  @Override
  public Role findByName(String name) {
    List<Role> roles = this.entityManager.createNamedQuery("Role.findByName").setParameter("name", name).getResultList();
    if (roles.isEmpty()) {
      return null;
    }
    return roles.get(0);
  }

}
