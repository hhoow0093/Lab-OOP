package Tutorial;
public class Vehicle {
    interface Action {
        void start();
        void stop();
    }
    
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("Vehicle: " + name);
    }


}
