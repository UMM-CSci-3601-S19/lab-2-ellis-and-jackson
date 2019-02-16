package umm3601.todo;

import org.junit.Before;
import org.junit.Test;
import umm3601.todo.TodoDatabase;
import umm3601.todo.Todo;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Tests umm3601.todos.TodoDatabase listUser functionality
 */
public class FullTodoList {
  private Todo[] allTodos;

  @Before
  public void todoSetup() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    allTodos = db.listTodos(new HashMap<>());
  }
  @Test
  public void totalTodoCount() {
    assertEquals("Incorrect total number of users", 300, allTodos.length);
  }

  @Test
  public void firstTodo() {
    Todo first = allTodos[0];
    assertEquals("Incorrect id", "58895985a22c04e761776d54", first._id);
    assertEquals("Incorrect status", false, first.status);
    assertEquals("Incorrect body", "In sunt ex non tempor cillum commodo amet incididunt anim qui commodo quis. Cillum non labore ex sint esse.", first.body);
    assertEquals("Incorrect category", "software design", first.category);
  }
}
