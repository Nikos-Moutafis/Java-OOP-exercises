package gr.aueb.cf.ch16.exercise2;

import java.io.Serializable;

public class Line extends AbstractShape implements ILine, Serializable,Cloneable {
    private double length;

    public Line(){}

    public Line(double length) {
        this.length = length;
    }

    public Line(Line line){
        this.length = line.length;
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Line{" +
                "length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return Double.compare(line.getLength(), getLength()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getLength());
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public Line clone() {
        try {
            return (Line) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
