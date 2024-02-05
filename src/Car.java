
import java.awt.*;

public abstract class Car implements Movable {
    private final int nrDoors;              //Number of door will never change for a specific car
    private Color color;                    //Color can change as well
    private final String modelName;         //Volvo240 will always be a Volvo240
    private Direction direction;            //Direction the car is facing will change over time.
    protected Point position;               //Position will change over time.
    private final VehicleType type;         //Defines the Vehicle type.
    protected Transform transform;

    public Car (int nrDoors, double enginePower, Color color, String modelName, VehicleType type) {

        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
        this.direction = Direction.NORTH;     //Cars initially facing "north"
        this.position = new Point(0,0); //Cars initially starts at "Origo"
        this.type = type;
        this.transform = new Transform(enginePower);

    }

    // ---- MOVE ---- \\
    public void move(){
        switch (direction) {
            case NORTH:
                this.position.y += transform.getCurrentSpeed();
                break;
            case WEST:
                this.position.x -= transform.getCurrentSpeed();
                break;
            case SOUTH:
                this.position.y -= transform.getCurrentSpeed();
                break;
            case EAST:
                this.position.x += transform.getCurrentSpeed();
                break;
        }
    }
    public void turnLeft(){
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
        }
    }
    public void turnRight(){
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
        }
    }

    // ---- GETTERS ---- \\
    public VehicleType getVehicleType(){
        return this.type;
    }
    public Direction getDirection() { return this.direction; }
    public String getModelName(){
        return this.modelName;
    }
    public int getNrDoors(){
        return this.nrDoors;
    }
    public Color getColor(){
        return this.color;
    }

    // ---- SETTERS ---- \\
    public void setColor(Color clr) { this.color = clr; }



}
