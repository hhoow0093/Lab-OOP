package Downcasting;
public class DownCasting {
    static class Animal {
        void sound() {
            System.out.println("animal sound");
        }

    }
    
    static class Dog extends Animal {
        void bark() {
            System.out.println("dog sound");
        }
    }

    public static void main(String[] args) {
        // upcasting, tidak bisa akses bark
        System.out.println("Contoh upcasting");
        Animal animal = new Dog();
        animal.sound();
        System.out.println(animal instanceof Dog);
        System.out.println(animal instanceof Animal);
        System.out.println();

        System.out.println("Contoh downcasting yang benar");
        // downcasting, bisa akses semua method
        Dog dog = (Dog) animal;
        System.out.println(dog instanceof Dog);
        System.out.println(dog instanceof Animal);
        dog.bark();
        dog.sound();
        System.out.println();

        System.out.println("Contoh downcasting yang salah");
        // error karena instansiasi animal adalah class Animal.
        Animal animal2 = new Animal();
        System.out.println(animal2 instanceof Dog);
        try {
            Dog dog2 = (Dog) animal2;
            dog2.bark();
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("Exception karena instansiasi animal2 adalah class Animal.");
        }

    }

}
