
import java.awt.*;

public class Volvo240 extends Car{

    public Volvo240 (){
        super(4, 100, Color.red, "Volvo240", VehicleType.CAR);
        transform.setTrimFactor(1.25);
        transform.stopEngine();
    }

}
