package gewirtz.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    private final Map<String, String> wordsToDefinitions = new HashMap<>();

    public Dictionary(String filepath)
    {
        try{
            Scanner readDictionary = new Scanner(new File(filepath));
            while(readDictionary.hasNext())
            {
                wordsToDefinitions.put(
                        readDictionary.next(),
                        readDictionary.nextLine().trim()
                );
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    /**
     *
     * @param word that is to be defined
     * @return String value of the word definition
     */
    public String getDefinition(String word)
    {
        String definition = wordsToDefinitions.get(word.toUpperCase());
        return definition == null ? "" : definition;
    }


    /**
     *
     * @param word to search for
     * @return boolean value if word is in dictionary
     */
    public boolean isInDictionary(String word)
    {
        return wordsToDefinitions.containsKey(word.toUpperCase());
    }


}
