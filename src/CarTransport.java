import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class CarTransport extends Car{

    boolean truckBedOpen;
    protected Stack<Car> truckLoad;
    private int MAX_TRUCK_LOAD_CAPACITY = 10;

    public CarTransport(){
        super(2,200, Color.BLUE,"CarTransport");
        this.truckBedOpen = false;
        this.truckLoad = new Stack<Car>();
        stopEngine();
    }
    @Override
    public void move(){

        switch (getDirection()) {
            case NORTH:
                this.position.y += currentSpeed;
                break;
            case WEST:
                this.position.x -= currentSpeed;
                break;
            case SOUTH:
                this.position.y -= currentSpeed;
                break;
            case EAST:
                this.position.x += currentSpeed;
                break;
        }
        truckLoadPos();
    }
    public void truckLoadPos() {
        Stack<Car> tmp = new Stack<>();

        while (!truckLoad.isEmpty()) {
            Car car = truckLoad.pop();
            car.position.setPos(this.position.getX(), this.position.getY());
            tmp.push(car);
        }
        while (!tmp.isEmpty()) {
            truckLoad.push(tmp.pop());
        }

    }
    public void loadTruck(Car car) {
        double truckPositionX = this.position.getX();
        double truckPositionY = this.position.getY();
        double carPositionX = car.position.getX();
        double carPositionY = car.position.getY();

        if ((car.getEnginePower() == 125)) {   //
            if(truckLoad.size() < MAX_TRUCK_LOAD_CAPACITY && truckBedOpen){
                if ((carPositionX >= truckPositionX - 1 || carPositionX <= truckPositionX + 1)
                        && (carPositionY >= truckPositionY -1 || carPositionY <= truckPositionY +1)){
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
