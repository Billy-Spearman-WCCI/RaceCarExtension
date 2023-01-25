public class Odometer {
    private float miles = 0;

    public void increase(final float currentSpeed) throws HackingException {
        if (currentSpeed < 0) {
            throw new HackingException("Rolling back odometers is illegal");
        }
        miles += currentSpeed;
    }

    public float getCurrentMileage() {
        return miles;
    }
}
