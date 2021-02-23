package gewirtz.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

    private final ArrayList<String> dictionary = new ArrayList<String>();

    public Dictionary(String filepath)
    {
        try{
            Scanner readDictionary = new Scanner(new File(filepath));
            while(readDictionary.hasNextLine())
            {
                String line = readDictionary.nextLine();
                String validWord;
                if(!line.contains(" "))
                {
                    validWord = line;
                }
                else
                {
                    validWord = line.substring(0,line.indexOf(" "));
                }

                dictionary.add(validWord.toUpperCase());
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }



    /**
     *
     * @param word to search for
     * @return boolean value if word is in dictionary
     */
    public boolean isInDictionary(String word)
    {
        return dictionary.contains(word.toUpperCase());
    }


}
