
import java.awt.*;

public abstract class Car implements Movable {

    final int nrDoors;              //Number of door will never change for a specific car
    final double enginePower;       //Engine power is a set number
    double currentSpeed;            //Speed is a variable that can change over time
    Color color;                    //Color can change as well
    final String modelName;         //A src.Volvo240 will always be a src.Volvo240
    //int[] position;                 //The current position of the car
    int heading;
    Direction direction;
    Point position;

    public Car (int nrDoors, double enginePower, Color color, String modelName) {

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        //this.position = new int[]{0,0};
        this.position = new Point(0,0);
        this.heading = 90;                 //Unit circle "north"
        this.direction = Direction.NORTH; //Cars initially facing "north"
    }
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
    public void turnLeft() {
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

    /*

    public void turnLeft(int degree) {
        this.heading =  Math.abs((heading - degree)% 360);
    }

    public void turnRight(int degree) {
        this.heading = Math.abs((heading + degree)% 360);
    }

   public void move() {
       this.position[0] = (int) (this.position[0] + Math.cos(Math.toRadians(heading))*currentSpeed);
       this.position[1] = (int) (this.position[1] + Math.sin(Math.toRadians(heading))*currentSpeed);
   }
     */

    public String getModelName(){
        return modelName;
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0;
    }

    public void stopEngine() {
        currentSpeed = 0.1;
    }

    public abstract double speedFactor();

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

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
