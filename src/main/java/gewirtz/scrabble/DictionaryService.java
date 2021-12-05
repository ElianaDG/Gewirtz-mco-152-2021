package gewirtz.scrabble;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryService {

    public Map<String, String> dictionary() throws IOException {

        Map<String, String> dictionary = new HashMap<>();
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader("dictionary.txt"));
            while(reader.readLine() != null)
            {
                String line = reader.readLine();
                String word = line.substring(0, line.indexOf(" "));
                String definition = line.substring(line.indexOf(" "));
                dictionary.put(word, definition);
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        if(reader != null){
            reader.close();
        }
        return dictionary;
    }
}
