public class RaceCar implements Contestant {
    final public String name;
    final private SpeedComputer speedComputer;
    final private Odometer odometer;
    private float currentSpeed;
    private int position;

    final private boolean hasSunRoof;

    public RaceCar(final String name, final SpeedComputer speedComputer, final boolean hasSunRoof) {
        this.name = name;
        this.speedComputer = speedComputer;
        this.currentSpeed = 0;
        this.odometer = new Odometer();
        this.hasSunRoof = hasSunRoof;
    }

    // Update the speed according to the logic of your speedComputer
    public void accelerate() {
        currentSpeed = speedComputer.computeNewSpeed(currentSpeed);
    }

    // Update the odometer
    public void move() {
        odometer.increase(currentSpeed);
    }

    // Speed might change when you turn.
    public void turn() {
        currentSpeed = speedComputer.computerTurningSpeed(currentSpeed);
    }

    //output current car info
    @Override
    public String toString() {
        return name + " is moving at " + currentSpeed + " feet per second and has travelled " +
                getDistanceTravelled() + " feet.";
    }

    //output car's current position in the race
    public void outputPosition() {
        System.out.println(name + " is currently in position " + position + ".");
    }

    @Override
    public float getStyleCreditDistance() {
        // Racecars with a sunroof get 100ft bonus because of the extra weight of a sunroof.
        if (hasSunRoof) {
            return 100;
        } else {
            return 0;
        }
    }

    public float getDistanceTravelled() {
        return odometer.getCurrentMileage();
    }

    public void setPosition(final int position) {
        this.position = position;
    }
}
