package Tugas;

public class Device {
    private String model;
    private String brand;

    public Device(String model, String brand) {
        this.model = model;
        this.brand = brand;
        
    }
    
    interface Connectivity {
        void ConnectToWifi(String networkName);

        void DisconnectWifi();
        
    }

    public void displayInfo() {
        System.out.print("Device Info: Brand: " + brand + ", " + "Model: " + model);
        System.out.println();
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }


}
