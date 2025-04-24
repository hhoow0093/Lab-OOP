package Tugas;

public class Main {
    public static void main(String[] args) {
        SmartPhone samsung = new SmartPhone("S24 Ultra", "Samsung", 15, "my-hotspot");
        samsung.displayDetail();
        samsung.turnOn();
        samsung.increaseVolume(10);
        samsung.decreaseVolume(4);
        samsung.ConnectToWifi("WIFI Student");
        samsung.DisconnectWifi();
        samsung.turnOff();
    }

}
