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
    final public void accelerate() {
        currentSpeed = speedComputer.computeNewSpeed(currentSpeed);
    }

    // Update the odometer
    final public void move() throws HackingException {
        odometer.increase(currentSpeed);
    }

    // Speed might change when you turn.
    // Because this is not marked final, subclasses *may* -- but are not required to -- override this method.
    final public void turn() {
        currentSpeed = speedComputer.computerTurningSpeed(currentSpeed);
    }

    final public float getDistanceTravelled() {
        return odometer.getCurrentMileage();
    }

    final public void setPosition(final int position) {
        this.position = position;
    }
}
