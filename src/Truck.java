import java.awt.*;

public abstract class Truck extends Car {

    protected int truckBedAngle;

    public Truck(int nrDoors, int enginePower, Color color, String name, VehicleType type) {
        super(2, 125, Color.BLACK, "Truck", VehicleType.TRUCK);
        this.truckBedAngle = 0;
        stopEngine();
    }

    public int getTruckBedAngle(){
        return this.truckBedAngle;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void incrementSpeed(double amount) {
        if(getTruckBedAngle() == 0){
            this.currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        }
    }

    @Override
    public void decrementSpeed(double amount) {
        if(getTruckBedAngle() == 0) {
            this.currentSpeed = Math.max(0, getCurrentSpeed() - speedFactor() * amount);
        }

    }

    public abstract void riseTruckbed(int degree);

    public abstract void lowerTruckbed(int degree);
}
