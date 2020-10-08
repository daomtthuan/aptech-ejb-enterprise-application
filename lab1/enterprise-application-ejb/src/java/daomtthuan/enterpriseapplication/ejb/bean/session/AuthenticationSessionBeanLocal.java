package daomtthuan.enterpriseapplication.ejb.bean.session;

import javax.ejb.Local;

/**
 * Authentication SessionBean Local
 *
 * @author Daomtthuan
 */
@Local
public interface AuthenticationSessionBeanLocal {

  /**
   * Verify login User
   *
   * @param username Username UserEnity
   * @param password Password UserEnity
   * @return Name user if success, otherwise null
   */
  String verify(final String username, final String password);

}
