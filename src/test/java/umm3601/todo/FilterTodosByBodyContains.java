package umm3601.todo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FilterTodosByBodyContains {
  private TodoDatabase db;
  private Map<String, String[]> queryParams;

  @Before
  public void setup() throws IOException {
    db = new TodoDatabase("src/main/data/todos.json");
    queryParams = new HashMap<>();
  }

  @Test
  public void testBodyLength() {
    queryParams.put("body", new String[]{"labore"});
    Todo[] todos = db.listTodos(queryParams);
    assertEquals("Incorrect number todos with body labore", 60, todos.length);
  }
  @Test
  public void testCategoryFirstHomework() {
    queryParams.put("body", new String[]{"labore"});
    Todo[] todos= db.listTodos(queryParams);
    assertEquals("Incorrect id for first body todo", "58895985a22c04e761776d54", todos[0]._id);
    assertEquals("Incorrect owner for first body todo", "Blanche", todos[0].owner);
    assertEquals("Incorrect status for first body todo", false, todos[0].status);
    assertEquals("Incorrect body for first body todo", "In sunt ex non tempor cillum commodo amet incididunt anim qui commodo quis. Cillum non labore ex sint esse.", todos[0].body);
    assertEquals("Incorrect category for first body todo", "software design", todos[0].category);
  }
}
