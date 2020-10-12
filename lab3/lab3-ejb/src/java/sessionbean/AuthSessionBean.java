/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import javax.ejb.Stateful;

/**
 * Authentication SessionBean
 *
 * @author Daomtthuan
 */
@Stateful
public class AuthSessionBean implements AuthSessionBeanLocal {

  @Override
  public boolean verify(final String username, final String password) {
    return username.equalsIgnoreCase("admin") && password.equals("admin");
  }

}
