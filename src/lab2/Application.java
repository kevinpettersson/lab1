package lab2;
import lab1.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Application implements Observerables{

    private final CarController cc;
    private final  UI ui;
    private final Model model;
    private ArrayList<Car> cars;

    private final Timer timer;
    ArrayList<Observer> obs;


    public Application(){
        this.model = new Model();
        this.ui = new UI("Fast af", model);
        this.cc = new CarController(ui, model);
        this.cars = model.getCars();
        // The timer is started with a listener (see below) that executes the statements
        this.timer = new Timer(model.getDelay(), new TimerListener());
        this.obs = new ArrayList<>();
    }

    public static void main(String[] args) {
        // Instance of this class
        ArrayList<? super Volvo240> list = new ArrayList<Volvo240>();
        Application app = new Application();
        app.obs.add(app.model);

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
                //model.adjustCarPosition();        notify case 1
                notifyOb(1);
            }
            //model.ifCarCollideWithWorkshop();     notify case 2
            //model.handleCollition();              notify case 3
            notifyOb(2);
            notifyOb(3);
            // repaint() calls the paintComponent method of the panel
            ui.getDrawPanel().repaint();
        }
    }

    public void notifyOb(int x) {
        for(Observer ob : obs){
            ob.update(x);
        }
    }
    public void addObserver(Observer ob) {
        obs.add(ob);
    }
    public void removeObserver(Observer ob) {
        obs.remove(ob);
    }
}