package com.daomtthuan.chatnow.ejb.sessionbean;

import com.daomtthuan.chatnow.ejb.entity.Account;
import com.daomtthuan.chatnow.ejb.entitysessionbean.AccountFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class AuthSessionBean implements AuthSessionBeanLocal {

  @EJB
  private AccountFacadeLocal accountFacade;

  private Account account;

  @Override
  public String login(final String username, final String password) {
    Account tempAccount = this.accountFacade.findByUsername(username);
    if (tempAccount != null && tempAccount.getPassword().equals(password)) {
      this.account = tempAccount;
      return null;
    }
    return "Username or password is wrong.";
  }

  @Override
  public String logount() {
    this.account = null;
    return null;
  }

  @Override
  public Boolean isLoggedIn() {
    return this.account != null;
  }

  @Override
  public Account getAccount() {
    return this.account;
  }

}

