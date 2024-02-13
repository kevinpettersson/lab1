package lab1;

import java.awt.*;

public class Volvo240 extends Car {

    public Volvo240 (){
        super(4, 125, Color.red, "Volvo240", VehicleType.CAR);
        setTrimFactor(1.25);
    }
    public void setTrimFactor(double value){
        transform.TrimFactor = value;
    }

}
