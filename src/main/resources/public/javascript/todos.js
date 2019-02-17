// Why do we use the `var getAllUsers = function()` syntax
// for the first definition, and the named function syntax
// for the second definition?

/**
 * Function to get all the users!
 */
function getTodos() {
  var client = new HttpClient();
  var owner = document.getElementById("owner").value;
  var category = document.getElementById("category").value;
  var status = document.getElementById("status").value;
  var limit = document.getElementById("limit").value;
  var keys = ["owner", "category", "status", "limit"];
  var values = [owner, category, status, limit];
  var include = [owner !== "", category !== "", status !== "Either", limit !== ""];
  var url = "/api/todos?";
  for(var i=0; i< keys.length; i++){
    if(include[i]){
      url = url + keys[i] + "=" + values[i] + "&";
    }
  }
  client.get(url, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

/**
 * Wrapper to make generating http requests easier. Should maybe be moved
 * somewhere else in the future!.
 *
 * Based on: http://stackoverflow.com/a/22076667
 * Now with more comments!
 */
function HttpClient() {
  // We'll take a URL string, and a callback function.
  this.get = function (aUrl, aCallback) {
    var anHttpRequest = new XMLHttpRequest();

    // Set a callback to be called when the ready state of our request changes.
    anHttpRequest.onreadystatechange = function () {

      /**
       * Only call our 'aCallback' function if the ready state is 'DONE' and
       * the request status is 200 ('OK')
       *
       * See https://httpstatuses.com/ for HTTP status codes
       * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
       *  for XMLHttpRequest ready state documentation.
       *
       */
      if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
        aCallback(anHttpRequest.responseText);
    };

    anHttpRequest.open("GET", aUrl, true);
    anHttpRequest.send(null);
  }
}
