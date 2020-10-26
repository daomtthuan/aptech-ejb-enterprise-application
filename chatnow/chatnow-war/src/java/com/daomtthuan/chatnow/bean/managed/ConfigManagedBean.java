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

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 * Application config
 *
 * @author Daomtthuan
 */
@Named(value = "config")
@ApplicationScoped
public class ConfigManagedBean {

  private final String layout;
  private final String component;
  private final String vendor;

  /**
   * Creates Config ManagedBean
   */
  public ConfigManagedBean() {
    this.layout = "/WEB-INF/layout";
    this.component = "/WEB-INF/component";
    this.vendor = "/vendor";
  }

  public String getLayout() {
    return layout;
  }

  public String getComponent() {
    return component;
  }

  public String getVendor() {
    return vendor;
  }

}

