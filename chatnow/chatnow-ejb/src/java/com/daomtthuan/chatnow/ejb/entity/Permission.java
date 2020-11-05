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
  private Account accountId;

  @JoinColumn(name = "role_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Role roleId;

  public Permission() {
    this.id = null;
    this.accountId = null;
    this.roleId = null;
  }

  public Permission(Account accountId, Role roleId) {
    this.id = null;
    this.accountId = accountId;
    this.roleId = roleId;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Account getAccountId() {
    return this.accountId;
  }

  public void setAccountId(Account accountId) {
    this.accountId = accountId;
  }

  public Role getRoleId() {
    return this.roleId;
  }

  public void setRoleId(Role roleId) {
    this.roleId = roleId;
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
    return this.accountId.equals(other.accountId) && this.roleId.equals(other.roleId);
  }

}
