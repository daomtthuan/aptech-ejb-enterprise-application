package com.daomtthuan.chatnow.war.presenter.dashboard.create;

import com.daomtthuan.chatnow.ejb.sessionbean.AccountManagerSessionBeanLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "createAccountDashboardPresenter")
@ViewScoped
public class CreateAccountDashboardPresenter implements Serializable {

  @EJB
  private AccountManagerSessionBeanLocal accountManagerSessionBean;

  private String username;
  private String password;
  private String repassword;
  private String name;
  private boolean error;
  private String message;

  @PostConstruct
  public void initialize() {
    this.username = null;
    this.password = null;
    this.repassword = null;
    this.name = null;
    this.error = false;
    this.message = null;
  }

  public String create() {
    if (this.username == null || this.username.isEmpty()) {
      this.message = "Username is empty";
    } else if (this.password == null || this.password.isEmpty()) {
      this.message = "Username is empty";
    } else if (!this.password.equals(this.repassword)) {
      this.message = "Password and re-password not match.";
    } else if (this.name == null || this.name.isEmpty()) {
      this.message = "Name is empty";
    } else {
      this.message = accountManagerSessionBean.create(this.username, this.password, this.name);
    }
    this.error = this.message != null;
    if (this.error) {
      return null;
    }
    return "/dashboard/account?faces-redirect=true";
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRepassword() {
    return this.repassword;
  }

  public void setRepassword(String repassword) {
    this.repassword = repassword;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMessage() {
    return this.message;
  }

  public boolean isError() {
    return this.error;
  }

}

