import java.awt.*;
import java.util.Stack;

public class CarTransport extends Car implements iTruckBed{

    protected Stack<Car> truckLoad;             //Represents the truckload as a stack.
    private int MAX_TRUCK_LOAD_CAPACITY = 10;   //Threshold for how many cars the truckload can hold.
    private TruckBed tb;

    public CarTransport(){
        super(2,125, Color.BLUE,"CarTransport", VehicleType.TRUCK);
        this.tb = new TruckBed();
        this.truckLoad = new Stack<Car>();
        stopEngine();
    }
    @Override
    public void move(){
        super.move();
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
            if((truckLoad.size() < MAX_TRUCK_LOAD_CAPACITY) && tb.getTruckBedAngle() == 70){

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
        if (tb.getTruckBedAngle() == 70) {
            while(!truckLoad.isEmpty()){
                Car car = truckLoad.pop();
                car.position.setPos(truckX+1, truckY+1);

            }
        }
    }

    public void setTruckBedAngle(int degree) {

    }

    public int getTruckBedAngle() {
        return tb.truckBedAngle;
    }

    public void raiseTruckBed(int degree) {
        tb.raiseTruckBed(70, this);
    }

    public void lowerTruckBed(int degree) {
        tb.lowerTruckBed(70, this);
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
