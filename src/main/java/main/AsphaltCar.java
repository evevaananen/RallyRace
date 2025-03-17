package main;

public class AsphaltCar extends RallyCar {
    private double aerodynamics;
    private int tireTraction;

    public AsphaltCar(String make, String model, int horsepower, double aerodynamics, int tireTraction) {
        super(make, model, horsepower);
        this.aerodynamics = aerodynamics;
        this.tireTraction = tireTraction;
    }

    @Override
    public double calculatePerformance() {
        return getHorsepower() * 0.6 + aerodynamics * 40 + tireTraction * 5;
    }
}