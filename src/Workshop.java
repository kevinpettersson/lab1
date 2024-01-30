import java.util.ArrayList;


public abstract class Workshop implements iWorkshop {

    private final int CAPACITY;
    private ArrayList<String> CompletedWork;
    private final String[] AcceptableModels;
    private ArrayList<Car> CurrentLoad;

    public Workshop(int CAPACITY, String[] AcceptableModels){
         this.CAPACITY = CAPACITY;
         this.CompletedWork = new ArrayList<>();
         this.AcceptableModels = AcceptableModels;
         this.CurrentLoad = new ArrayList<Car>();

    }
    public void pickupVehicle(Car car) {
        if (getCurrentLoad() < this.CAPACITY) {
            for (int i = 0; i < getCurrentLoad(); i++) {
                if (car.getModelName().equals(this.CurrentLoad.get(i).getModelName())) {
                    this.CurrentLoad.remove(car);
                    this.CompletedWork.add(car.getModelName());
                    return;
                }
            }
        }
    }

    public void leaveVehicle() {

    }

    public int getCurrentLoad(){
        return this.CurrentLoad.size();
    }

}
