/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateful;

/**
 *
 * @author Daomtthuan
 */
@Stateful
public class FullSessionBean implements FullSessionBeanLocal {

  private int count;

  @Override
  public int inc() {
    return ++this.count;
  }

}
