package gewirtz.scrabble;

import gewirtz.scrabble.webapp.DictionaryServlet;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class DictionaryServletTest {

    @Test
    public void doGet() throws IOException {
        //given
        DictionaryServlet servlet = new DictionaryServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        String expected = "one [adj]";

        doReturn(out).when(response).getWriter();
        doReturn("AE").when(request).getParameter("word");

        //when
        servlet.doGet(request, response);

        //then
        verify(out).println(expected);
    }
}
