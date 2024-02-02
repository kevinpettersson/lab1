import java.awt.*;

public class Scania extends Truck  {


    public Scania() {
        super(2, 125, Color.BLACK, "Scania", VehicleType.TRUCK);
        stopEngine();
    }


    @Override
    public void riseTruckbed(int degree) {
        if (getCurrentSpeed() == 0) {
            if (getTruckBedAngle() - degree >= 0) {
                this.truckBedAngle -= degree;
            }
            else {
                this.truckBedAngle = 0;
            }
        }
    }

    @Override
    public void lowerTruckbed (int degree) {
        if (getCurrentSpeed() == 0) {
            if (getTruckBedAngle() + degree <= 70) {
                this.truckBedAngle += degree;
            }
            else {
                this.truckBedAngle = 70;
            }
        }
    }
}


