package gewirtz.scrabble;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DictionaryService {

    public Map<String, String> dictionary() throws IOException {

        Map<String, String> dictionary = new HashMap<>();
        try{
            InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String entry;
            while(reader.readLine() != null){
                entry = reader.readLine();
                String word = entry.substring(0, entry.indexOf(" "));
                String definition = entry.substring(entry.indexOf(" ")).trim();
                dictionary.put(word, definition);
            }
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }


        return dictionary;
    }
}
