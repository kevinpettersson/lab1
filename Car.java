import java.awt.*;
public interface Car {

    public int getNrDoors();
    public double getEnginePower();

    public double getCurrentSpeed();

    public Color getColor();

    public void setColor(Color clr);

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
