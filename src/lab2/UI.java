package lab2;

import lab1.*;
import javax.swing.*;
import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class UI extends JFrame{
    private final DrawPanel drawPanel;
    private final JPanel controlPanel;
    private final JPanel gasPanel;
    private final Buttons buttons;
    protected JSpinner gasSpinner;

    private final int X = 800;
    private final int Y = 800;

    public UI (String framename, Model model){
        this.drawPanel = new DrawPanel(X, Y-240, model);
        this.controlPanel = new JPanel();
        this.gasPanel = new JPanel();
        this.gasSpinner = new JSpinner();
        this.buttons = new Buttons();
        initComponents(framename);
    }
    public Buttons getButtons(){
        return this.buttons;
    }
    public DrawPanel getDrawPanel(){
        return this.drawPanel;
    }

    public void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);

        this.gasPanel.setLayout(new BorderLayout());
        this.gasPanel.add(buttons.getGasLabel(), BorderLayout.PAGE_START);
        this.gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.add(buttons.getGasButton(), 0);
        controlPanel.add(buttons.getTurboOnButton(),1);
        controlPanel.add(buttons.getLiftBedButton(), 2);
        controlPanel.add(buttons.getBrakeButton(), 3);
        JButton turboOffButton = buttons.getTurboOffButton();
        turboOffButton.setFont(new Font("Arial", Font.PLAIN, 12)); // Så texten rymms inom panelen.
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(buttons.getLowerBedButton(), 5);
        controlPanel.add(buttons.getAddCar(), 6);
        controlPanel.add(buttons.getRemoveCar(), 7);
        controlPanel.setPreferredSize(new Dimension(X/2, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        buttons.getStartButton().setBackground(Color.blue);
        buttons.getStartButton().setForeground(Color.green);
        buttons.getStartButton().setPreferredSize(new Dimension(X/5-15,200));
        this.add(buttons.getStartButton());

        buttons.getStopButton().setBackground(Color.red);
        buttons.getStopButton().setForeground(Color.black);
        buttons.getStopButton().setPreferredSize(new Dimension(X/5-15,200));
        this.add(buttons.getStopButton());

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
