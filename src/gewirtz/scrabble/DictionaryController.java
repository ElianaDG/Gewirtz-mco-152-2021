package gewirtz.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DictionaryController {

    @FXML
    TextField searchField;

    @FXML
    Label resultLabel;

    public void searchDictionary(ActionEvent actionEvent)
    {
        String word = searchField.getText();

        Dictionary dictionary = new Dictionary();
        dictionary.createWordList("C:\\Users\\elian\\IdeaProjects\\Gewirtz-mcon152-2021\\src\\gewirtz\\scrabble\\dictionary.txt");
        boolean result = dictionary.isInDictionary(word);
        if(result)
        {
            resultLabel.setText("valid word");
        }
        else
        {
            resultLabel.setText("invalid word");
        }

    }
}
