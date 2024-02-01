
import java.awt.*;

public abstract class Car implements Movable {

    private final int nrDoors;              //Number of door will never change for a specific car
    private final double enginePower;       //Engine power is a set number
    protected double currentSpeed;          //Speed can change over time
    private Color color;                    //Color can change as well
    private final String modelName;         //Volvo240 will always be a Volvo240
    private Direction direction;            //Direction the car is facing will change over time.
    protected Point position;               //Position will change over time.
    private final VehicleType type;         //Defines the Vehicle type.

    public Car (int nrDoors, double enginePower, Color color, String modelName, VehicleType type) {

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = Direction.NORTH;     //Cars initially facing "north"
        this.position = new Point(0,0); //Cars initially starts at "Origo"
        this.type = type;

    }

    // ---- MOVE ---- \\
    public void move(){
        switch (direction) {
            case NORTH:
                this.position.y += currentSpeed;
                break;
            case WEST:
                this.position.x -= currentSpeed;
                break;
            case SOUTH:
                this.position.y -= currentSpeed;
                break;
            case EAST:
                this.position.x += currentSpeed;
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
    public double getEnginePower(){
        return this.enginePower;
    }
    public double getCurrentSpeed(){
        return this.currentSpeed;
    }
    public Color getColor(){
        return this.color;
    }

    // ---- SETTERS ---- \\
    public void setColor(Color clr) { this.color = clr; }
    public void startEngine() { this.currentSpeed = 0; }
    public void stopEngine() { this.currentSpeed = 0.1; }

    // ---- SPEED STUFF ---- \\
    public double speedFactor() { return getEnginePower() * 0.01; }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(0, getCurrentSpeed() - speedFactor() * amount);
    }

    public void gas(double amount) {
        if (amount > 0 && amount <= 1) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Too much gas");
        }
    }
    public void brake(double amount) {
        if (amount > 0 && amount <= 1) {
           decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Too much brake");
        }
    }
}
