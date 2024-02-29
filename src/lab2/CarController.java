package lab2;

import lab1.Car;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ChangeListener;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements Observerables{
    private UI ui;
    private Model model;
    private Buttons buttons;
    private int gasAmount;
    ArrayList<Observer> obs;

    public CarController(UI ui, Model model) {
        this.model = model;
        this.ui = ui;
        this.buttons = ui.getButtons();
        this.gasAmount = 0;
        this.obs = new ArrayList<>();
    }

    public void notifyOb(int x, int gasAmount) {
        for(Observer ob : obs){
            ob.update(x, gasAmount);
        }
    }
    public void addObserver(Observer ob) {
        obs.add(ob);
    }
    public void removeObserver(Observer ob) {
        obs.remove(ob);
    }

    public void actionListeners(){
        // This actionListener is for the gas button only
        ui.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
        buttons.getAddCar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {notifyOb(1,0);
            }
        });
        buttons.getRemoveCar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyOb(2,0 );
            }
        });
        buttons.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyOb(3, gasAmount);
            }
        });
        buttons.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyOb(4, gasAmount);
            }
        });

        buttons.getTurboOnButton().addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyOb(5,0);
            }
        }));
        buttons.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyOb(6,0);
            }
        });

        // START AND STOP-BUTTON
        buttons.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyOb(7,0);
            }
        });
        buttons.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyOb(8,0);
            }
        });

        // LIFT AND LOWER BED-BUTTON
        buttons.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyOb(9,0);
            }
        });
        buttons.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyOb(10,0);
            }
        });
    }
}

