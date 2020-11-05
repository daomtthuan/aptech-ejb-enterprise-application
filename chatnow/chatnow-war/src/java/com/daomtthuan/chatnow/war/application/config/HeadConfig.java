package com.daomtthuan.chatnow.war.application.config;

public class HeadConfig {

  private String title;
  private String description;
  private String author;
  private String keywords;

  public HeadConfig(String title, String description, String author, String keywords) {
    this.title = title;
    this.description = description;
    this.author = author;
    this.keywords = keywords;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getKeywords() {
    return this.keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

}
