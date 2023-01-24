public class RaceTruck implements Contestant {
    final private String name;
    final private SpeedComputer speedComputer;
    final private Odometer distanceTraveled;
    final private float acceleration;

    private float currentSpeed;
    private int position;

    public RaceTruck (final String name, final SpeedComputer speedComputer, final float acceleration) {
        this.name = name;
        this.speedComputer = speedComputer;
        this.acceleration = acceleration;
        this.currentSpeed = 0;
        this.distanceTraveled = new Odometer();
    }

    //Increase current speed by acceleration,
    // if current speed is greater than max speed, set current speed to max speed
    public void accelerate() {
        this.currentSpeed = this.speedComputer.computeNewSpeed(this.currentSpeed, this.acceleration);
    }

    //add current speed to distance travelled
    public void move() {
        distanceTraveled.increase(currentSpeed);
    }

    //cut speed in half
    public void turn() {
        currentSpeed = speedComputer.computerTurningSpeed(currentSpeed);
    }

    //output current car info
    @Override
    public String toString() {
        return name + " is moving at " + currentSpeed + " feet per second and has travelled " +
                getDistanceTraveled() + " feet. And I'm a truck!";
    }

    //output car's current position in the race
    public void outputPosition() {
        System.out.println(name + " is currently in position " + position + ".");
    }

    public float getDistanceTraveled() {
        return distanceTraveled.getCurrentMileage();
    }

    public void setPosition(final int position) {
        this.position = position;
    }
}
