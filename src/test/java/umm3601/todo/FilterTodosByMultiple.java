package umm3601.todo;

import org.junit.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FilterTodosByMultiple {
  private TodoDatabase db;
  private Map<String, String[]> queryParams;

  @Before
  public void setup() throws IOException {
    db = new TodoDatabase("src/main/data/todos.json");
    queryParams = new HashMap<>();
  }

  @Test
  public void testMultiple() {
    queryParams.put("owner", new String[]{"Dawn"});
    queryParams.put("category", new String[]{"video games"});
    queryParams.put("contains", new String[]{"in"});
    queryParams.put("status", new String[]{"complete"});
    queryParams.put("limit", new String[]{"5"});
    queryParams.put("orderBy", new String[]{"body"});
    Todo[] todos = db.listTodos(queryParams);
    assertEquals("Incorrect id for first complete todo", "58895985f3b7862d7e2f0079", todos[0]._id);
    assertEquals("Incorrect owner for first complete todo", "Dawn", todos[0].owner);
    assertEquals("Incorrect status for first complete todo", true, todos[0].status);
    assertEquals("Incorrect body for first complete todo", "Cupidatat ex Lorem aute laboris mollit minim minim velit laborum ad culpa consectetur enim ut. Pariatur ad elit in est aliqua.", todos[0].body);
    assertEquals("Incorrect category for first complete todo", "video games", todos[0].category);
  }
}
