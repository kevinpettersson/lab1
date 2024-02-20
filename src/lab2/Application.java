package lab2;
import lab1.*;

import javax.swing.*;
import java.util.ArrayList;


public class Application {

    static ArrayList<Car> cars = CarController.getCars();
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
    cc.frame = new UI("Vroom Vroom Car go Zoom Zoom", cc);

    // Start the timer
    //cc.timer.start();
}


}
