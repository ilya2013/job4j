package ru.job4j.pseudo;


public class Paint {
    Shape shape;

    public Paint() {

    }
    public Paint(Shape shape) {
        this.shape = shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void draw(Shape shape) {
        String result = null;
        if (shape != null) {
            System.out.println(shape.draw());
        }
    }
}
