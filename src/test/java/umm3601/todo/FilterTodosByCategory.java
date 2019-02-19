package umm3601.todo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FilterTodosByCategory {
  private TodoDatabase db;
  private Map<String, String[]> queryParams;

  @Before
  public void setup() throws IOException {
    db = new TodoDatabase("src/main/data/todos.json");
    queryParams = new HashMap<>();
  }

  @Test
  public void testCategoryLengthSoftwareDesign() {
    queryParams.put("category", new String[]{"software design"});
    Todo[] todos = db.listTodos(queryParams);
    assertEquals("Incorrect number todos with category software design", 74, todos.length);
  }
  @Test
  public void testCategoryLengthHomework() {
    queryParams.put("category", new String[]{"homework"});
    Todo[] todos = db.listTodos(queryParams);
    assertEquals("Incorrect number todos with category homework", 79, todos.length);
  }

  @Test
  public void testCategoryFirstHomework() {
    queryParams.put("category", new String[]{"homework"});
    Todo[] todos= db.listTodos(queryParams);
    assertEquals("Incorrect id for first homework todo", "58895985ae3b752b124e7663", todos[0]._id);
    assertEquals("Incorrect owner for first homework todo", "Fry", todos[0].owner);
    assertEquals("Incorrect status for first homework todo", true, todos[0].status);
    assertEquals("Incorrect body for first homework todo", "Ullamco irure laborum magna dolor non. Anim occaecat adipisicing cillum eu magna in.", todos[0].body);
    assertEquals("Incorrect category for first homework todo", "homework", todos[0].category);
  }
}
