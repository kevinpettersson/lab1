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
        volvo240.setPos(300,0);
        saab95.setPos(0,100);
        scania.setPos(0,200);
        //volvo240.setDirection(Direction.EAST);

        cars.add(volvo240);
        cars.add(saab95); // oklart om detta är rätt.
        cars.add(scania); // oklart om  detta är rätt.

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
                adjustCarPosition( x, y, car);
            }
            ifCarCollideWithWorkshop();
            for (int i = 0; i < cars.size(); i++) {
                for (int j = i+1; j < cars.size()-1; j++) {
                    if ((int) cars.get(i).getY() == (int) cars.get(j).getY()){
                        cars.get(i).stopEngine();
                        cars.get(j).stopEngine();
                    }
                }
            }
        }
    }
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
    public void adjustCarPosition(int cX, int cY, Car car) {
        if (cY == -1 || cY >= 501) {
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

