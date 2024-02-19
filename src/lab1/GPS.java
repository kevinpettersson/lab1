package lab1;

public class GPS {
    protected Direction direction;
    protected Point position;

    public GPS(){
        this.direction = Direction.NORTH;
        this.position = new Point(0,0);
    }
}
