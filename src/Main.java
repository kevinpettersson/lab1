import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {

    static public void main (String[] args) {
        Workshop<Truck> work = new Workshop(2, new Point(0,0));

        Saab95 saabish = new Saab95();
        Volvo240 volvo = new Volvo240();

        Scania scanish = new Scania();
        CarTransport ct = new CarTransport();

        work.leaveVehicle(ct);
    }
}
