public class Client {

    public static void main(String[] args) {
        //create 3 sample locations of india
        Location location1 = new Location(28.6139, 77.2090); // Delhi
        Location location2 = new Location(19.0760, 72.8777); // Mumbai
        Location location3 = new Location(13.0827, 80.2707); // Chennai

        // create vehicles
        Vehicle vehicle1 = new Vehicle("DL-01-1234", "Car");
        Vehicle vehicle2 = new Vehicle("MH-02-5678", "Bike");

        // create drivers
        Driver driver1 = new Driver("John", location1, vehicle1);
        Driver driver2 = new Driver("Alice", location2, vehicle2);

        // create passengers
        Passenger passenger1 = new Passenger("Bob", location3);
        Passenger passenger2 = new Passenger("Charlie", location1);

        RideSharingAppService rideSharingAppService = new RideSharingAppService();

        // add drivers and passengers to the service
        rideSharingAppService.addDriver(driver1);
        rideSharingAppService.addDriver(driver2);
        rideSharingAppService.addPassenger(passenger1);
        rideSharingAppService.addPassenger(passenger2);

        // book rides

        rideSharingAppService.bookRide(passenger1, 10.0); // Bob books a ride
        rideSharingAppService.bookRide(passenger2, 5.0); // Charlie books a ride
        // book a ride when no drivers are available
        rideSharingAppService.bookRide(passenger1, 10.0); // Bob books a ride






    }
}
