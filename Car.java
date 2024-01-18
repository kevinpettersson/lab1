import java.awt.*;
import java.lang.Math;
public abstract class Car implements Movable {

    final int nrDoors;              //Number of door will never change for a specific car
    final double enginePower;       //Engine power is a set number
    //Speed is a variable that can change over time
    double currentSpeed;
    //Color can change as well
    Color color;

    //A Volvo240 will always be a Volvo240
    final String modelName;

    //The current position of the car, could be double[] for more precise location.
    float[] position;
    int heading;

    public Car (int nrDoors, double enginePower, Color color, String modelName) {

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.position = new float[]{0,0};
        this.heading = 90;                 //Unit circle "north"
    }



    public void turnLeft(int degree) {
        this.heading =  Math.abs((heading + degree)% 360);
    }

    public void turnRight(int degree) {
        this.heading = Math.abs((heading - degree)% 360);
    }

   public void move() {
       this.position[0] = (float) (this.position[0] + Math.cos(Math.toRadians(heading))*currentSpeed);
       this.position[1] = (float) (this.position[1] + Math.sin(Math.toRadians(heading))*currentSpeed);
   }

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
        if ((currentSpeed += amount) < enginePower) {
            currentSpeed += amount;
        }
    }
    public void brake(double amount) {
        if ((currentSpeed -= amount) > enginePower) {
            currentSpeed -= amount;
        }
    }
}
