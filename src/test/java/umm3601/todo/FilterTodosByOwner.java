package umm3601.todo;

import org.junit.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class FilterTodosByOwner {
  private TodoDatabase db;
  private Map<String, String[]> queryParams;

  @Before
  public void setup() throws IOException {
    db = new TodoDatabase("src/main/data/todos.json");
    queryParams = new HashMap<>();
  }

  @Test
  public void testOwnerLengthFry() {
    queryParams.put("owner", new String[]{"Fry"});
    Todo[] todosFry = db.listTodos(queryParams);
    assertEquals("Incorrect number todos owned by Fry", 61, todosFry.length);
  }
  @Test
  public void testOwnerLengthBlanche() {
    queryParams.put("owner", new String[]{"Blanche"});
    Todo[] todosBlanche = db.listTodos(queryParams);
    assertEquals("Incorrect number todos owned by Blanche", 43, todosBlanche.length);
  }
  @Test
  public void testOwnerFirstFry() {
    queryParams.put("owner", new String[]{"Fry"});
    Todo[] todosFry = db.listTodos(queryParams);
    assertEquals("Incorrect id for first todo owned by Fry", "58895985c1849992336c219b", todosFry[0]._id);
    assertEquals("Incorrect owner for first todo owned by Fry", "Fry", todosFry[0].owner);
    assertEquals("Incorrect status for first todo owned by Fry", false, todosFry[0].status);
    assertEquals("Incorrect body for first todo owned by Fry", "Ipsum esse est ullamco magna tempor anim laborum non officia deserunt veniam commodo. Aute minim incididunt ex commodo.", todosFry[0].body);
    assertEquals("Incorrect category for first todo owned by Fry", "video games", todosFry[0].category);
  }
}
