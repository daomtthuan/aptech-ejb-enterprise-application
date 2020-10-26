package managedbean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "error")
@RequestScoped
public class ErrorManagedBean {

  private Integer code;
  private String message;

  public ErrorManagedBean() {
    this.code = null;
    this.message = null;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}

