package gewirtz.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

public class ScrabbleController {


    protected int points = 0;   //make it protected or nothing?

    @FXML
    List<Label> answerLabels;
    @FXML
    List<Label> letterLabels;
    @FXML
    Label invalidWord, pointsLabel;

    private final LetterBag letterBag;

    private final Dictionary dictionary;

    // dependency injection
    //if a class depends on other objects, pass those objects in the constructor
    public ScrabbleController(
            Dictionary dictionary,
            LetterBag letterBag) {
        this.dictionary = dictionary;
        this.letterBag = letterBag;
    }

    @FXML
    public void initialize(){
        for(Label label : letterLabels){
            label.setText(letterBag.nextLetter());
        }
    }


    public void onAnswerClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        for( Label letter : letterLabels){
            if(letter.getText().equals("")){
                letter.setText(label.getText());
                label.setText("");
                break;
            }
        }
    }

    public void onClear(ActionEvent actionEvent) {
        returnTiles();
    }

    /**
     * returns letters from AnswerLabels to any empty letterLabels
     */
    private void returnTiles() {
        for(Label answer : answerLabels) {
            String answerText = answer.getText();
            if(!answerText.isEmpty()) {
                for (Label letter : letterLabels) {
                    if (letter.getText().equals("")) {
                        letter.setText(answer.getText());
                        break;
                    }
                }
            }
            answer.setText("");
        }
    }

    /**
     * sets text of answerLabels to ""
     */
    private void clearTiles() {
        for(Label answer : answerLabels) {
            answer.setText("");
        }
    }

    /**
     * checks dictionary for word made from the answerLabels
     * @param actionEvent
     */
    public void onSubmit(ActionEvent actionEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Label answer : answerLabels) {
            stringBuilder.append(answer.getText());
        }
        String word = stringBuilder.toString();

        if(dictionary.isInDictionary(word)){
            calculatePoints(word);
            clearTiles();
            pointsLabel.setText(String.valueOf(points));
            for(Label letter : letterLabels){
                if("".equals(letter.getText())){
                    letter.setText(letterBag.nextLetter());
                }
            }
        }
        else{
            returnTiles();
            invalidWord.setText("invalid word");
        }
    }

    /**
     * calculates the points value according to the word length
     * @param word created with letters is evaluated for points
     */
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
        }else{
            points += 13;
        }
    }

    /**
     * when a letterLabel is clicked, its letter goes to the first available answerLabel
     * @param mouseEvent
     */
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
