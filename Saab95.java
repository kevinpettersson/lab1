import java.awt.*;

public class Saab95 implements Car{

    private final int nrDoors;
    private final String modelName;
    private final double enginePower;
    private double currentSpeed;
    private boolean turboOn;
    private Color color;
    
    public Saab95(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName){
        this.nrDoors = 2;
        this.color = color; //
        this.enginePower = 125;
	    this.turboOn = false; //Turbo off by default.
        this.modelName = "Saab95";
        stopEngine();
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

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
