import java.awt.*;

public class Scania extends Car  {

    private int truckBedAngle;

    public Scania() {
        super(2, 200,Color.BLUE, "Scania", VehicleType.TRUCK);
        this.truckBedAngle = 0;
        stopEngine();
    }

    public void setTruckBedAngle(int degree) {
        if (degree >= 0) {
            this.truckBedAngle += degree;
        }
    }
    public int getTruckBedAngle(){
        return this.truckBedAngle;
    }
    public void riseTruckbed (int degree) {
        if (getCurrentSpeed() == 0) {
            if (getTruckBedAngle() + degree <= 70) {
                setTruckBedAngle(degree);
            }
            else {
                setTruckBedAngle(70);
            }
        }
    }

    public void lowerTruckbed (int degree) {
        if (getCurrentSpeed() == 0) {
            if (getTruckBedAngle() - degree >= 0) {
                setTruckBedAngle(-degree);
            }
            else {
                setTruckBedAngle(0);
            }
        }
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void incrementSpeed(double amount) {
        if(truckBedAngle == 0){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        }

    }
    @Override
    public void decrementSpeed(double amount) {
        if(getTruckBedAngle() == 0) {
            this.currentSpeed = Math.max(0, getCurrentSpeed() - speedFactor() * amount);
        }

    }
}


