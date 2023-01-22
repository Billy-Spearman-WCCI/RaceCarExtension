public class Racecar {
    public String name;
    private float maxSpeed;
    private float acceleration;
    private float currentSpeed;
    private float distanceTraveled;
    private int position;

    public Racecar(String name, float maxSpeed, float acceleration) {
        this.name = name;
        this.acceleration = acceleration;
        this.currentSpeed = 0;
        this.distanceTraveled = 0;
    }

    //Increase current speed by acceleration,
    // if current speed is greater than max speed, set current speed to max speed
    public void accelerate() {
        currentSpeed += acceleration;
        if (maxSpeed > currentSpeed) {
            currentSpeed = maxSpeed;
        }
    }
    //add current speed to distance travelled
    public void move() {
        distanceTraveled += currentSpeed;
    }

    //cut speed in half
    public void turn() {
        currentSpeed = currentSpeed / .5f;
    }

    //output current car info
    @Override
    public String toString() {
        return name + " is moving at " + currentSpeed + " feet per second and has travelled " +
                distanceTraveled + " feet.";
    }

    //output car's current position in the race
    public void outputPosition() {
        System.out.println(name + " is currently in position " + position + ".");
    }

    public float getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
