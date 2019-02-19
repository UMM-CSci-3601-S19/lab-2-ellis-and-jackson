package umm3601.todo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SortTodos {
  private TodoDatabase db;
  private Map<String, String[]> queryParams;

  @Before
  public void setup() throws IOException {
    db = new TodoDatabase("src/main/data/todos.json");
    queryParams = new HashMap<>();
  }
  @Test
  public void testOrderByOwner() {
    queryParams.put("orderBy", new String[]{"owner"});
    Todo[] todos= db.listTodos(queryParams);
    assertEquals("Incorrect id for first todo sorted by owner", "588959856f0b82ee93cd93eb", todos[0]._id);
    assertEquals("Incorrect owner for first todo sorted by owner", "Barry", todos[0].owner);
    assertEquals("Incorrect status for first todo sorted by owner", true, todos[0].status);
    assertEquals("Incorrect body for first todo sorted by owner", "Nisi sit non non sunt veniam pariatur. Elit reprehenderit aliqua consectetur est dolor officia et adipisicing elit officia nisi elit enim nisi.", todos[0].body);
    assertEquals("Incorrect category for first todo sorted by owner", "video games", todos[0].category);
  }
  @Test
  public void testOrderByCategory() {
    queryParams.put("orderBy", new String[]{"category"});
    Todo[] todos= db.listTodos(queryParams);
    assertEquals("Incorrect id for first todo sorted by category", "5889598555fbbad472586a56", todos[0]._id);
    assertEquals("Incorrect owner for first todo sorted by category", "Blanche", todos[0].owner);
    assertEquals("Incorrect status for first todo sorted by category", true, todos[0].status);
    assertEquals("Incorrect body for first todo sorted by category", "Aliqua esse aliqua veniam id nisi ea. Ullamco Lorem ex aliqua aliquip cupidatat incididunt reprehenderit voluptate ad nisi elit dolore laboris.", todos[0].body);
    assertEquals("Incorrect category for first todo sorted by category", "groceries", todos[0].category);
  }
  @Test
  public void testOrderByStatus() {
    queryParams.put("orderBy", new String[]{"status"});
    Todo[] todos= db.listTodos(queryParams);
    assertEquals("Incorrect id for first todo sorted by status", "58895985a22c04e761776d54", todos[0]._id);
    assertEquals("Incorrect owner for first todo sorted by status", "Blanche", todos[0].owner);
    assertEquals("Incorrect status for first todo sorted by status", false, todos[0].status);
    assertEquals("Incorrect body for first todo sorted by status", "In sunt ex non tempor cillum commodo amet incididunt anim qui commodo quis. Cillum non labore ex sint esse.", todos[0].body);
    assertEquals("Incorrect category for first todo sorted by status", "software design", todos[0].category);
  }
  @Test
  public void testOrderByBody() {
    queryParams.put("orderBy", new String[]{"body"});
    Todo[] todos= db.listTodos(queryParams);
    assertEquals("Incorrect id for first todo sorted by body", "58895985ffd38481b57cac97", todos[0]._id);
    assertEquals("Incorrect owner for first todo sorted by body", "Roberta", todos[0].owner);
    assertEquals("Incorrect status for first todo sorted by body", false, todos[0].status);
    assertEquals("Incorrect body for first todo sorted by body", "Ad sint incididunt officia veniam incididunt. Voluptate exercitation eu aliqua laboris occaecat deserunt cupidatat velit nisi sunt mollit sint amet.", todos[0].body);
    assertEquals("Incorrect category for first todo sorted by body", "software design", todos[0].category);
  }
}
