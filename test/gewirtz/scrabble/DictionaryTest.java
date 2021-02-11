package gewirtz.scrabble;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {


    @Test
    public void isInDictionary()
    {
        //given
        Dictionary dictionary = new Dictionary();
        dictionary.createWordList("C:\\Users\\elian\\IdeaProjects\\Gewirtz-mcon152-2021\\src\\gewirtz\\scrabble\\dictionary.txt");


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
