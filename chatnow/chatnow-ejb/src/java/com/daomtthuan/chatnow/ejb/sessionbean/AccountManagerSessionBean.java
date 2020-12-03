package com.daomtthuan.chatnow.ejb.sessionbean;

import com.daomtthuan.chatnow.ejb.entity.Account;
import com.daomtthuan.chatnow.ejb.entity.Permission;
import com.daomtthuan.chatnow.ejb.entity.Role;
import com.daomtthuan.chatnow.ejb.facade.AccountFacadeLocal;
import com.daomtthuan.chatnow.ejb.facade.PermissionFacadeLocal;
import com.daomtthuan.chatnow.ejb.facade.RoleFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AccountManagerSessionBean implements AccountManagerSessionBeanLocal {

  @EJB
  private AccountFacadeLocal accountFacade;

  @EJB
  private PermissionFacadeLocal permissionFacade;

  @EJB
  private RoleFacadeLocal roleFacade;

  @Override
  public List<Account> select() {
    return this.accountFacade.findAll();
  }

  @Override
  public Account select(final Long id) {
    return this.accountFacade.find(id);
  }

  @Override
  public String create(final String username, final String password, final String name) {
    if (this.accountFacade.findByUsername(username) != null) {
      return "Username already exists.";
    }

    Account account = this.accountFacade.create(new Account(username, password, name));
    this.permissionFacade.create(new Permission(account, this.roleFacade.findByName(Role.USER)));

    return null;
  }

  @Override
  public String edit(final Long id, final String name, final Boolean status) {
    Account account = this.select(id);
    if (account == null) {
      return "Account not found.";
    }
    account.setName(name);
    account.setStatus(status);
    this.accountFacade.edit(account);
    return null;
  }

  @Override
  public String remove(final Long id) {
    Account account = this.select(id);
    if (account == null) {
      return "Account not found.";
    }
    this.accountFacade.remove(account);
    return null;
  }

}

