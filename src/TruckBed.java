public class TruckBed {

    int truckBedAngle;
    TruckBed(){
        this.truckBedAngle = 0;
    }

    public void setTruckBedAngle(int degree, Car car){
        this.truckBedAngle = degree;
    }

    public int getTruckBedAngle() {
        return this.truckBedAngle;
    }

    public void lowerTruckBed(int degree, Car car) {
        if (car.getCurrentSpeed() == 0) {
            if (getTruckBedAngle() + degree <= 70) {
                this.truckBedAngle += degree;
            }
            else {
                this.truckBedAngle = 70;
            }
        }
    }

    public void raiseTruckBed(int degree, Car car) {
        if (car.getCurrentSpeed() == 0) {
            if (getTruckBedAngle() - degree >= 0) {
                this.truckBedAngle -= degree;
            }
            else {
                this.truckBedAngle = 0;
            }
        }
    }
}
