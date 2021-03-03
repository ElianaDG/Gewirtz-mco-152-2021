package gewirtz.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

    private final ArrayList<String> dictionary = new ArrayList<String>();
    private final ArrayList<String> definitions = new ArrayList<String>();

    public Dictionary(String filepath)
    {
        try{
            Scanner readDictionary = new Scanner(new File(filepath));
            while(readDictionary.hasNextLine())
            {
                String line = readDictionary.nextLine();
                if(!line.contains(" "))
                {
                    dictionary.add(line);
                    definitions.add("");
                }
                else
                {
                    dictionary.add(line.substring(0,line.indexOf(" ")));
                    definitions.add(line.substring(line.indexOf(" ") + 1));
                }

            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public String getDefinition(String word)
    {
        if(!dictionary.contains(word.toUpperCase()))
        {
            return "";
        }
        else {
            return definitions.get(dictionary.indexOf(word.toUpperCase()));
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
