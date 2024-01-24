import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class CarTransport extends Truck{

    boolean truckBedOpen;
    private Stack<Car> truckLoad;

    public CarTransport(){
        super(2,200, Color.BLUE,"CarTransport");
        this.truckBedOpen = false;
        this.truckLoad = new Stack<>();
        stopEngine();
    }
    public void loadTruck(Car car){
        double truckX = this.position.x;
        double truckY = this.position.y;
        double carX = car.position.x;
        double carY = car.position.y;

        if (!(car instanceof Truck)) {
            if(truckLoad.size() < 10 && truckBedOpen){
                if (carX >= truckX -1 || carX <= truckX +1 && carY >= truckY -1 || carY <= truckY +1) {
                    truckLoad.push(car);
                }
            }
        }
    }

    public void unloadTruck (Car car) {
        double truckX = this.position.x;
        double truckY = this.position.y;

        if (truckBedOpen) {
            while(!truckLoad.isEmpty()){
                truckLoad.pop().position.setPos(truckX+1, truckY+1);
            }
        }
    }

    void lowerTruckBed(){
        if (currentSpeed == 0) {
            this.truckBedOpen = true;
        }

    }
    void riseTruckBed(){
        this.truckBedOpen = false;
    }

    @Override
    public double speedFactor() {
        return 0;
    }

    @Override
    public void incrementSpeed(double amount) {

    }

    @Override
    public void decrementSpeed(double amount) {

    }
}
