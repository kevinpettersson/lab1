package lab1;

import java.util.ArrayList;


public class Workshop <T extends Car> implements hasPosition {

    private final int capacity;
    private final Point location;
    private ArrayList<String> completedWork;
    private ArrayList<T> currentLoad;


    public Workshop(int capacity, Point location){
         this.capacity = capacity;                  // Total amount of cars the workshop can handle.
         this.completedWork = new ArrayList<>();    // A list to store models we've completed
         this.currentLoad = new ArrayList<>();      // The current cars handled by the workshop.
         this.location = location;                  // The user defines unique location when creating new object.

    }
    public void pickupVehicle(T car) {

        for (int i = 0; i < getCurrentLoad(); i++) {

            //Checks so it's the right car were picking up by comparing model-name.
            if (car.getModelName().equals(this.currentLoad.get(i).getModelName())) {

                //Removes the car from workshop then places the car outside the workshop location
                this.currentLoad.remove(car);
                car.Gps.position.x = this.location.x + 1;
                car.Gps.position.y = this.location.y + 1;
                completedWork.add(car.getModelName());
                return;
            }
        }
        throw new IllegalArgumentException("We dont have any car with given modelname");
    }

    public void leaveVehicle(T car){

        if (currentLoad.size() < capacity && car instanceof T) {
            currentLoad.add(car);
            car.Gps.position.x = this.location.x;
            car.Gps.position.y = this.location.y;
            car.transform.EngineOn = false;
        } else {
            throw new IllegalArgumentException("Can't leave this vehicle here, workshop is full");
        }
    }

    // ---- GETTERS ---- \\

    public double getX(){
        return this.location.getX();
    }
    public double getY(){
        return this.location.getY();
    }
    public ArrayList<String> getCompletedWork(){
        return this.completedWork;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public int getCurrentLoad(){
        return this.currentLoad.size();
    }

}
