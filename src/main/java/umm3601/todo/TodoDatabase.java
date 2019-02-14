package umm3601.todo;

import com.google.gson.Gson;
import umm3601.todo.Todo;
import umm3601.user.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class TodoDatabase {
  private Todo[] allTodos;

  public TodoDatabase(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;
    return filteredTodos;
  }
}
