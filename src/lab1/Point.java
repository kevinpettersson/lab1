package lab1;

public class Point {
    protected double x;
    protected double y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void setPos(double nx, double ny) {
        this.x = nx;
        this.y = ny;
    }
    public void setX(double amount){
        this.x = amount;
    }
    public void setY(double amount){
        this.y = amount;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "src.Point{" + "x=" + x + ", y=" + y + '}';
    }
}
