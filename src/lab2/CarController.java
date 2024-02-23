package lab2;
import lab1.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController extends JFrame{
    UI ui;
    Model model = new Model();
    ArrayList<Car> cars = Application.getCars();
    int gasAmount = 0;
    JSpinner gasSpinner;
    public CarController(UI ui) {
        this.ui = ui;
        //gasAmount = gasAmount;
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
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
    //Rewritten with a hasPosition interface as typearguments. To generalize the method.

    public boolean collition(hasPosition objA, hasPosition objB) {
        if (objA.getY() < (objB.getY() + 60) && (objA.getY() > (objB.getY() - 60))){
            if (objA.getX() > (objB.getX() - 100) && (objA.getX() < (objB.getX() + 100))){
                return true;
            }
        }
        return false;
    }

    // If the car collides with the workshop then we remove the car from the list and adds the car to the workshop.

    public void ifCarCollideWithWorkshop(){
        Volvo240 volvo = new Volvo240();
        for (Car car : cars) {
            if (car instanceof Volvo240) {
                volvo = (Volvo240) car;
            }
        }
        if (collition(volvo, Application.volvo240Workshop)) {
            cars.remove(volvo);
            Application.volvo240Workshop.leaveVehicle(volvo);
            System.out.println("Left 1 vehicle");
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
    public void actionListeners(){
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary

        ui.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(gasAmount);
                System.out.println("JAG GASAR KEVIN SLUTA SPAMMA");
            }
        });
        ui.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(gasAmount);
            }
        });

        ui.turboOnButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.saabTurboOn();
            }
        }));
        ui.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.saabTurboOff();
            }
        });

        // START AND STOP-BUTTON
        ui.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startEngineAll();
            }
        });
        ui.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopEngineAll();
            }
        });

        // LIFT AND LOWER BED-BUTTON
        ui.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.liftAllBeds();
            }
        });
        ui.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerAllBeds();
            }
        });
    }

}

