package lab2;

import lab1.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class UI extends JFrame{
    private Model model;
    private DrawPanel drawPanel;
    private JPanel controlPanel;
    private JPanel gasPanel;
    JSpinner gasSpinner;
    JLabel gasLabel;
    JButton gasButton;
    JButton brakeButton;
    JButton turboOnButton;
    JButton turboOffButton;
    JButton liftBedButton;
    JButton lowerBedButton;
    JButton startButton;
    JButton stopButton;

    private final int X = 800;
    private final int Y = 800;

    public UI (String framename, Model model){
        this.model = model;
        this.drawPanel = new DrawPanel(X, Y-240, this.model);
        this.controlPanel = new JPanel();
        this.gasPanel = new JPanel();
        this.gasSpinner = new JSpinner();
        this.gasLabel = new JLabel("Amount of gas");
        this.gasButton = new JButton("Gas");
        this.brakeButton = new JButton("Brake");
        this.turboOnButton = new JButton("Saab Turbo on");
        this.turboOffButton = new JButton("Saab Turbo off");
        this.liftBedButton = new JButton("Scania Lift Bed");
        this.lowerBedButton = new JButton("Lower Lift Bed");
        this.startButton = new JButton("Start all cars");
        this.stopButton = new JButton("Stop all cars");
        initComponents(framename);
    }

    public DrawPanel getDrawPanel(){
        return this.drawPanel;
    }

    public void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);
/*
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

 */

        this.gasPanel.setLayout(new BorderLayout());
        this.gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        this.gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
