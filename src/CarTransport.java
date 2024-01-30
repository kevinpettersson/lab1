import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class CarTransport extends Car{

    boolean truckBedOpen;                       //Boolean representing wether the truck bed door is open or closed.
    protected Stack<Car> truckLoad;             //Represents the truckload as a stack.
    private int MAX_TRUCK_LOAD_CAPACITY = 10;   //Threshold for how many cars the truckload can hold.

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

        //Set the position of each element in the stack equal to trucks position.
        while (!truckLoad.isEmpty()) {
            Car car = truckLoad.pop();
            car.position.setPos(this.position.getX(), this.position.getY());
            tmp.push(car);
        }
        //Pushes each element back to the original stack.
        while (!tmp.isEmpty()) {
            truckLoad.push(tmp.pop());
        }

    }
    public void loadTruck(Car car) {
        double truckPositionX = this.position.getX();
        double truckPositionY = this.position.getY();
        double carPositionX = car.position.getX();
        double carPositionY = car.position.getY();

        //Checks so vehicle type is not truck.
        if (!(car.getVehicleType() == VehicleType.TRUCK)) {

            //Checks so the truckload is less than max capacity and that the door is open.
            if((truckLoad.size() < MAX_TRUCK_LOAD_CAPACITY) && truckBedOpen){

                //Checks so the position of the car and the truck is within range of each other.
                if ((carPositionX >= truckPositionX - 1 && carPositionX <= truckPositionX + 1)
                        && (carPositionY >= truckPositionY -1 && carPositionY <= truckPositionY +1)){
                    truckLoad.push(car);
                }
            }
        }
    }

    public void unloadTruck() {
        double truckX = this.position.x;
        double truckY = this.position.y;

        //Pops the stack and place the load close to the truck.
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

}
