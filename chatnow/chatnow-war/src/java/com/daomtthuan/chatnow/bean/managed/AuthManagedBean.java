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
package com.daomtthuan.chatnow.bean.managed;

import com.daomtthuan.chatnow.ejb.bean.session.AuthSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 * Auth ManagedBean
 *
 * @author Daomtthuan
 */
@Named(value = "auth")
@SessionScoped
public class AuthManagedBean implements Serializable {

  @EJB
  private AuthSessionBeanLocal auth;

  private String username;
  private String password;
  private String message;
  private boolean loggedIn;

  /**
   * Creates Auth ManagedBean
   */
  public AuthManagedBean() {
    this.username = null;
    this.password = null;
    this.message = null;
    this.loggedIn = false;
  }

  public String login() {
    this.auth.login(this.username, this.password);
    this.loggedIn = this.auth.isLoggedIn();
    if (!this.loggedIn) {
      this.message = "Username or password is wrong";
      return null;
    }

    this.message = null;
    return "home?faces-redirect=true";
  }

  public String logout() {
    this.auth.logout();
    this.loggedIn = this.auth.isLoggedIn();
    return "login?faces-redirect=true";
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMessage() {
    return message;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

}

