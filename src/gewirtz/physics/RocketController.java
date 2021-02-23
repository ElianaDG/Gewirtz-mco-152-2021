package gewirtz.physics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RocketController {

    public RocketCanvas rocketCanvas;
    @FXML
    TextField velocityField;

    @FXML
    TextField angleField;

    @FXML
    TextField secondsField;

    @FXML
    Label locationLabel;


    @FXML
    Label flightTimeLabel;

    public void calculateRocket(ActionEvent actionEvent) {

        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());

        Rocket rocket = new Rocket(velocity, angle);

        String location = String.format("%.2f, %.2f",
                rocket.getX(seconds),
                rocket.getY(seconds));

        locationLabel.setText("Location: " + location);

        String flightTime = String.format("%.2f", rocket.getTimeToLand());
        flightTimeLabel.setText("Flight Time: " + flightTime);

        rocketCanvas.draw(rocket);


    }
}
