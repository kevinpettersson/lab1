package lab1;

import java.awt.*;

public class Saab95 extends Car {
    
    public Saab95(){
        super(2,125, Color.red,"Saab95", VehicleType.CAR);
        transform.stopEngine();
    }
     public void setTurboOn(){
	    transform.TurboOn = true;
    }

     public void setTurboOff(){
	    transform.TurboOn = false;
    }

    //--- Getters --- \\
    public boolean getTurboValue(){
        return this.transform.TurboOn;
    }

}
