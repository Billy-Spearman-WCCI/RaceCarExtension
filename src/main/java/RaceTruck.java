public class RaceTruck implements Contestant {
    final private String name;
    final private SpeedComputer speedComputer;
    final private Odometer odometer;

    private float currentSpeed;
    private int position;

    public RaceTruck (final String name, final SpeedComputer speedComputer) {
        this.name = name;
        this.speedComputer = speedComputer;
        this.currentSpeed = 0;
        this.odometer = new Odometer();
    }

    // Update the speed according to the logic of your speedComputer
    public void accelerate() {
        this.currentSpeed = this.speedComputer.computeNewSpeed(this.currentSpeed);
    }

    public void move() {
        odometer.increase(currentSpeed);
    }

    // Turning might change your sepeed
    public void turn() {
        currentSpeed = speedComputer.computerTurningSpeed(currentSpeed);
    }

    //output current car info
    @Override
    public String toString() {
        return name + " is moving at " + currentSpeed + " feet per second and has travelled " +
                getDistanceTravelled() + " feet. And I'm a truck!";
    }

    //output car's current position in the race
    public void outputPosition() {
        System.out.println(name + " is currently in position " + position + ".");
    }

    public float getDistanceTravelled() {
        return odometer.getCurrentMileage();
    }

    public void setPosition(final int position) {
        this.position = position;
    }
}
