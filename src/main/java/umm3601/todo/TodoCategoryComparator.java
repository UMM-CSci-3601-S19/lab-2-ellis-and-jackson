package umm3601.todo;

import java.util.Comparator;

public class TodoCategoryComparator implements Comparator<Todo> {
  public int compare(Todo t1, Todo t2){
    if(t2.category == null || t1.category == null){
      return 0;
    }
    return t1.category.compareTo(t2.category);
  }
}
