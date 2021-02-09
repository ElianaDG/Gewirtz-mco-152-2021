package gewirtz.scrabble;

public class Main {


    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();
        dictionary.createWordList("dictionary.txt");
        dictionary.isInDictionary("naacp");

    }


}
