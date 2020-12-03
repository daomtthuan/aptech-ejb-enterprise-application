package com.daomtthuan.chatnow.war.presenter.dashboard;

import com.daomtthuan.chatnow.ejb.entity.Account;
import com.daomtthuan.chatnow.ejb.sessionbean.AccountManagerSessionBeanLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "accountDashboardPresenter")
@ViewScoped
public class AccountDashboardPresenter implements Serializable {

  @EJB
  private AccountManagerSessionBeanLocal accountManagerSessionBean;

  public List<Account> getAccounts() {
    return this.accountManagerSessionBean.select();
  }

  public List<String> getNameRoles(Account account) {
    List<String> roles = new ArrayList<>();
    account.getPermissionCollection().forEach(permission -> roles.add(permission.getRole().getName()));
    return roles;
  }

  public String removeAccount(Account account) {
    this.accountManagerSessionBean.remove(account.getId());
    return null;
  }

}

