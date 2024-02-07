
import java.awt.*;

public class Volvo240 extends Car{

    public Volvo240 (){
        super(4, 100, Color.red, "Volvo240", VehicleType.CAR);
        setTrimFactor(1.25);
        transform.stopEngine();
    }
    public void setTrimFactor(double value){
        transform.TrimFactor = value;
    }

}
