package com.daomtthuan.chatnow.ejb.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "role", catalog = "chatnow", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
  @NamedQuery(name = "Role.findById", query = "SELECT r FROM Role r WHERE r.id = :id"),
  @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name"),
  @NamedQuery(name = "Role.findByStatus", query = "SELECT r FROM Role r WHERE r.status = :status")})
public class Role implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Long id;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "name")
  private String name;

  @Basic(optional = false)
  @NotNull
  @Column(name = "status")
  private boolean status;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
  private Collection<Permission> permissionCollection;

  public Role() {
    this.id = null;
    this.name = null;
    this.status = false;
  }

  public Role(String name) {
    this.id = null;
    this.name = name;
    this.status = true;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean getStatus() {
    return this.status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  @XmlTransient
  public Collection<Permission> getPermissionCollection() {
    return this.permissionCollection;
  }

  public void setPermissionCollection(Collection<Permission> permissionCollection) {
    this.permissionCollection = permissionCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.id != null ? this.id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Role)) {
      return false;
    }
    Role other = (Role) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return this.name.equals(other.name);
  }

}
