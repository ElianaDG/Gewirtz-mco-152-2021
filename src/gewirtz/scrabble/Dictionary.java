package gewirtz.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

    public static ArrayList<String> DICTIONARY = new ArrayList<String>();

    public Dictionary()
    {

    }

    /**
     * @param filepath
     * creates an ArrayList of the words in the dictionary file
     */
    public void createWordList(String filepath)
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

                DICTIONARY.add(validWord.toUpperCase());
            }
        } catch (FileNotFoundException exception) {
            exception.getMessage();
        }
    }

    /**
     *
     * @param word to search for
     * @return boolean value if word is in dictionary
     */
    public boolean isInDictionary(String word)
    {
        boolean inDictionary = false;
        if (DICTIONARY.contains(word.toUpperCase()))
        {
            inDictionary = true;
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
        return inDictionary;
    }


}