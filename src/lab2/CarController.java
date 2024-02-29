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

public class CarController{
    private UI ui;
    private Model model;
    private Buttons buttons;
    private int gasAmount;


    public CarController(UI ui, Model model) {
        this.model = model;
        this.ui = ui;
        this.buttons = ui.getButtons();
        this.gasAmount = 0;

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
            public void actionPerformed(ActionEvent e) {
                model.addCar();
            }
        });
        buttons.getRemoveCar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeCar();
            }
        });
        buttons.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(gasAmount);
            }
        });
        buttons.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(gasAmount);
            }
        });

        buttons.getTurboOnButton().addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.saabTurboOn();
            }
        }));
        buttons.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.saabTurboOff();
            }
        });

        // START AND STOP-BUTTON
        buttons.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startEngineAll();
            }
        });
        buttons.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopEngineAll();
            }
        });

        // LIFT AND LOWER BED-BUTTON
        buttons.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.liftAllBeds();
            }
        });
        buttons.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerAllBeds();
            }
        });
    }
}

