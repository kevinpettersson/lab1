import java.awt.*;

public class Scania extends Car implements iTruckBed  {

    private TruckBed tb;
    public Scania() {
        super(2, 125, Color.BLACK, "Scania", VehicleType.TRUCK);
        this.tb = new TruckBed();
        stopEngine();
    }


    public void setTruckBedAngle(int degree) {
        tb.setTruckBedAngle(degree, this);
    }


    public int getTruckBedAngle() {
        return tb.truckBedAngle;
    }
    public void raiseTruckBed(int degree){
        tb.raiseTruckBed(degree, this);
    }

    public void lowerTruckBed(int degree) {
       tb.lowerTruckBed(degree, this);
    }

    @Override
    public void incrementSpeed(double amount){
        if (tb.getTruckBedAngle() == 0){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        }

    }

    @Override
    public void decrementSpeed(double amount){
        if (tb.getTruckBedAngle() == 0){
            currentSpeed = Math.max(0, getCurrentSpeed() - speedFactor() * amount);
        }
    }
}


