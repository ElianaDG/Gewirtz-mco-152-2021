package gewirtz.scrabble;

public class Main {


    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();
        dictionary.createWordList("C:\\Users\\elian\\IdeaProjects\\Gewirtz-mcon152-2021\\src\\gewirtz\\scrabble\\dictionary.txt");
        dictionary.isInDictionary("nfl");

    }


}
