package umm3601.todo;

import java.util.Comparator;

public class TodoOwnerComparator implements Comparator<Todo> {
  public int compare(Todo t1, Todo t2){
    if(t2.owner == null || t1.owner == null){
      return 0;
    }
    return t1.owner.compareTo(t2.owner);
  }
}
