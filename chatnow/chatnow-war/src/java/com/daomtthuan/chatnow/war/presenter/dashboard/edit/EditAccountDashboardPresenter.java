package com.daomtthuan.chatnow.war.presenter.dashboard.edit;

import com.daomtthuan.chatnow.ejb.entity.Account;
import com.daomtthuan.chatnow.ejb.sessionbean.AccountManagerSessionBeanLocal;
import com.daomtthuan.chatnow.war.application.RequestApplication;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "editAccountDashboardPresenter")
@ViewScoped
public class EditAccountDashboardPresenter implements Serializable {

  @Inject
  private RequestApplication requestApplication;

  @EJB
  private AccountManagerSessionBeanLocal accountManagerSessionBean;

  private Long id;
  private String name;
  private boolean status;
  private boolean error;
  private String message;

  @PostConstruct
  public void initialize() {
    this.id = Long.valueOf(this.requestApplication.getParameter("id"));
    Account account = this.accountManagerSessionBean.select(this.id);
    this.name = account.getName();
    this.status = account.getStatus();
    this.error = false;
    this.message = null;
  }

  public String edit() {
    if (this.name == null || this.name.isEmpty()) {
      this.message = "Name is empty";
    } else {
      this.message = accountManagerSessionBean.edit(this.id, this.name, this.status);
    }
    this.error = this.message != null;
    if (this.error) {
      return null;
    }
    return "/dashboard/account?faces-redirect=true";
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean getStatus() {
    return this.status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getMessage() {
    return this.message;
  }

  public boolean isError() {
    return this.error;
  }

}

