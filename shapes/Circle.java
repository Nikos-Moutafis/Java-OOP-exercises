package gr.aueb.cf.ch16.exercise2;

import java.io.Serializable;

public class Circle extends AbstractShape implements  ICircle, Serializable,Cloneable {
    private double radius;

    public Circle(){}

    public Circle(double radius) {
        this.radius = radius;
    }

    //Copy constructor
    public Circle(Circle circle){
        this.radius = circle.radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getDiameter() {
        return  radius * 2;
    }

    @Override
    public double getArea() {
         return Math.PI * (radius * radius);
    }

    @Override
    public double getCircumference() {
        return (2 * radius * Math.PI);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getRadius());
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public Circle clone() {
        try {
            return (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
