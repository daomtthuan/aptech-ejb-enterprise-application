

package facade;

import enity.Category;
import java.util.List;
import javax.ejb.Local;

/**
 * <code>CategoryFacadeLocal</code>
 * @author Daomtthuan
 */
@Local
public interface CategoryFacadeLocal {

  void create(Category category);

  void edit(Category category);

  void remove(Category category);

  Category find(Object id);

  List<Category> findAll();

  List<Category> findRange(int[] range);

  int count();

}
