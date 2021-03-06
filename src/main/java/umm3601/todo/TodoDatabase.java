package umm3601.todo;

import com.google.gson.Gson;
import umm3601.todo.Todo;
import umm3601.user.User;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class TodoDatabase {

  private Todo[] allTodos;

  public TodoDatabase(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = Arrays.copyOf(allTodos, allTodos.length);
    // Filter by query parameters
    if (queryParams.containsKey("owner")) {
      String targetOwner = queryParams.get("owner")[0];
      filteredTodos = filterTodosByOwner(filteredTodos, targetOwner);
    }
    if (queryParams.containsKey("category")) {
      String targetCategory = queryParams.get("category")[0];
      filteredTodos = filterTodosByCategory(filteredTodos, targetCategory);
    }
    if (queryParams.containsKey("status")) {
      String targetStatusString = queryParams.get("status")[0];
      Boolean targetStatus;
      if(targetStatusString.equals("complete")){
        targetStatus = Boolean.TRUE;
      }else{
        targetStatus = Boolean.FALSE;
      }
      filteredTodos = filter(filteredTodos, targetStatus);
    }

    if (queryParams.containsKey("contains")) {
      String targetBody = queryParams.get("contains")[0];
      filteredTodos = filterTodosByBody(filteredTodos, targetBody);
    }

    //Sort Results
    if (queryParams.containsKey("orderBy")){
      String orderBy = queryParams.get("orderBy")[0];
      switch (orderBy){
        case "owner":
          filteredTodos = sortTodosByOwner(filteredTodos);
          break;

        case "body":
          filteredTodos = sortTodosByBody(filteredTodos);
          break;

        case "status":
          filteredTodos = sortTodosByStatus(filteredTodos);
          break;

        case "category":
          filteredTodos = sortTodosByCategory(filteredTodos);
          break;

      }
    }

    //Limit number of results
    if (queryParams.containsKey("limit")) {
      try {
        int limit = Integer.parseInt(queryParams.get("limit")[0]);
        if (filteredTodos.length > limit) {
          filteredTodos = Arrays.copyOfRange(filteredTodos, 0, limit);
        }
      }catch(NumberFormatException e){
        //do nothing here I just need a catch block with non-empty body
      }
    }
    return filteredTodos;
  }


  private Todo[] filterTodosByOwner(Todo[] todos, String targetOwner) {
    return Arrays.stream(todos).filter(x -> x.owner.equals(targetOwner)).toArray(Todo[]::new);
  }
  private Todo[] filterTodosByBody(Todo[] todos, String targetString) {
    return Arrays.stream(todos).filter(x -> x.body.contains(targetString)).toArray(Todo[]::new);
  }
  private Todo[] filterTodosByCategory(Todo[] todos, String targetCategory) {
    return Arrays.stream(todos).filter(x -> x.category.equals(targetCategory)).toArray(Todo[]::new);
  }
  private Todo[] filter(Todo[] todos, Boolean target) {
    return Arrays.stream(todos).filter(x -> x.status == target).toArray(Todo[]::new);
  }
  private Todo[] sortTodosByOwner(Todo[] todos){
    Arrays.sort(todos, new TodoOwnerComparator());
    return todos;
  }
  private Todo[] sortTodosByBody(Todo[] todos){
    Arrays.sort(todos, new TodoBodyComparator());
    return todos;
  }
  private Todo[] sortTodosByCategory(Todo[] todos){
    Arrays.sort(todos, new TodoCategoryComparator());
    return todos;
  }
  private Todo[] sortTodosByStatus(Todo[] todos){
    Arrays.sort(todos, new TodoStatusComparator());
    return todos;
  }


}

