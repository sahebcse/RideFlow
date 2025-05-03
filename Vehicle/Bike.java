package Vehicle;

public class Bike extends Vehicle {
    public Bike(final String numberPlate) {
        super(numberPlate);
    }

    @Override
    public double getFarePerKm() {
        return 10;
    }
}
