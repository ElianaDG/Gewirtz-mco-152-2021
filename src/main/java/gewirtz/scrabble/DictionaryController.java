package gewirtz.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DictionaryController {

    @FXML
    TextField searchField;

    @FXML
    Label resultLabel;

    public void searchDictionary(ActionEvent actionEvent) throws IOException {
        String word = searchField.getText();
        DictionaryService service = new DictionaryService();

        Dictionary dictionary = service.dictionary();
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
