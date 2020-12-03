

package facade;

import enity.Product;
import java.util.List;
import javax.ejb.Local;

/**
 * <code>ProductFacadeLocal</code>
 * @author Daomtthuan
 */
@Local
public interface ProductFacadeLocal {

  void create(Product product);

  void edit(Product product);

  void remove(Product product);

  Product find(Object id);

  List<Product> findAll();

  List<Product> findRange(int[] range);

  int count();

}
