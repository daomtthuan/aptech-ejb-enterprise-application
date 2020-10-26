package sessionbean;

import javax.ejb.Local;

@Local
public interface AuthenticationSessionBeanLocal {

  Boolean login(final String username, final String password);

  void logout();

  Boolean isLoggedIn();

}

