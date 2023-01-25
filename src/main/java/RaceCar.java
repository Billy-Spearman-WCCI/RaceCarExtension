public class RaceCar extends GenericRacer {

    final private boolean hasSunRoof;

    public RaceCar(final String name, final SpeedComputer speedComputer, final boolean hasSunRoof) {
        // The constructor for GenericRacer cares about name and speedComputer only.
        super(name, speedComputer);

        this.hasSunRoof = hasSunRoof;
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
        if (hasSunRoof) {
            return 100;
        } else {
            return 0;
        }
    }
}
