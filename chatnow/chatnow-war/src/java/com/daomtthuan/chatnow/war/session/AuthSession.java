package com.daomtthuan.chatnow.war.session;

import com.daomtthuan.chatnow.ejb.entity.Account;
import com.daomtthuan.chatnow.ejb.sessionbean.AuthSessionBeanLocal;
import com.daomtthuan.chatnow.war.application.ViewApplication;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;

@Named(value = "authSession")
@SessionScoped
public class AuthSession implements Serializable {

  @EJB
  private AuthSessionBeanLocal authSessionBean;

  @Inject
  private ViewApplication viewApplication;

  public String login(String username, String password) {
    return this.authSessionBean.login(username, password);
  }

  public String logout() {
    if (this.authSessionBean.logount() != null) {
      return "login?faces-redirect=true";
    }
    return null;
  }

  public boolean isLoggedIn() {
    return this.authSessionBean.isLoggedIn();
  }

  public Account getAccount() {
    return this.authSessionBean.getAccount();
  }

  public void redirect() throws IOException {
    if (this.authSessionBean.isLoggedIn()
            && (this.viewApplication.is("login") || this.viewApplication.is("register"))) {
      this.viewApplication.redirect("account");
    } else if (!this.authSessionBean.isLoggedIn()
            && this.viewApplication.is("account")) {
      this.viewApplication.redirect("login");
    }
  }

}

