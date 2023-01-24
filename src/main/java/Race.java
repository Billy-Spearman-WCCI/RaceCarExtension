import java.util.ArrayList;
import java.util.List;

public class Race {
    List<Racecar> cars = new ArrayList<>();

    public Race(Racecar ... contestants) {
        for (Racecar car : contestants) {
            cars.add(car);
        }
    }

    /*The results of this race are incorrect, the correct result is:
            Red Car in 1st with 2272.5 feet travelled
            Blue Car in 4th with 1890 feet travelled
            Green Car in 2nd with 2191.5 feet travelled
            Yellow Car in 3rd with 2163 feet travelled
         */
    public static void main(String[] args) {
        int maxCounter = 50;
        int turnFrequency = 10;
        int turnLocation = 5;
        Race race = new Race(new Racecar("Red Car", 60f, 5f), new Racecar("Blue Car", 40f, 10f), new Racecar("Green Car", 70f, 4f), new Racecar("Yellow Car", 50f, 7f));
        race.runRace(maxCounter, turnFrequency, turnLocation);
    }

    //determine the position of all cars in the race
    public void determinePositions() {
        for (Racecar car : cars) {
            int position = 1;
            for (Racecar otherCar : cars) {
                if (car.getDistanceTraveled() < otherCar.getDistanceTraveled()) {
                    position++;
                }
            }
            car.setPosition(position);
        }
    }

    private void runRace(int maxCounter, int turnFrequency, int turnLocation) {
        for (int counter = 0; counter < maxCounter; counter++) {
            if (counter % turnFrequency == turnLocation) {
                System.out.println("The cars hit a turn!");
                for (Racecar car : cars) {
                    car.turn();
                }
            }
            for (Racecar car : cars) {
                car.accelerate();
                car.move();
                System.out.println(car.toString());
            }
            determinePositions();
            for (Racecar car : cars) {
                car.outputPosition();
            }
            System.out.println();
        }
    }

}
