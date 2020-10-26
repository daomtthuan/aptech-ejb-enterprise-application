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
package com.daomtthuan.chatnow.ejb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User entity
 *
 * @author Daomtthuan
 */
@Entity
@Table(name = "user", catalog = "chatnow", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
  @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
  @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
  @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
  @NamedQuery(name = "User.findByAdmin", query = "SELECT u FROM User u WHERE u.admin = :admin"),
  @NamedQuery(name = "User.findByState", query = "SELECT u FROM User u WHERE u.state = :state")})
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "username")
  private String username;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "password")
  private String password;
  @Column(name = "admin")
  private Boolean admin;
  @Column(name = "state")
  private Boolean state;

  public User() {
  }

  public User(Integer id) {
    this.id = id;
  }

  public User(Integer id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public Boolean getAdmin() {
    return admin;
  }

  public void setAdmin(Boolean admin) {
    this.admin = admin;
  }

  public Boolean getState() {
    return state;
  }

  public void setState(Boolean state) {
    this.state = state;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof User)) {
      return false;
    }
    User other = (User) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.daomtthuan.chatnow.ejb.entity.User[ id=" + id + " ]";
  }

}

