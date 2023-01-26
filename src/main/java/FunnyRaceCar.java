public class FunnyRaceCar extends RaceCar {
    public FunnyRaceCar(String name, SpeedComputer speedComputer, RaceCar.SPECIAL_INFO specialInfo) {
        super(name, speedComputer, specialInfo);
    }

    public String TellAJoke() {
        return "A car named " + this.name + ", a truck, and a duck walk into a bar ...";
    }
}
