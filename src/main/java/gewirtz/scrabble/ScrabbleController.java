package gewirtz.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ScrabbleController {

    private int points = 0;
    //private ArrayList<String> tiles = ["A"];

    @FXML
    Label tileOne, tileTwo, tileThree, tileFour, tileFive, tileSix, tileSeven,
            letterOne, letterTwo, letterThree, letterFour, letterFive, letterSix,
            letterSeven, invalidWord, numberOfPoints;

    public void clearTiles(ActionEvent actionEvent) {
        letterOne.setText("");
        letterTwo.setText("");
        letterThree.setText("");
        letterFour.setText("");
        letterFive.setText("");
        letterSix.setText("");
        letterSeven.setText("");
    }

    public void submitWord(ActionEvent actionEvent) {

        String word = letterOne.getText() + letterTwo.getText() + letterThree.getText()
                + letterFour.getText() + letterFive.getText() + letterSix.getText() + letterSeven.getText();

        Dictionary dictionary = new Dictionary("dictionary.txt");

        if(dictionary.isInDictionary(word) && word.length() > 1)
        {
            if(word.length() == 2)
            {
                points += 1;
            }
            else if(word.length() == 3)
            {
                points += 3;
            }
            else if(word.length() == 4)
            {
                points += 5;
            }
            else if(word.length() == 5)
            {
                points += 7;
            }
            else if(word.length() == 6)
            {
                points += 11;
            }
            else if(word.length() == 7)
            {
                points += 13;
            }
        }
        else
        {
            invalidWord.setText("Invalid Word");
        }
    }

    public void calculatePoints(ActionEvent actionEvent) {

        numberOfPoints.setText("Points: " + points);

    }

    public void startNewGame(ActionEvent actionEvent) {
        points = 0;
        //remove a letter at random from the list and assign it to a tile
        //how and where in the code do u click on the tile labels to add them to the word?

    }
}
