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

    private final Dictionary dictionary;

    public PathServlet() {
        dictionary = new Dictionary("dictionary.txt");
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        PrintWriter out = response.getWriter();
        String output;

        if(dictionary.isInDictionary(request.getParameter("word"))){
            output = dictionary.getDefinition(request.getParameter("word"));
        } else {
            output = "Invalid word.";
        }
        out.println(output);
    }
}
