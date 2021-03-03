package gewirtz.scrabble;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {


    @Test
    public void testInvalidWord()
    {
        //given
        Dictionary dictionary = new Dictionary("dictionary.txt");

        //when
        boolean wordTest = dictionary.isInDictionary("dergtw");

        //then
        Assert.assertFalse(wordTest);
    }


    @Test
    public void testValidWord() {
        //given
        Dictionary dictionary = new Dictionary("dictionary.txt");

        //when
        boolean wordTest = dictionary.isInDictionary("wording");

        //then
        Assert.assertTrue(wordTest);
    }

    @Test
    public void testValidDefinition()
    {
        //given
        Dictionary dictionary = new Dictionary("dictionary.txt");

        //when
        String definitionTest = dictionary.getDefinition("liability");

        //then
        Assert.assertEquals("", definitionTest);
    }

    @Test
    public void testInvalidDefinition()
    {
        //given
        Dictionary dictionary = new Dictionary("dictionary.txt");

        //when
        String definitionTest = dictionary.getDefinition("skjhgfrd");

        //then
        Assert.assertEquals("", definitionTest);
    }
}