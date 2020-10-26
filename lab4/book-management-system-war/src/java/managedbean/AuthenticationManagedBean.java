package managedbean;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import sessionbean.AuthenticationSessionBeanLocal;
import sessionbean.ValidationSessionBeanLocal;

@Named(value = "authentication")
@SessionScoped
public class AuthenticationManagedBean implements Serializable {

  @EJB
  private ValidationSessionBeanLocal validation;

  @EJB
  private AuthenticationSessionBeanLocal authentication;

  @ManagedProperty(value = "#{error}")
  private ErrorManagedBean error;

  private String username;
  private String password;
  private String invalidMessage;

  public AuthenticationManagedBean() {
    this.username = null;
    this.password = null;
    this.invalidMessage = null;
  }

  public String login() {
    this.invalidMessage = validation.validateUsername(this.username);
    if (this.invalidMessage != null) {
      this.username = null;
      this.password = null;
      return null;
    }

    this.invalidMessage = validation.validatePassword(this.password);
    if (this.invalidMessage != null) {
      this.username = null;
      this.password = null;
      return null;
    }

    this.authentication.login(this.username, this.password);
    if (!this.isLoggedIn()) {
      this.invalidMessage = "Username or Password is wrong";
      this.username = null;
      this.password = null;
      return null;
    }

    this.username = null;
    this.password = null;
    this.invalidMessage = null;
    return "home.xhtml?faces-redirect=true";
  }

  public String logout() {
    this.authentication.logout();
    if (this.isLoggedIn()) {
      this.error.setCode(500);
      this.error.setMessage("Can not logout");
      return "error.xhtml?faces-redirect=true";
    }

    this.invalidMessage = null;
    return "login.xhtml?faces-redirect=true";
  }

  public void redirect() throws IOException {
    FacesContext context = FacesContext.getCurrentInstance();
    String viewId = context.getViewRoot().getViewId();
    if (viewId.equals("/login.xhtml") && this.isLoggedIn()) {
      context.getExternalContext().redirect("home.html");
    }
    if (viewId.equals("/book.xhtml") && !this.isLoggedIn()) {
      context.getExternalContext().redirect("login.html");
    }
  }

  public boolean isLoggedIn() {
    return authentication.isLoggedIn().equals(Boolean.TRUE);
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

  public String getInvalidMessage() {
    return invalidMessage;
  }

  public ErrorManagedBean getError() {
    return error;
  }

}

