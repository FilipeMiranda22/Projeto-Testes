package models;

public class Raizes {
    private double x1;
    private double x2;

    @Override
    public String toString() {
        return String.format("x1 = %.2f; x2 = %.2f", getX1(), getX2());
    }

    public Raizes() {

    }

    public Raizes(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

}
