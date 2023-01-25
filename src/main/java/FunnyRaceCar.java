public class FunnyRaceCar extends RaceCar {
    public FunnyRaceCar(String name, SpeedComputer speedComputer, boolean hasSunRoof) {
        super(name, speedComputer, hasSunRoof);
    }

    public String TellAJoke() {
        return "A car named " + this.name + ", a truck, and a duck walk into a bar ...";
    }
}
