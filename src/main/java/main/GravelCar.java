package main;

public class GravelCar extends RallyCar {
    private double suspensionTravel;
    private int groundClearance;

    public GravelCar(String make, String model, int horsepower, double suspensionTravel, int groundClearance) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
        this.groundClearance = groundClearance;
    }

    @Override
    public double calculatePerformance() {
        return getHorsepower() * 0.7 + suspensionTravel * 30 + groundClearance * 3;
    }
}