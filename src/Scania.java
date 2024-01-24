import java.awt.*;

public class Scania extends Truck  {

    int truckBedAngle;

    public Scania() {
        super(2, 200,Color.BLUE, "Scania");
        this.truckBedAngle = 0;
        stopEngine();
    }


    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void incrementSpeed(double amount) {
        if(truckBedAngle == 0){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }

    }

    @Override
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(0, getCurrentSpeed() - speedFactor() * amount);
    }
}


