package gewirtz.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

public class ScrabbleController {


    private int points = 0;

    @FXML
    List<Label> answerLabels;

    @FXML
    List<Label> letterLabels;

    @FXML
    Label invalidWord, pointsLabel;

    private LetterBag letterBag = new LetterBag();

    private Dictionary dictionary;

    public ScrabbleController() {
        dictionary = new Dictionary("dictionary.txt");
    }

    @FXML
    public void initialize(){
        for(Label label : letterLabels){
            label.setText(letterBag.nextLetter());
        }
    }


    public void onAnswerClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();

        //label.setText("");
    }

    public void onClear(ActionEvent actionEvent) {
        returnTiles();
    }

    private void returnTiles() {
        for(Label answer : answerLabels) {
            for( Label letter : letterLabels){
                if(letter.getText().equals("")){
                    letter.setText(answer.getText());
                    break;
                }
            }
            answer.setText("");
        }
    }

    private void clearTiles() {
        for(Label answer : answerLabels) {
            answer.setText("");
        }
    }

    public void onSubmit(ActionEvent actionEvent) {
        String word = "";
        for(Label answer : answerLabels) {
            word += answer.getText();
        }

        if(dictionary.isInDictionary(word)){
            calculatePoints(word);
            clearTiles();
            pointsLabel.setText(String.valueOf(points));
            for(Label letter : letterLabels){
                if(letter.getText() == ""){
                    letter.setText(letterBag.nextLetter());
                }
            }
        }
        else{
            returnTiles();
            invalidWord.setText("invalid word");
        }
    }

    private void calculatePoints(String word) {

        if(word.length() == 2){
            points += 1;
        } else if(word.length() == 3){
            points += 3;
        }else if(word.length() == 4){
            points += 5;
        }else if(word.length() == 5){
            points += 7;
        }else if(word.length() == 6){
            points += 11;
        }else if(word.length() == 7){
            points += 13;
        }else{
            points += 0;
        }
    }

    public void onLetterClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        String letter = label.getText();
        for(Label answer : answerLabels){
            if(answer.getText().equals("")){
                answer.setText(letter);
                break;
            }
        }
        label.setText("");
    }
}
