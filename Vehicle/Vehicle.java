package Vehicle;

public abstract class Vehicle {

    protected String numberPlate;

    public Vehicle(final String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public abstract double getFarePerKm();

}
