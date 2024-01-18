import java.awt.*;
import java.lang.Math;
public abstract class Car {

    final int nrDoors;
    final double enginePower;
    double currentSpeed;
    Color color;
    final String modelName;

    public Car (int nrDoors, double enginePower, Color color, String modelName) {

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
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
