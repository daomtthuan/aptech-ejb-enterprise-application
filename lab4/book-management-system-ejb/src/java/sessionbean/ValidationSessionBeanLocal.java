package sessionbean;

import javax.ejb.Local;

@Local
public interface ValidationSessionBeanLocal {

  String validateUsername(final String username);

  String validatePassword(final String password);

}

