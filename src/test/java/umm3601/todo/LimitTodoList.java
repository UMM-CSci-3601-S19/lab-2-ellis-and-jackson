package umm3601.todo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LimitTodoList {
  private TodoDatabase db;
  private Map<String, String[]> queryParams;
  private Todo[] todos;

  @Before
  public void setup() throws IOException {
    db = new TodoDatabase("src/main/data/todos.json");
    queryParams = new HashMap<>();
    queryParams.put("limit", new String[]{"7"});
    todos = db.listTodos(queryParams);
  }

  @Test
  public void testLimitLength() {
    assertEquals("Incorrect number todos when limiting response size", 7, todos.length);
  }
  @Test
  public void testLimitIncorrectInput() {
    queryParams.put("limit", new String[]{"hi"});
    todos = db.listTodos(queryParams);
    assertEquals("Incorrect input not handled for limit - incorrect number of todos", 300, todos.length);
  }
  @Test
  public void testLimitFirst() {
    assertEquals("Incorrect id for first todo when limited", "58895985a22c04e761776d54", todos[0]._id);
    assertEquals("Incorrect owner for first todo when limited", "Blanche", todos[0].owner);
    assertEquals("Incorrect status for first todo when limited", false, todos[0].status);
    assertEquals("Incorrect body for first todo when limited", "In sunt ex non tempor cillum commodo amet incididunt anim qui commodo quis. Cillum non labore ex sint esse.", todos[0].body);
    assertEquals("Incorrect category for first todo when limited", "software design", todos[0].category);
  }
}
