import java.awt.*;
import java.lang.Math;
public abstract class Car {

    final int nrDoors;              //Number of door will never change for a specific car
    final double enginePower;       //Engine power is a set number
    double currentSpeed;            //Speed is a variable that can change over time
    Color color;                    //Color can change as well
    final String modelName;         //A Volvo240 will always be a Volvo240
    int[] position;                 //The current position of the car
    int heading;

    public Car (int nrDoors, double enginePower, Color color, String modelName) {

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.position = new int[]{0,0};
        this.heading = 0;
    }

    public int turnLeft2(int degree) {
        return Math.abs((heading - degree)% 360);
    }

    public int turnRight2(int degree) {
        return Math.abs((heading + degree) % 360);
    }

   public void move() {
       this.position[0] = (int) (this.position[0] + Math.cos(heading)*currentSpeed);
       this.position[1] = (int) (this.position[1] + Math.cos(heading)*currentSpeed);
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
