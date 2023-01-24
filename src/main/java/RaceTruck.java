public class RaceTruck implements Contestant {
    public String name;
    private final SpeedComputer speedComputer;
    private float acceleration;
    private float currentSpeed;
    private Odometer distanceTraveled;
    private int position;

    public RaceTruck (String name, SpeedComputer speedComputer, float acceleration) {
        this.name = name;
        this.speedComputer = speedComputer;
        this.acceleration = acceleration;
        this.currentSpeed = 0;
        this.distanceTraveled = new Odometer();
    }

    //Increase current speed by acceleration,
    // if current speed is greater than max speed, set current speed to max speed
    public void accelerate() {
        currentSpeed = speedComputer.computeNewSpeed(currentSpeed, acceleration);
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

    public void setPosition(int position) {
        this.position = position;
    }
}
