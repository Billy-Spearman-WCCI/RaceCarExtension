public class UnlimitedSpeedComputer implements SpeedComputer {
    @Override
    public float computeNewSpeed(float currentSpeed, float acceleration) {
        return currentSpeed + acceleration;
    }

    @Override
    public float computerTurningSpeed(float currentSpeed) {
        return currentSpeed * 0.5f;
    }
}
