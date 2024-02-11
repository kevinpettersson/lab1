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
        saab95.setPos(100,100);
        scania.setPos(200,200);

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
                double cX = car.getX();
                double cY = car.getY();
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y, car);

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                if(cY == 0 || cY == 500){
                    car.stopEngine();
                    car.turnLeft();
                    car.turnLeft();
                }
                if (cY >= 500){
                    car.setY(cY - 1);
                }
                if (cY <= 0){
                    car.setY(cY + 1);
                }
            }
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
}
