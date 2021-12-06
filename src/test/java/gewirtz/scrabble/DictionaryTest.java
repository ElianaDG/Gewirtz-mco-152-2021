package gewirtz.scrabble;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class DictionaryTest {


    @Test
    public void testInvalidWord() throws IOException {
        //given
        DictionaryService service = new DictionaryService();
        Dictionary dictionary = service.dictionary();

        //when
        boolean wordTest = dictionary.isInDictionary("dergtw");

        //then
        Assert.assertFalse(wordTest);
    }


    @Test
    public void testValidWord() throws IOException {
        //given
        DictionaryService service = new DictionaryService();
        Dictionary dictionary = service.dictionary();

        //when
        boolean wordTest = dictionary.isInDictionary("wording");

        //then
        Assert.assertTrue(wordTest);
    }

    @Test
    public void testValidDefinition() throws IOException {
        //given
        DictionaryService service = new DictionaryService();
        Dictionary dictionary = service.dictionary();

        //when
        String definitionTest = dictionary.getDefinition("liability");

        //then
        Assert.assertEquals("", definitionTest);
    }

    @Test
    public void testInvalidDefinition() throws IOException {
        //given
        DictionaryService service = new DictionaryService();
        Dictionary dictionary = service.dictionary();

        //when
        String definitionTest = dictionary.getDefinition("skjhgfrd");

        //then
        Assert.assertEquals("", definitionTest);
    }
}