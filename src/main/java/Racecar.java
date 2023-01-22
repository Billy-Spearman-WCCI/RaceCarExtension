//You should only need to modify this file to fix the issues with the race
public class Racecar {
    public String name;
    private float maxSpeed;
    private float acceleration;
    private float currentSpeed;
    private float distanceTraveled;

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
    public void outputPosition(int position) {
        System.out.println(name + " is currently in position " + position + ".");
    }

    //determine the position of all cars in the race
    public static int[] determinePositions(Racecar... racecars) {
        int[] positions = new int[racecars.length];
        for (int counter = 0; counter < racecars.length; counter++) {
            int position = 1;
            for (int otherCarCounter = 0; otherCarCounter < racecars.length; otherCarCounter++) {
                if (racecars[counter].distanceTraveled <= racecars[otherCarCounter].distanceTraveled) {
                    position++;
                }
            }
            positions[counter] = position;
        }
        return  positions;
    }
}
