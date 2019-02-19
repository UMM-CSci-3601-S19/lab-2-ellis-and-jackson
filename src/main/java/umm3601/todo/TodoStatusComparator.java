package umm3601.todo;

import java.util.Comparator;

public class TodoStatusComparator implements Comparator<Todo> {
  public int compare(Todo t1, Todo t2){
    if(t2.status == null || t1.status == null){
      return 0;
    }
    return t1.status.compareTo(t2.status);
  }
}
