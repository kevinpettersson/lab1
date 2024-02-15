package lab1;

import lab2.DrawPanel;

import java.awt.*;

public class Saab95 extends Car {
    
    public Saab95(){
        super(2,125, Color.red,"Saab95", VehicleType.CAR);

    }
     public void setTurboOn(){
	    transform.TurboOn = true;
    }

     public void setTurboOff(){
	    transform.TurboOn = false;
    }

    //--- Getters --- \\
    public boolean getTurboState(){
        return this.transform.TurboOn;
    }

}
