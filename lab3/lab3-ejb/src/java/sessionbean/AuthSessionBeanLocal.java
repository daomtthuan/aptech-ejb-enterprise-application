/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import javax.ejb.Local;

/**
 *
 * @author Daomtthuan
 */
@Local
public interface AuthSessionBeanLocal {

  boolean verify(final String username, final String password);

}
