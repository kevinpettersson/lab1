package lab2;

import lab1.Car;
import lab1.CarTransport;

import javax.swing.*;
import java.util.Stack;

public class Buttons {
    private final JLabel gasLabel;
    private final JButton gasButton;
    private final JButton brakeButton;
    private final JButton turboOnButton;
    private final JButton turboOffButton;
    private final JButton liftBedButton;
    private final JButton lowerBedButton;
    private final JButton startButton;
    private final JButton stopButton;
    private final JButton addCar;
    private final JButton removeCar;

    public Buttons(){

        this.gasLabel = new JLabel("Amount of gas");
        this.gasButton = new JButton("Gas");
        this.brakeButton = new JButton("Brake");
        this.turboOnButton = new JButton("Saab Turbo on");
        this.turboOffButton = new JButton("Saab Turbo off");
        this.liftBedButton = new JButton("Lift Bed");
        this.lowerBedButton = new JButton("Lower Bed");
        this.startButton = new JButton("Start all cars");
        this.stopButton = new JButton("Stop all cars");
        this.addCar = new JButton("Add car");
        this.removeCar = new JButton("Remove car");
    }
    public JButton getAddCar(){
        return this.addCar;
    }
    public JButton getRemoveCar(){
        return this.removeCar;
    }
    public JLabel getGasLabel(){
        return this.gasLabel;
    }
    public JButton getGasButton(){
        return this.gasButton;
    }
    public JButton getBrakeButton(){
        return this.brakeButton;
    }
    public JButton getTurboOnButton(){
        return this.turboOnButton;
    }
    public JButton getTurboOffButton(){
        return this.turboOffButton;
    }
    public JButton getStopButton(){
        return this.stopButton;
    }
    public JButton getStartButton(){
        return this.startButton;
    }
    public JButton getLowerBedButton(){
        return this.lowerBedButton;
    }
    public JButton getLiftBedButton(){
        return this.liftBedButton;
    }
}
