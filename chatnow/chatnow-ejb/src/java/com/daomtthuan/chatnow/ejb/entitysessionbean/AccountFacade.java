package com.daomtthuan.chatnow.ejb.entitysessionbean;

import com.daomtthuan.chatnow.ejb.entity.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {

  @PersistenceContext(unitName = "chatnow-ejbPU")
  private EntityManager entityManager;

  @Override
  protected EntityManager getEntityManager() {
    return this.entityManager;
  }

  public AccountFacade() {
    super(Account.class);
  }

  @Override
  public Account findByUsername(final String username) {
    List<Account> accounts = this.entityManager.createNamedQuery("Account.findByUsername").setParameter("username", username).getResultList();
    if (accounts.isEmpty()) {
      return null;
    }
    return accounts.get(0);
  }

}
