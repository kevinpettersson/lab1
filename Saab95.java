import java.awt.*;

public class Saab95 extends Car {

    private final int nrDoors;
    private final String modelName;
    private final double enginePower;
    private double currentSpeed;
    private boolean turboOn;
    private Color color;
    
    public Saab95(){
        this.nrDoors = 2;
        this.color = Color.red;
        this.enginePower = 125;
	    this.turboOn = false;
        this.modelName = "Saab95";
        stopEngine();
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
