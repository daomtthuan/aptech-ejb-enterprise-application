package com.daomtthuan.chatnow.war.application.config;

public class DirectoryConfig {

  private String layout;
  private String component;

  public DirectoryConfig(String layout, String component) {
    this.layout = layout;
    this.component = component;
  }

  public String getLayout() {
    return this.layout;
  }

  public void setLayout(String layout) {
    this.layout = layout;
  }

  public String getComponent() {
    return this.component;
  }

  public void setComponent(String component) {
    this.component = component;
  }

}
