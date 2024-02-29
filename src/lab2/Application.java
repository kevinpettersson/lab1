package lab2;
import lab1.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Application{

    private final CarController cc;
    private final  UI ui;
    private final Model model;
    private ArrayList<Car> cars;
    // each step between delays.
    private final int delay;
    private final Timer timer;


    public Application(){
        this.model = new Model();
        this.ui = new UI("Fast af", model);
        this.cc = new CarController(ui, model);
        this.cars = model.getCars();
        // The delay (ms) corresponds to 20 updates a sec (hz)
        this.delay = 50;
        // The timer is started with a listener (see below) that executes the statements
        this.timer = new Timer(delay, new TimerListener());
    }

    public static void main(String[] args) {
        // Instance of this class
        Application app = new Application();
        app.cc.obs.add(app.model);

        // Start the action listeners.
        app.cc.actionListeners();

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
                model.moveit(x, y, car);

                model.adjustCarPosition(x, y, car);
            }
            model.ifCarCollideWithWorkshop();
            model.handleCollition();
            // repaint() calls the paintComponent method of the panel
            ui.getDrawPanel().repaint();

        }
    }
}