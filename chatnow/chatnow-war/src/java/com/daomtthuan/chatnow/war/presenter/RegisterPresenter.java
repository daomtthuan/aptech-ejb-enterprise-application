package com.daomtthuan.chatnow.war.presenter;

import com.daomtthuan.chatnow.war.session.AuthSession;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "registerPresenter")
@ViewScoped
public class RegisterPresenter implements Serializable {

  @Inject
  private AuthSession authSession;

  private String username;
  private String password;
  private String repassword;
  private String name;
  private boolean accepted;
  private boolean error;
  private String message;

  public RegisterPresenter() {
    this.username = null;
    this.password = null;
    this.repassword = null;
    this.name = null;
    this.accepted = false;
    this.error = false;
    this.message = null;
  }

  public String register() {
    this.message = authSession.login(this.username, this.password);
    this.error = this.message != null;

    if (this.error) {
      return null;
    }
    return "index?faces-redirect=true";
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

  public boolean isAccepted() {
    return this.accepted;
  }

  public void setAccepted(boolean accepted) {
    this.accepted = accepted;
  }

  public String getMessage() {
    return this.message;
  }

  public boolean isError() {
    return this.error;
  }
}

