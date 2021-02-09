package gewirtz.scrabble;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DictionaryTest {


    @Test
    public void isInDictionary()
    {
        //given
        Dictionary dictionary = new Dictionary();
        dictionary.createWordList("dictionary.txt");


        //when
        boolean wordTest = dictionary.isInDictionary("word");

        //then
        Assert.assertTrue(wordTest);

        //when
        wordTest = dictionary.isInDictionary("dergtw");

        //then
        Assert.assertFalse(wordTest);
    }
}
