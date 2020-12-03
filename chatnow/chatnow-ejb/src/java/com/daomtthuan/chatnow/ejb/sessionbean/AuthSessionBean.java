package com.daomtthuan.chatnow.ejb.sessionbean;

import com.daomtthuan.chatnow.ejb.entity.Account;
import com.daomtthuan.chatnow.ejb.entity.Permission;
import com.daomtthuan.chatnow.ejb.entity.Role;
import com.daomtthuan.chatnow.ejb.facade.AccountFacadeLocal;
import com.daomtthuan.chatnow.ejb.facade.RoleFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class AuthSessionBean implements AuthSessionBeanLocal {

  @EJB
  private AccountFacadeLocal accountFacade;

  @EJB
  private RoleFacadeLocal roleFacade;

  private Account account;

  @Override
  public String login(final String username, final String password) {
    Account tempAccount = this.accountFacade.findByUsername(username);
    if (tempAccount != null && tempAccount.getPassword().equals(password)) {
      this.account = tempAccount;
      for (Permission permission : tempAccount.getPermissionCollection()) {
        if (permission.getRole().getName().endsWith(Role.USER)) {
          return null;
        }
      }
      return "Denied login.";
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

  @Override
  public Boolean isAdmin() {
    if (this.account != null) {
      Role adminRole = this.roleFacade.findByName(Role.ADMIN);
      if (this.account.getPermissionCollection().stream().anyMatch(permission -> (permission.getRole().equals(adminRole)))) {
        return true;
      }
    }
    return false;
  }

}

