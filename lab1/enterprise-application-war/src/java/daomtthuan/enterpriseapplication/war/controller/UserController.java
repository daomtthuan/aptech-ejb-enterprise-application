package daomtthuan.enterpriseapplication.war.controller;

import daomtthuan.enterpriseapplication.ejb.bean.session.AuthenticationSessionBeanLocal;
import daomtthuan.enterpriseapplication.war.model.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 * User Controller
 *
 * @author Daomtthuan
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

  @EJB
  private AuthenticationSessionBeanLocal authentication;

  private User model;
  private String error;

  /**
   * Creates a new instance of UserController
   */
  public UserController() {
    this.model = new User();
    this.error = null;
  }

  private boolean validate() {
    if (model.getUsername() == null || model.getUsername().equals("")) {
      this.error = "Enter your username";
      return false;
    }

    if (model.getPassword() == null || model.getPassword().equals("")) {
      this.error = "Enter your password";
      return false;
    }

    this.error = null;
    return true;
  }

  /**
   * Login
   *
   * @return Name page after verifying
   */
  public String login() {
    if (this.validate()) {
      String name = authentication.verify(model.getUsername(), model.getPassword());
      this.model.setLoggedIn(name != null);

      if (!this.model.isLoggedIn()) {
        this.model = new User();
        this.error = "Username or password is wrong";
      } else {
        this.model.setName(name);
        this.error = null;
        return "welcome";
      }
    }

    return "login";
  }

  /**
   * Logout
   *
   * @return Name page after verifying
   */
  public String logout() {
    this.model = new User();
    this.error = null;
    return "login";
  }

  /**
   * Get User model
   *
   * @return User model
   */
  public User getModel() {
    return model;
  }

  /**
   * Get Error
   *
   * @return Error
   */
  public String getError() {
    return error;
  }
}
