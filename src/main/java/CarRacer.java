public class CarRacer {
    /*The results of this race are incorrect, the correct result is:
        Red Car in 1st with 2272.5 feet travelled
        Blue Car in 4th with 1890 feet travelled
        Green Car in 2nd with 2191.5 feet travelled
        Yellow Car in 3rd with 2163 feet travelled
     */
    public static void main(String[] args) {
        Racecar redCar = new Racecar("Red Car", 60f, 5f);
        Racecar blueCar = new Racecar("Blue Car", 40f, 10f);
        Racecar greenCar = new Racecar("Green Car", 70f, 4f);
        Racecar yellowCar = new Racecar("Yellow Car", 50f, 7f);
        int maxCounter = 50;
        int turnFrequency = 10;
        int turnLocation = 5;
        for (int counter = 0; counter < maxCounter; counter++) {
            if (counter % turnFrequency == turnLocation) {
                System.out.println("The cars hit a turn!");
                redCar.turn();
                blueCar.turn();
                greenCar.turn();
                yellowCar.turn();
            }
            redCar.accelerate();
            redCar.move();
            System.out.println(redCar.toString());
            blueCar.accelerate();
            blueCar.move();
            System.out.println(blueCar.toString());
            greenCar.accelerate();
            greenCar.move();
            System.out.println(greenCar.toString());
            yellowCar.accelerate();
            yellowCar.move();
            System.out.println(yellowCar.toString());
            analyzeLeader(redCar, blueCar, greenCar, yellowCar);
        }
    }

    public static void analyzeLeader(Racecar redCar, Racecar blueCar, Racecar greenCar, Racecar yellowCar) {
        int[] currentPositions = Racecar.determinePositions(redCar, blueCar, greenCar, yellowCar);
        redCar.outputPosition(currentPositions[0]);
        blueCar.outputPosition(currentPositions[1]);
        greenCar.outputPosition(currentPositions[2]);
        yellowCar.outputPosition(currentPositions[3]);
        System.out.println();
    }
}
