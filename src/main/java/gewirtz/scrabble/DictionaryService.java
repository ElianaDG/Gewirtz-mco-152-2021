package gewirtz.scrabble;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DictionaryService {

    public Dictionary dictionary() throws IOException {

        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        Dictionary dictionary = new Dictionary(reader);

        return dictionary;
    }
}
