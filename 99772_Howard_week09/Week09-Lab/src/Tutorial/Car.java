package Tutorial;
public class Car implements Vehicle.Action {
    private Vehicle vehicle;

    public Car(String name) {
        this.vehicle = new Vehicle(name);
    }

    @Override
    public void start() {
        System.out.println(vehicle.getName() + " is starting");
    }

    @Override
    public void stop() {
        System.out.println(vehicle.getName() + " is stopping");

    }
    
    public void showVehicleInfo() {
        vehicle.displayInfo();
    }
    

}
