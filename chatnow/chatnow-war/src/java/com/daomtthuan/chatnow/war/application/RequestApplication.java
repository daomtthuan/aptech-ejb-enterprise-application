package com.daomtthuan.chatnow.war.application;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

@Named(value = "requestApplication")
@RequestScoped
public class RequestApplication {

  public String getParameter(String key) {
    return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
  }

}

