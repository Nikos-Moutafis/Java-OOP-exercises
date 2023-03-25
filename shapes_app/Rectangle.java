package gr.aueb.cf.ch16.exercise2;

import java.io.Serializable;

public class Rectangle extends AbstractShape implements IRectangle, Serializable,Cloneable {

    private double width;
    private double height;

    public Rectangle(){}

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //Copy constructor
    public Rectangle(Rectangle rectangle){
        this.width = rectangle.width;
        this.height= rectangle.height;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getCircumference() {
        return 2 *(height + width);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (Double.compare(rectangle.getWidth(), getWidth()) != 0) return false;
        return Double.compare(rectangle.getHeight(), getHeight()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getWidth());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getHeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public Rectangle clone() {
        try {
            return (Rectangle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
