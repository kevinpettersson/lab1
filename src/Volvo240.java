
import java.awt.*;

public class Volvo240 extends Car{

    private static final double trimFactor = 1.25;
    public Volvo240 (){
        super(4, 100, Color.red, "Volvo240", VehicleType.CAR);
        stopEngine();
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
