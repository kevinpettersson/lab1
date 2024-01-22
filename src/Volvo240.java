
import java.awt.*;

public class Volvo240 extends Car{

    private static final double trimFactor = 1.25;
    public Volvo240 (){
        super(4, 100, Color.red, "src.Volvo240");
        stopEngine();
    }
    
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}
