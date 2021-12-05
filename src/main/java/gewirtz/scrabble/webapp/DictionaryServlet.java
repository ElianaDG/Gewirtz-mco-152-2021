package gewirtz.scrabble.webapp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gewirtz.scrabble.Dictionary;
import gewirtz.scrabble.DictionaryService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class DictionaryServlet extends HttpServlet {

    private final Map<String, String> dictionary;
    private final DictionaryService service;

    public DictionaryServlet() throws IOException {
        service = new DictionaryService();
        dictionary = service.dictionary();
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        PrintWriter out = response.getWriter();
        String output;

        output = dictionary.getOrDefault(request.getParameter("word"), "Invalid word.");
        out.println(output);
    }
}
