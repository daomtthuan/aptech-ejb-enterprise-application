package daomtthuan.enterpriseapplication.ejb.bean.session;

import daomtthuan.enterpriseapplication.ejb.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Authentication SessionBean
 *
 * @author Daomtthuan
 */
@Stateless
public class AuthenticationSessionBean implements AuthenticationSessionBeanLocal {

  private final List<UserEntity> users;

  /**
   * Creates a new instance of UserSessionBean
   */
  public AuthenticationSessionBean() {
    this.users = new ArrayList<>();
    users.add(new UserEntity(1, "admin", "admin", "Quản trị viên", true));
    users.add(new UserEntity(2, "user1", "user1", "Nguyễn Văn An", false));
    users.add(new UserEntity(3, "user2", "user2", "Lê Văn Bình", false));
  }

  @Override
  public String verify(final String username, final String password) {
    for (UserEntity user : users) {
      if (username.equalsIgnoreCase(user.getUsername()) && password.equals(user.getPassword())) {
        return user.getName();
      }
    }

    return null;
  }

}
