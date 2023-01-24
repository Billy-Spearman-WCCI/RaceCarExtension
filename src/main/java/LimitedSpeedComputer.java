public class LimitedSpeedComputer implements SpeedComputer {
    final private float maxSpeed;

    public LimitedSpeedComputer(final float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public float computeNewSpeed(final float currentSpeed, final float acceleration) {
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
