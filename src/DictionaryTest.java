import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DictionaryTest {


    @Test
    public void isInDictionary()
    {
        //given
        Dictionary.createWordList("dictionary.txt");


        //when
        boolean wordTest = Dictionary.isInDictionary("word");

        //then
        Assert.assertTrue(wordTest);

        //when
        wordTest = Dictionary.isInDictionary("dergtw");

        //then
        Assert.assertFalse(wordTest);
    }
}
