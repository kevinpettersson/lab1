import java.awt.*;
public class Car {

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

    public void startEngine();

    public void stopEngine();

    public double speedFactor();

    public void incrementSpeed(double amount);

    public void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount);

    // TODO fix this method according to lab pm
    public void brake(double amount);
}
