package umm3601.todo;

import org.junit.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class FilterTodosByStatus {
  private TodoDatabase db;
  private Map<String, String[]> queryParams;

  @Before
  public void setup() throws IOException {
    db = new TodoDatabase("src/main/data/todos.json");
    queryParams = new HashMap<>();
  }

  @Test
  public void testStatusLengthComplete() {
    queryParams.put("status", new String[]{"complete"});
    Todo[] todos= db.listTodos(queryParams);
    assertEquals("Incorrect number of complete todos", 143, todos.length);
  }
  @Test
  public void testStatusLengthIncomplete() {
    queryParams.put("status", new String[]{"incomplete"});
    Todo[] todos = db.listTodos(queryParams);
    assertEquals("Incorrect number of incomplete todos", 157, todos.length);
  }
  @Test
  public void testStatusFirstComplete() {
    queryParams.put("status", new String[]{"complete"});
    Todo[] todos= db.listTodos(queryParams);
    assertEquals("Incorrect id for first complete todo", "58895985ae3b752b124e7663", todos[0]._id);
    assertEquals("Incorrect owner for first complete todo", "Fry", todos[0].owner);
    assertEquals("Incorrect status for first complete todo", true, todos[0].status);
    assertEquals("Incorrect body for first complete todo", "Ullamco irure laborum magna dolor non. Anim occaecat adipisicing cillum eu magna in.", todos[0].body);
    assertEquals("Incorrect category for first complete todo", "homework", todos[0].category);
  }
  @Test
  public void testStatusFirstIncomplete() {
    queryParams.put("status", new String[]{"incomplete"});
    Todo[] todos= db.listTodos(queryParams);
    assertEquals("Incorrect id for first incomplete todo", "58895985a22c04e761776d54", todos[0]._id);
    assertEquals("Incorrect owner for first incomplete todo", "Blanche", todos[0].owner);
    assertEquals("Incorrect status for first incomplete todo", false, todos[0].status);
    assertEquals("Incorrect body for first incomplete todo", "In sunt ex non tempor cillum commodo amet incididunt anim qui commodo quis. Cillum non labore ex sint esse.", todos[0].body);
    assertEquals("Incorrect category for first incomplete todo", "software design", todos[0].category);
  }
}
