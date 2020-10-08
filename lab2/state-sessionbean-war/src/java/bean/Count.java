/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Daomtthuan
 */
@Named(value = "count")
@SessionScoped
public class Count implements Serializable {

  @EJB
  private LessSessionBeanLocal lessSessionBean;

  @EJB
  private FullSessionBeanLocal fullSessionBean;

  /**
   * Creates a new instance of Count
   */
  public Count() {
  }

  public LessSessionBeanLocal getLessSessionBean() {
    return lessSessionBean;
  }

  public void setLessSessionBean(LessSessionBeanLocal lessSessionBean) {
    this.lessSessionBean = lessSessionBean;
  }

  public FullSessionBeanLocal getFullSessionBean() {
    return fullSessionBean;
  }

  public void setFullSessionBean(FullSessionBeanLocal fullSessionBean) {
    this.fullSessionBean = fullSessionBean;
  }

}
