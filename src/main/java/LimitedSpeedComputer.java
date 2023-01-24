public class LimitedSpeedComputer implements SpeedComputer {
    final private float maxSpeed;
    final private float acceleration;

    public LimitedSpeedComputer(final float maxSpeed, final float acceleration) {
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
    }

    @Override
    public float computeNewSpeed(final float currentSpeed) {
        final float result = currentSpeed + acceleration;

        if (maxSpeed < result) {
            return maxSpeed;
        } else {
            return result;
        }
    }

    @Override
    public float computerTurningSpeed(final float currentSpeed) {
        return currentSpeed * 0.5f;
    }
}
