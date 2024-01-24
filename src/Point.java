
public class Point {
    double x;
    double y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void setPos(double nx, double ny) {
        this.x = nx;
        this.y = ny;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "src.Point{" + "x=" + x + ", y=" + y + '}';
    }
}
