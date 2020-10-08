package daomtthuan.enterpriseapplication.ejb.entity;

/**
 * User Entity
 *
 * @author Daomtthuan
 */
public class UserEntity {

  private int id;
  private String username;
  private String password;
  private String name;
  private boolean admin;

  /**
   * Creates a new instance of UserEntity
   */
  public UserEntity() {
    this.id = -1;
    this.username = null;
    this.password = null;
    this.name = null;
    this.admin = false;
  }

  /**
   * Creates a new instance of UserEntity
   *
   * @param id Id UserEntity
   * @param username Username UserEntity
   * @param password Password UserEntity
   * @param name Name UserEntity
   * @param admin Is Administrator UserEntity
   */
  public UserEntity(int id, String username, String password, String name, boolean admin) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.name = name;
    this.admin = admin;
  }

  /**
   * Get Id UserEntity
   *
   * @return Id UserEntity
   */
  public long getId() {
    return id;
  }

  /**
   * Set Id UserEntity
   *
   * @param id Id UserEntity
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Get Username UserEntity
   *
   * @return Username UserEntity
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set Username UserEntity
   *
   * @param username Username UserEntity
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Get Password UserEntity
   *
   * @return Password UserEntity
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set Password UserEntity
   *
   * @param password Password UserEntity
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get Name UserEntity
   *
   * @return Name UserEntity
   */
  public String getName() {
    return name;
  }

  /**
   * Set Name UserEntity
   *
   * @param name Name UserEntity
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Is Administrator UserEntity
   *
   * @return Is Administrator UserEntity or not
   */
  public boolean isAdmin() {
    return admin;
  }

  /**
   * Set is Administrator UserEntity
   *
   * @param admin Is Administrator UserEntity
   */
  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

}
