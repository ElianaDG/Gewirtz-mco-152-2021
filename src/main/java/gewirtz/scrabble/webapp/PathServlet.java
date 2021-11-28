package gewirtz.scrabble.webapp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gewirtz.scrabble.Dictionary;

import java.io.IOException;
import java.io.PrintWriter;

public class PathServlet extends HttpServlet {

    private final Gson gson;
    private final Dictionary dictionary;

    public PathServlet() throws IOException {
        gson = new GsonBuilder().setPrettyPrinting().create();
        dictionary = new Dictionary("dictionary.txt");
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        PrintWriter out = response.getWriter();
        String json;

        if(dictionary.isInDictionary(request.getParameter("word"))){
            String definition = dictionary.getDefinition(request.getParameter("word"));
            json = gson.toJson(definition);
        } else {
            json = gson.toJson("Invalid word.");
        }
        out.println(json);
    }
}
