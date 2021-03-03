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

}