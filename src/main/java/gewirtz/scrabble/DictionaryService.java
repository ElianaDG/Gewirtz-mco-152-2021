package gewirtz.scrabble;

import java.io.*;
import java.util.Scanner;

public class DictionaryService {

    public Dictionary dictionary() throws IOException {

        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        Scanner scanner = new Scanner(new InputStreamReader(in));

        return new Dictionary(scanner);
    }
}
