public class LimitedSpeedComputer implements SpeedComputer {
    public LimitedSpeedComputer(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    private float maxSpeed;

    @Override
    public float computeNewSpeed(float currentSpeed, float acceleration) {
        float result = currentSpeed + acceleration;
        if (maxSpeed < result) {
            return maxSpeed;
        } else {
            return result;
        }
    }

    @Override
    public float computerTurningSpeed(float currentSpeed) {
        return currentSpeed * 0.5f;
    }
}
