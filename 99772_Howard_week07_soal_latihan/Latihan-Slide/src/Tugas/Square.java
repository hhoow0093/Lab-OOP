package Tugas;

public class Square extends Shape {
    public Square(int length) {
        super(length, length);
    }

    public int area() {
        return super.area();
    }

    public int getVolume() {
        return super.getVolume(length);
    }

}
