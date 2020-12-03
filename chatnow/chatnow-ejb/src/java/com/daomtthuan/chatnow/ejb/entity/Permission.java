package com.daomtthuan.chatnow.ejb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "permission", catalog = "chatnow", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p"),
  @NamedQuery(name = "Permission.findById", query = "SELECT p FROM Permission p WHERE p.id = :id")})
public class Permission implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Long id;

  @JoinColumn(name = "account_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Account account;

  @JoinColumn(name = "role_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Role role;

  public Permission() {
    this.id = null;
    this.account = null;
    this.role = null;
  }

  public Permission(Account account, Role role) {
    this.id = null;
    this.account = account;
    this.role = role;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Account getAccount() {
    return this.account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Role getRole() {
    return this.role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.id != null ? this.id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Permission)) {
      return false;
    }
    Permission other = (Permission) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return this.account.equals(other.account) && this.role.equals(other.role);
  }

}
