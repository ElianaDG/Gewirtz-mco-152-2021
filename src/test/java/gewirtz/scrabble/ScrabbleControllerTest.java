package gewirtz.scrabble;

import javafx.scene.control.Label;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ScrabbleControllerTest {

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public void initialize(){
        //given
        LetterBag letterBag = mock(LetterBag.class);
        Dictionary dictionary = mock(Dictionary.class);
        ScrabbleController controller = new ScrabbleController(dictionary, letterBag);
        controller.letterLabels = new ArrayList<>();
        controller.letterLabels.add(mock(Label.class));
        doReturn("T").when(letterBag).nextLetter();

        //when
        controller.initialize();

        //then
        verify(controller.letterLabels.get(0)).setText("T");
        verify(letterBag).nextLetter();

    }
}
