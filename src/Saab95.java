
import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        super(2,125, Color.red,"Saab95");
	    this.turboOn = false;
        stopEngine();
    }

     void setTurboOn(){
	    turboOn = true;
    }

     void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }


}
