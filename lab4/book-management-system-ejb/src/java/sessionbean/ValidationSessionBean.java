package sessionbean;

import javax.ejb.Stateless;

@Stateless
public class ValidationSessionBean implements ValidationSessionBeanLocal {

  @Override
  public String validateUsername(final String username) {
    return username.matches("^[a-zA-Z0-9]{4,}$") ? null : "Invalid username";
  }

  @Override
  public String validatePassword(final String password) {
    return password.matches("^.{4,}$") ? null : "Invalid password";
  }

}

