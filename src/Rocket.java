public class Rocket {

    final double GRAVITY = 9.8;
    private final double velocity;
    private final double angle;

    public Rocket(double velocity, double angle) {
        this.velocity = velocity;
        this.angle = angle;
    }

    /**
     *
     * @param time in seconds
     * @return the x location of the rocket at the specified time
     */
    public double getX(double time) {
        double xVelocity = Math.cos(Math.toRadians(angle)) * velocity;
        double x = xVelocity * time;
        return x;
    }

    /**
     *
     * @param time
     * @return the y location of the rocket at the specified time
     */
    public double getY(double time) {
        double yVelocity = Math.sin(Math.toRadians(angle)) * velocity;
        double y = (yVelocity * time) - (0.5 * GRAVITY * time * time);
        return y;
    }
//change
    /**
     *
     * @return the time in seconds that the rocket lands
     */
    public double getTimeToLand(){
        double yVelocity = Math.sin(Math.toRadians(angle)) * velocity;
        double timeToLand = 2 * yVelocity / GRAVITY;
        return timeToLand;
    }

}
