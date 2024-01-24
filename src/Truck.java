import java.awt.*;

public class Truck extends Car {

    int nrDoors;
    double enginePower;
    Color color;
    String modelName;
    int truckBedAngle;

    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;

    }

    public int getTruckBedAngle (){
        return truckBedAngle;
    }

    public void riseTruckbed (int angle) {
        if (currentSpeed == 0 && truckBedAngle + angle <= 70) {
            truckBedAngle += angle;
        } else {
            truckBedAngle = 70;
        }
    }

   public void lowerTruckbed (int angle) {
        if (currentSpeed == 0 && truckBedAngle - angle >= 0) {
            truckBedAngle -= angle;
        } else {
            truckBedAngle = 0;
        }
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
