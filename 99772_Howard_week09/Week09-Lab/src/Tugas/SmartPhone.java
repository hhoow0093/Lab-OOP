package Tugas;

public class SmartPhone implements Power, VolumeControl, Device.Connectivity {
    private int currentVolume;
    private Device devicename;
    private String networkName;

    public SmartPhone(String model, String brand, int volume, String network) {
        devicename = new Device(model, brand);
        currentVolume = volume;
        networkName = network;
    }
    @Override
    public void turnOn() {
        System.out.println("device " + devicename.getBrand() + " " + devicename.getModel() + " is turning on");
    }
    @Override
    public void turnOff() {
        System.out.println("device " + devicename.getBrand() + " " + devicename.getModel() + " is turning off");
    }
    @Override
    public void increaseVolume(int level) {
        currentVolume += level;
        System.out.println("device has now volume of " + currentVolume + " from" + (currentVolume - level));
    }
    @Override
    public void decreaseVolume(int level) {
        currentVolume -= level;
        System.out.println("device has now volume of " + currentVolume + " from" + (currentVolume + level));

    }
    @Override
    public void ConnectToWifi(String networkName) {
        System.out.println("connecting to " + networkName);
        this.networkName = networkName;
    }
    @Override
    public void DisconnectWifi() {
        System.out.println("disconnecting from " + networkName);

    }
    
    public void displayDetail() {
        devicename.displayInfo();
    }

}
