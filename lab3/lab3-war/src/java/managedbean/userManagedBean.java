/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import sessionbean.AuthSessionBeanLocal;

/**
 *
 * @author Daomtthuan
 */
@Named(value = "userManagedBean")
@SessionScoped
public class userManagedBean implements Serializable {

  @EJB
  private AuthSessionBeanLocal authSessionBean;

  private String username;
  private String password;
  private String message;
  private boolean loggedIn;

  /**
   * Creates a new instance of userManagedBean
   */
  public userManagedBean() {
  }

  public String login() {
    this.loggedIn = authSessionBean.verify(this.username, this.password);

    if (!this.loggedIn) {
      this.message = "Login failed!";
      return "login?faces-redirect=true";
    }

    this.message = null;
    return "welcome?faces-redirect=true";
  }

  public String redirectWelcome() {
    if (!this.loggedIn) {
      this.message = "Please login";
      return "login?faces-redirect=true";
    }
    return null;
  }

  public String redirectLogin() {
    if (this.loggedIn) {
      return "welcome?faces-redirect=true";
    }
    return null;
  }

  public String logout() {
    this.message = null;
    this.loggedIn = false;
    return "login?faces-redirect=true";
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

}
