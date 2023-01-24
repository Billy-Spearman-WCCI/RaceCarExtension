public class Odometer {
    private float miles = 0;

    public void increase(final float currentSpeed) {
        miles += currentSpeed;
    }

    public float getCurrentMileage() {
        return miles;
    }
}
