
import java.awt.*;

public class Saab95 extends Car{
    
    public Saab95(){
        super(2,125, Color.red,"Saab95", VehicleType.CAR);
        transform.stopEngine();
    }
     protected void setTurboOn(){
	    transform.TurboOn = true;
    }

     protected void setTurboOff(){
	    transform.TurboOn = false;
    }

}
