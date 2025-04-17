package Tugas;

public class Shape {
    protected int length;
    protected int width;

    public Shape(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int area() {
        return this.length * this.width;
    }

    public int getVolume(int height) {
        return this.length * this.width * height;
    }


}
