abstract public class GenericRacer implements Contestant {
    final public String name;
    final private SpeedComputer speedComputer;
    final private Odometer odometer;
    protected float currentSpeed;
    protected int position;

    public GenericRacer(final String name, final SpeedComputer speedComputer) {
        this.name = name;
        this.speedComputer = speedComputer;
        this.currentSpeed = 0;
        this.odometer = new Odometer();
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

    public float getDistanceTravelled() {
        return odometer.getCurrentMileage();
    }

    public void setPosition(final int position) {
        this.position = position;
    }
}
