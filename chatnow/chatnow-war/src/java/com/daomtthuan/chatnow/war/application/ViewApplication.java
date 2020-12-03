package com.daomtthuan.chatnow.war.application;

import java.io.IOException;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;

@Named(value = "viewApplication")
@ApplicationScoped
public class ViewApplication implements Serializable {

  public String getName() {
    String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
    return viewId.substring(0, viewId.length() - 6);
  }

  public boolean is(String name) {
    return this.getName().equals(name);
  }

  public String getPath(String name) {
    return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + name + ".chatnow";
  }

  public void redirect(String name) throws IOException {
    FacesContext.getCurrentInstance().getExternalContext().redirect(this.getPath(name));
  }

}

