package umm3601.todo;

import java.util.Comparator;

public class TodoBodyComparator implements Comparator<Todo> {
  public int compare(Todo t1, Todo t2){
    if(t2.body == null || t1.body == null){
      return 0;
    }
    return t1.body.compareTo(t2.body);
  }
}
