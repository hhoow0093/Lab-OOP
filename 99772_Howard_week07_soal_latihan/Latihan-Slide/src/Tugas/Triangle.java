package Tugas;

public class Triangle extends Shape{
    public Triangle(int length, int width) {
        super(length, width);
    }

    public int area() {
        return (int)(length * width) / 2;
    }

    public int getVolume(int height) {
        return (int)((1.0 / 3) * area() * height);
    }

}
