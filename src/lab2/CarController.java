package lab2;
import lab1.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    //A list of cars, modify if needed
    static ArrayList<Car> cars = new ArrayList<>(); // Gjorde den statisk

    //methods:
    public static ArrayList<Car> getCars(){ // gjorde den statisk
        return cars;
    }

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        Scania scania = new Scania();
        volvo240.setPos(0,200);
        saab95.setPos(0,0);
        scania.setPos(0,100);
        volvo240.setDirection(Direction.EAST);
        saab95.setDirection(Direction.EAST);
        scania.setDirection(Direction.EAST);

        cars.add(volvo240);
        cars.add(saab95);
        cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("Vroom Vroom Car go Zoom Zoom", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                adjustCarPosition(x, y, car);
            }
            ifCarCollideWithWorkshop();
            handleCollition();

        }
    }
    //When the the "behind" vehicle collides with the vehicle in front, the approaching vehicle will "crash" and move
    public void handleCollition(){
        for (int i = 0; i < cars.size()-1; i++) {
            for (int j = i+1; j < cars.size(); j++) {
                Car car1 = cars.get(i);
                Car car2 = cars.get(j);
                if (collition(car1, car2)){
                    car1.setPos(car1.getX() + 2, car1.getY() + 2);
                    car1.stopEngine();
                    car2.stopEngine();
                }
            }
        }
    }
    //Checks potential collition between two cars. Returns a boolean.
    public boolean collition(Car carA, Car carB) {
        for (int i = 0; i < cars.size() - 1; i++) {
            for (int j = i + 1; j < cars.size(); j++) {
                if (carA.getY() < (carB.getY() + 60) && (carA.getY() > (carB.getY() - 60))){
                    if (carA.getX() > (carB.getX() - 100) && (carA.getX() < (carB.getX() + 100))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // If the car collides with the workshop then we remove the car from the list and adds the car to the workshop.
    public void ifCarCollideWithWorkshop(){
        Workshop<Volvo240> volvoWorkshop = frame.drawPanel.volvo240Workshop;
        Volvo240 volvo = new Volvo240();
        for (Car car : cars){
            if (car instanceof Volvo240){
                volvo = (Volvo240) car;
            }
        }
        if ((int) volvo.getY() >= (int) volvoWorkshop.getY() && volvo.getX() >= volvoWorkshop.getX()) {
            cars.remove(volvo);
            volvoWorkshop.leaveVehicle(volvo);
        }
    }

    // Checks so the car is within bounds of the frame. If not we stop the car, turn it 180 degress.
    // Sets a new position that is within bounds.
    public void adjustCarPosition(int cX, int cY, Car car) {
        if (cY <= -1 || cY >= 501) {
            car.stopEngine();
            car.turnLeft();
            car.turnLeft();
            car.setY(cY >= 500 ? 500 - 2 : 2);
        }

        if (cX <= -1 || cX >= 701) {
            car.stopEngine();
            car.turnLeft();
            car.turnLeft();
            car.setX(cX <= 0 ? 2 : 700 - 2);
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars){
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars){
            car.brake(brake);
        }
    }
    void saabTurboOn(){
        for (int i = 0; i < cars.size(); i++){
            if (cars.get(i) instanceof Saab95){
                ((Saab95) cars.get(i)).setTurboOn();
            }
        }
    }
    void saabTurboOff(){
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i) instanceof Saab95){
                ((Saab95) cars.get(i)).setTurboOff();
            }
        }
    }
    void stopEngineAll(){
        for (Car car : cars){
            car.stopEngine();
        }
    }
    void startEngineAll(){
        for (Car car : cars){
            car.startEngine();
        }
    }
    void liftAllBeds(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania) car).raiseTruckBed(70);
            }
            if (car instanceof CarTransport){
                ((CarTransport) car).raiseTruckBed(70);
            }
        }
    }
    void lowerAllBeds(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania) car).lowerTruckBed(70);
            }
            if (car instanceof CarTransport){
                ((CarTransport) car).lowerTruckBed(70);
            }
        }
    }
}

