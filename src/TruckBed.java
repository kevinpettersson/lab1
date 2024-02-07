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

    protected void checkCargoDoor(Car car){
        if (this.truckBedAngle == 0){
            car.transform.setCargoDoorClosed(true);
        }
        else{
            car.transform.setCargoDoorClosed(false);
        }
    }

    public void lowerTruckBed(int degree, Car car) {
        if (car.transform.getCurrentSpeed() == 0) {
            if (getTruckBedAngle() + degree <= 70) {
                this.truckBedAngle += degree;
            }
            else {
                this.truckBedAngle = 70;
            }
        }
        checkCargoDoor(car);
    }

    public void raiseTruckBed(int degree, Car car) {
        if (car.transform.getCurrentSpeed() == 0) {
            if (getTruckBedAngle() - degree >= 0) {
                this.truckBedAngle -= degree;
            }
            else {
                this.truckBedAngle = 0;
            }
        }
        checkCargoDoor(car);
    }
}
