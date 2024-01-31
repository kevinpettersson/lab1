public class Volvo240Workshop extends Workshop<Volvo240> {


    Volvo240Workshop(int capacity, Object[] acceptableModels, Point location) {
        super(10, Volvo240, new Point(0,0));
    }

    @Override
    public void pickupVehicle() {

    }

    @Override
    public int leaveVehicle() {
        return 0;
    }
}
