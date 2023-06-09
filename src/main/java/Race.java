import jdk.jfr.Description;

import java.util.*;

/**
 * Runs races for one or more Contestants
 */
@Description("This class knows how to run races among contestants")
public class Race {
    final List<Contestant> racers = new ArrayList<>();

    public Race(Contestant... contestants) {
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
    public static void main(String[] args) throws HackingException {
        int[] numbers = {7, 8, 7, 7, 9};
        SevenDetector detector = new SevenDetector();
        for (int num : numbers) {
            detector.accept(num);
        }
        detector.noMoreData();
        System.out.println(detector.state().toString());

        // Uncomment when you want to just run some experiments
        // experiments(args);
        snoop(Race.class);
        snoop(RaceCar.class);
        snoop(FunnyRaceCar.class);
        snoop(Odometer.class);
        System.exit(0);

        final int maxCounter = 50;
        final int turnFrequency = 10;
        final int turnLocation = 5;
        Race race = new Race( //
                new RaceTruck("Red Truck", new UnlimitedSpeedComputer(5f), true), //
                new RaceCar("Blue Car", new LimitedSpeedComputer(40f, 10f), RaceCar.SPECIAL_INFO.HAS_SUNROOF), //
                new RaceCar("Green Car", new LimitedSpeedComputer(70f, 4f), RaceCar.SPECIAL_INFO.BORING), //
                new RaceCar("Yellow Car", new StupidSpeedComputer(), RaceCar.SPECIAL_INFO.HAS_SUNROOF));

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

    private void runRace(final int maxCounter, final int turnFrequency, final int turnLocation) throws HackingException {
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


    private static void experiments(String[] args) throws HackingException {
        Odometer uninitialized = null;
        String string1;
        if (args.length == 0) {
            string1 = "Hello world";
        } else {
            string1 = "Goodbye world";
        }

        System.out.println(string1);

        System.out.println(uninitialized.getCurrentMileage());

        // ints, floats, and anything not using `new` are *primitives*.
        int num1 = 0;
        int num2 = num1;
        num2++;

        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

        // We've been saying that o1 and o2 are objects.
        Odometer o1 = new Odometer();
        Odometer o2 = o1;
        Odometer o3 = new Odometer();
        o2.increase(1);
        System.out.println("odometer1: " + o1.getCurrentMileage());
        System.out.println("odometer2: " + o2.getCurrentMileage());

        // MAP
        // YOU GIVE ME A STRING, I REMEMBER FOR YOU AN ODOMETER (put)
        // YOU GIVE ME A STRING, I GIVE YOU AN ODOMETER (get)
        Map<String, Odometer> map = new HashMap<>();

        map.put("C", new Odometer());
        map.put("D", new Odometer());
        map.put("E", new Odometer());
        Odometer o4 = map.get("A");
        Odometer o5 = map.get("B");

        if (o4 != null) {
            System.out.println(o4.getCurrentMileage());
        } else {
            System.out.println("o4 is nonsense");
        }

        try {
            System.out.println("Before the dangerous code");
            System.out.println(o5.getCurrentMileage());
            System.out.println("After the dangerous code");
        } catch (final InputMismatchException e) {
            System.out.println("Please learn to type");
        } catch (final NullPointerException e) {
            System.out.println("Billion dollars");
        }


        Odometer huh = new HashMap<String, Odometer>().get("B");
        System.exit(0);
    }

    public Odometer getAnOdometer() {
        return null;
    }

    public int getAnumber() {
        return 0;
    }

    public static void snoop(Class c) {
        System.out.println();
        System.out.println("Snooping into " + c.getCanonicalName());
        for (var a : c.getAnnotations()) {
            System.out.println(c.getCanonicalName() + " has annotation " + a.toString() + " of type " + a.annotationType().toString());
        }
        for (var f : c.getFields()) {
            System.out.println(c.getCanonicalName() + " has accessible Field \"" + f.getName() + "\" of type " + f.getType().toString());
        }
        for (var f : c.getDeclaredFields()) {
            System.out.println(c.getCanonicalName() + " has declared Field \"" + f.getName() + "\" of type " + f.getType().toString());
        }
        for (var m : c.getMethods()) {
            System.out.println(c.getCanonicalName() + " has method " + m.getName() + " with " + m.getParameterCount() + " parameters");
            for (var a : m.getAnnotations()) {
                System.out.println(c.getCanonicalName() + " has method " + m.getName() + " with annotation " + a.toString());
            }
        }

    }
}
