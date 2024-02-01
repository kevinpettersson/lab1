import java.util.ArrayList;


public abstract class Workshop<T extends Car> implements iWorkshop {

    private final int capacity;
    private final Point location;
    private final Object[] acceptableModels;
    private ArrayList<String> completedWork;
    private ArrayList<Car> currentLoad;


    Workshop(int capacity, Object[] acceptableModels, Point location){
         this.capacity = capacity;                  // Total amount of cars the workshop can handle.
         this.completedWork = new ArrayList<>();    // A list to store models we've completed
         this.acceptableModels = acceptableModels;  // The acceptable car models.
         this.currentLoad = new ArrayList<Car>();   // The current cars handled by the workshop.
         this.location = location;                  // The user defines unique location when creating new object.

    }

    public void pickupVehicle(Car car) {

        for (int i = 0; i < getCurrentLoad(); i++) {

            //Checks so it's the right car were picking up by comparing model-name.
            if (car.getModelName().equals(this.currentLoad.get(i).getModelName())) {

                //Removes the car from current load then places the car outside the workshop location.
                this.currentLoad.remove(car);
                car.position.x = this.location.x + 1;
                car.position.y = this.location.y + 1;
                this.completedWork.add(car.getModelName());
                return;
            }
        }
    }

    public void leaveVehicle(Car car){

        //Checks so we won't go over max capacity.
        if (!(getCurrentLoad() >= getCapacity())){
            for (int i = 0; i < getAcceptableModels().length; i++) {

                //Checks so the car is an instance of acceptable models, then adds the car to the workshop's current load and moves the vehicle inside
                if (acceptableModels[i].equals(car.getModelName())) {
                    this.currentLoad.add(car);
                    car.position.x = this.location.x;
                    car.position.y = this.location.y;
                    return;
                }
            }
        }
    }

    // ---- GETTERS ---- \\

    public Object[] getAcceptableModels(){
        return this.acceptableModels;
    }
    public int getCapacity(){
        return this.capacity;
    }

    public int getCurrentLoad(){
        return this.currentLoad.size();
    }


}

