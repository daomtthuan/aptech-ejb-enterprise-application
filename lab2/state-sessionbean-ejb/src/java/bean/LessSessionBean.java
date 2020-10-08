/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;

/**
 *
 * @author Daomtthuan
 */
@Stateless
public class LessSessionBean implements LessSessionBeanLocal {

  private int count;

  @Override
  public int inc() {
    return ++this.count;
  }

}
