public class RaceCar extends GenericRacer {
    public enum SPECIAL_INFO {
        HAS_SUNROOF, HAS_SPOILER, BORING
    }

    final private SPECIAL_INFO specialInfo;

    public RaceCar(final String name, final SpeedComputer speedComputer, final SPECIAL_INFO specialInfo) {
        // The constructor for GenericRacer cares about name and speedComputer only.
        super(name, speedComputer);

        this.specialInfo = specialInfo;
    }

    //output current car info
    @Override
    public String toString() {
        return name + " is moving at " + currentSpeed + " feet per second and has travelled " +
                getDistanceTravelled() + " feet.";
    }

    //output car's current position in the race
    public void outputPosition() {
        System.out.println(name + " is currently in position " + position + ".");
    }

    @Override
    public float getStyleCreditDistance() {
        // Racecars with a sunroof get 100ft bonus because of the extra weight of a sunroof.
        switch (specialInfo) {
            case HAS_SUNROOF:
                return 100;
            default:
                return 0;
        }
    }
}
