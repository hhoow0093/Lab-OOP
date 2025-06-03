package Latihan;

public class Latihann {
    static abstract class Machine {
        // 0 karena abstract class machine tidak ada attribute speed
        Machine(){
            start();
        }
        abstract void start();
    }

    static class Printer extends Machine{
        int speed = 5;
        // 5 karena class printer ada attribute speed
        Printer() {
            start();
        }
        void start(){
            System.out.println("Speed: " + speed);
        }
    }

    public static void main(String[] args) {
        new Printer();
        
    }


}
