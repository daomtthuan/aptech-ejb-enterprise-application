/*
 * The MIT License
 *
 * Copyright 2020 Daomtthuan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.daomtthuan.chatnow.ejb.bean.session;

import com.daomtthuan.chatnow.ejb.bean.session.entity.UserFacadeLocal;
import com.daomtthuan.chatnow.ejb.entity.User;
import javax.ejb.CreateException;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 * Auth SessionBean
 *
 * @author Daomtthuan
 */
@Stateful
public class AuthSessionBean implements AuthSessionBeanLocal {

  @EJB
  private UserFacadeLocal userFacade;

  private User user;

  @Override
  public AuthSessionBeanLocal create() throws CreateException {
    return this;
  }

  public void ejbCreate() throws CreateException {
    this.user = null;
  }

  @Override
  public Boolean isLoggedIn() {
    return this.user != null;
  }

  @Override
  public void login(final String username, final String password) {
    this.user = userFacade.findByUsername(username);
    if (this.user != null && !this.user.getPassword().equals(password)) {
      this.user = null;
    }
  }

  @Override
  public void logout() {
    this.user = null;
  }

}

