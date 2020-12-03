package managedbean;

import enity.Product;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Daomtthuan
 */
@Named(value = "productManagedBean")
@RequestScoped
public class ProductManagedBean {

  public List<Product> getProducts() {
    return 
  }

}

