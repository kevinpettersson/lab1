package lab2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    private UI ui;
    private Model model;
    private int gasAmount;

    public CarController(UI ui, Model model) {
        this.model = model;
        this.ui = ui;
        this.gasAmount = 0;
    }

    public void actionListeners(){
        // This actionListener is for the gas button only
        ui.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
        ui.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(gasAmount);
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

