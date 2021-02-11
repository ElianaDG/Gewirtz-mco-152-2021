package gewirtz.physics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RocketController {

    @FXML
    TextField velocityField;

    @FXML
    TextField angleField;

    @FXML
    TextField secondsField;

    @FXML
    Label xLabel;

    @FXML
    Label yLabel;

    @FXML
    Label flightTimeLabel;

    public void calculateRocket(ActionEvent actionEvent) {

        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());

        Rocket rocket = new Rocket(velocity, angle);

        xLabel.setText("X: " + rocket.getX(seconds));
        yLabel.setText("Y: " + rocket.getY(seconds));
        flightTimeLabel.setText("Flight Time: " + rocket.getTimeToLand());


    }
}
