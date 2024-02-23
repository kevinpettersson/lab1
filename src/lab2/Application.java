package lab2;
import lab1.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Application {

    CarController cc = new CarController();
    UI frame;
    static ArrayList<Car> cars = new ArrayList<>();

    public static ArrayList<Car> getCars(){
        return cars;
    }
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    static Workshop<Volvo240> volvo240Workshop = new Workshop<>(10, new Point(300,200));
    public static void main(String[] args) {
        // Instance of this class
        //CarController cc = new CarController(new UI("BrumBrum"));
        Application app = new Application();
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
        app.frame = new UI("Vroom Vroom Car go Zoom Zoom");

        // Start the timer
        app.timer.start();
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
                cc.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                cc.adjustCarPosition(x, y, car);
            }
            cc.ifCarCollideWithWorkshop();
            cc.handleCollition();

        }
    }




}
