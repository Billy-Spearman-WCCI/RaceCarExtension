public class RaceTruck extends GenericRacer {
    final private boolean isPullingABoatTrailer;

    public RaceTruck(final String name, final SpeedComputer speedComputer, final boolean isPullingABoatTrailer) {
        // The constructor for GenericRacer cares about name and speedComputer only.
        super(name, speedComputer);

        this.isPullingABoatTrailer = isPullingABoatTrailer;
    }

    //output current car info
    @Override
    public String toString() {
        return name + " is moving at " + currentSpeed + " feet per second and has travelled " +
                getDistanceTravelled() + " feet. And I'm a truck!";
    }

    //output car's current position in the race
    public void outputPosition() {
        System.out.println(name + " is currently in position " + position + ".");
    }

    @Override
    public float getStyleCreditDistance() {
        // Trucks which are pulling a boat trailer during the race get 1000ft bonus for style
        if (isPullingABoatTrailer) {
            return 1000;
        } else {
            return 0;
        }
    }
}
