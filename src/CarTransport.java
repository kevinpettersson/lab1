import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class CarTransport extends Truck{

    boolean truckBedOpen;
    protected Stack<Car> truckLoad;

    public CarTransport(){
        super(2,200, Color.BLUE,"CarTransport");
        this.truckBedOpen = false;
        this.truckLoad = new Stack<>();
        stopEngine();
    }
    @Override
    public void move(){

        switch (direction) {
            case NORTH:
                this.position.y += currentSpeed;
                truckLoadPos(truckLoad);
                break;
            case WEST:
                this.position.x -= currentSpeed;
                truckLoadPos(truckLoad);
                break;
            case SOUTH:
                this.position.y -= currentSpeed;
                truckLoadPos(truckLoad);
                break;
            case EAST:
                this.position.x += currentSpeed;
                truckLoadPos(truckLoad);
                break;
        }
    }
    public void truckLoadPos(Stack<Car> truckload) {
        ArrayList<Car> tmp = new ArrayList<>();

        for (int i = 0; i < truckLoad.size(); i++) {
            tmp.add(truckLoad.pop());
        }
        for (Car car : tmp) {
            car.position = this.position;
        }
        for (Car car : tmp) {
            truckload.push(car);
        }
    }
    public void loadTruck(Car car){
        double truckX = this.position.x;
        double truckY = this.position.y;
        double carX = car.position.x;
        double carY = car.position.y;

        if (!(car instanceof Truck)) {
            if(truckLoad.size() < 10 && truckBedOpen){
                if (carX >= truckX -1 || carX <= truckX + 1 && carY >= truckY -1 || carY <= truckY +1) {
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
        if (currentSpeed == 0) {
            this.truckBedOpen = false;
        }
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
