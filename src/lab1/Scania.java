package lab1;

import java.awt.*;

public class Scania extends Car implements iTruckBed {

    private TruckBed tb;
    public Scania() {
        super(2, 125, Color.BLACK, "Scania", VehicleType.TRUCK);
        this.tb = new TruckBed();
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

}


