package gewirtz.scrabble;

import gewirtz.scrabble.webapp.PathServlet;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class PathServletTest {

    @Test
    public void doGet() throws IOException {
        //given
        PathServlet servlet = new PathServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        doReturn(out).when(response).getWriter();
        doReturn("word").when(request).getParameter("word");

        //when
        servlet.doGet(request, response);

        //then
        verify(out).println(anyString());
    }
}