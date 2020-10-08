package daomtthuan.enterpriseapplication.war.model;

/**
 * User Model
 *
 * @author Daomtthuan
 */
public class User {

  private String username;
  private String password;
  private String name;
  private boolean loggedIn;

  /**
   * Creates a new instance of User
   */
  public User() {
    this.username = null;
    this.password = null;
    this.name = null;
    this.loggedIn = false;
  }

  /**
   * Creates a new instance of User
   *
   * @param username Username User
   * @param password Password User
   * @param name Name User
   * @param loggedIn Is logged in or not
   */
  public User(String username, String password, String name, boolean loggedIn) {
    this.username = username;
    this.password = password;
    this.name = name;
    this.loggedIn = loggedIn;
  }

  /**
   * Get Username User
   *
   * @return Username User
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set Username User
   *
   * @param username Username User
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Get Password User
   *
   * @return Password User
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set Password User
   *
   * @param password Password User
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get Name User
   *
   * @return Name UserEntity
   */
  public String getName() {
    return name;
  }

  /**
   * Set Name User
   *
   * @param name Name UserEntity
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get Is logged in or not
   *
   * @return Is logged in or not
   */
  public boolean isLoggedIn() {
    return loggedIn;
  }

  /**
   * Set Is logged in or not
   *
   * @param loggedIn Is logged in or not
   */
  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

}
