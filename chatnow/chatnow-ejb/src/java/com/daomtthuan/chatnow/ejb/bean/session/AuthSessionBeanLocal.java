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

import javax.ejb.CreateException;
import javax.ejb.Local;

/**
 * Auth SessionBean Local
 *
 * @author Daomtthuan
 */
@Local
public interface AuthSessionBeanLocal {

  /**
   * Creat Auth SessionBean Local
   *
   * @return Auth SessionBean Local
   * @throws CreateException
   */
  AuthSessionBeanLocal create() throws CreateException;

  /**
   * Check is logged in or not
   *
   * @return true if logged in, otherwise false
   */
  Boolean isLoggedIn();

  /**
   * Login
   *
   * @param username Username
   * @param password Password
   */
  void login(final String username, final String password);

  /**
   * Logout
   */
  void logout();

}

