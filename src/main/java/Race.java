import java.util.ArrayList;
import java.util.List;

public class Race {
    final List<Contestant> racers = new ArrayList<>();

    public Race(Contestant ... contestants) {
        for (Contestant contestant : contestants) {
            racers.add(contestant);
        }
    }

    /*The results of this race are incorrect, the correct result is:
            Red Car in 1st with 2272.5 feet travelled
            Blue Car in 4th with 1890 feet travelled
            Green Car in 2nd with 2191.5 feet travelled
            Yellow Car in 3rd with 2163 feet travelled
         */
    public static void main(String[] args) {
        final int maxCounter = 50;
        final int turnFrequency = 10;
        final int turnLocation = 5;
        Race race = new Race( //
                new RaceTruck("Red Truck", new UnlimitedSpeedComputer(5f), true), //
                new RaceCar("Blue Car", new LimitedSpeedComputer(40f, 10f), true), //
                new RaceCar("Green Car", new LimitedSpeedComputer(70f, 4f), false), //
                new RaceCar("Yellow Car", new StupidSpeedComputer(), true));

        try {
            race.runRace(maxCounter, turnFrequency, turnLocation);
        } catch (HackingException e) {
            System.out.println("Attention everybody. Tampering has been detected in this race. The race is scratched and all bets will be returned.");
        }
    }

    //determine the position of all cars in the race
    public void determinePositions() {
        for (Contestant racer : racers) {
            int position = 1;
            for (Contestant otherRacer : racers) {
                if ((racer.getDistanceTravelled() + racer.getStyleCreditDistance()) < (otherRacer.getDistanceTravelled() + otherRacer.getStyleCreditDistance())) {
                    position++;
                }
            }
            racer.setPosition(position);
        }
    }

    private void runRace(int maxCounter, int turnFrequency, int turnLocation) throws HackingException {
        for (int counter = 0; counter < maxCounter; counter++) {
            if (counter % turnFrequency == turnLocation) {
                System.out.println("The cars hit a turn!");
                for (final Contestant car : racers) {
                    car.turn();
                }
            }
            for (final Contestant contestant : racers) {
                contestant.accelerate();
                contestant.move();
                System.out.println(contestant.toString());
            }
            determinePositions();
            for (final Contestant contestant : racers) {
                contestant.outputPosition();
            }
            System.out.println();
        }
    }
}
