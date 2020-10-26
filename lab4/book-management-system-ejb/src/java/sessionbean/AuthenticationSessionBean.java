package sessionbean;

import entity.User;
import entitysessionbean.UserFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class AuthenticationSessionBean implements AuthenticationSessionBeanLocal {

  @EJB
  private UserFacadeLocal userFacade;

  private User user;

  public AuthenticationSessionBean() {
    this.user = null;
  }

  @Override
  public Boolean login(final String username, final String password) {
    List<User> users = userFacade.findByUsername(username);
    if (users.size() != 1) {
      return false;
    }

    if (!users.get(0).getPassword().equals(password)) {
      return false;
    }

    user = users.get(0);
    return true;
  }

  @Override
  public void logout() {
    this.user = null;
  }

  @Override
  public Boolean isLoggedIn() {
    return user != null;
  }

}

