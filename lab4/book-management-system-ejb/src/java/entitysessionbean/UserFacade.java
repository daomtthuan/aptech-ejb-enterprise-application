package entitysessionbean;

import entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

  @PersistenceContext(unitName = "book-management-system-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public UserFacade() {
    super(User.class);
  }

  @Override
  public List<User> findByUsername(String username) {
    return em.createNamedQuery("User.findByUsername")
            .setParameter(1, username)
            .getResultList();
  }

}

