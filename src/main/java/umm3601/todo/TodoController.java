package umm3601.todo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import static umm3601.Util.buildSuccessJsonResponse;

public class TodoController {
  Gson gson = new Gson();
  private TodoDatabase todoDatabase;
  public JsonObject getTodos(Request req, Response res){
    res.type("application/json");
    Todo[] todos = todoDatabase.listTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("todos", gson.toJsonTree(todos));
  }

  public TodoController(TodoDatabase todoDatabase){
    gson = new Gson();
    this.todoDatabase = todoDatabase;
  }
}
