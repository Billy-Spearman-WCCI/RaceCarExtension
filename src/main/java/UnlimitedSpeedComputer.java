public class UnlimitedSpeedComputer implements SpeedComputer {
    private final float acceleration;

    public UnlimitedSpeedComputer(final float acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public float computeNewSpeed(float currentSpeed) {
        return currentSpeed + acceleration;
    }

    @Override
    public float computerTurningSpeed(float currentSpeed) {
        return currentSpeed * 0.5f;
    }
}
