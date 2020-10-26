package managedbean;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

@Named(value = "config")
@ApplicationScoped
public class ConfigManagedbean {

  private final String layouts;
  private final String components;
  private final String vendors;

  public ConfigManagedbean() {
    this.layouts = "/WEB-INF/layouts";
    this.components = "/WEB-INF/components";
    this.vendors = "/vendors";
  }

  public String getLayouts() {
    return layouts;
  }

  public String getComponents() {
    return components;
  }

  public String getVendors() {
    return vendors;
  }

}

