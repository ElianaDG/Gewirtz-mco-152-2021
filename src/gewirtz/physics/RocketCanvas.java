package gewirtz.physics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineJoin;

/**
 * draws a Rocket to the Canvas
 */

public class RocketCanvas extends Canvas {

    /**
     * draws the path of the Rocket starting from time = 0 to the Rocket's flight time
     * @param rocket
     */
    public void draw(Rocket rocket)
    {
        GraphicsContext context = getGraphicsContext2D();

        context.setFill(Color.VIOLET);
        context.fillRect(0, 0, getWidth(), getHeight());

        context.translate(0, getHeight());

        context.setFill(Color.BLUE);

        for(double time = 0; time < rocket.getTimeToLand(); time += 0.5)
        {
            double x = rocket.getX(time);
            double y = rocket.getY(time);
            context.fillOval(x, -y, 10, 10);
            context.lineTo(x, -y);
            context.stroke();
        }

        context.translate(0, -getHeight());
    }

}
