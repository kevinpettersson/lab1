package lab2;

import lab1.*;
import lab1.Point;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    // Just a single image
    private BufferedImage volvoImage;
    private BufferedImage scaniaImage;
    private BufferedImage saabImage;
    private BufferedImage volvoWorkshopImage;
    private BufferedImage backgroundImage;
    private final Model model;
    private ArrayList<Car> cars;
    //Image Background = Toolkit.getDefaultToolkit().createImage("pics/Background.png");
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, Model model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        //this.setBackground(Color.green); Kommenterade ut detta när jag implmenterade en ny bakgrund
        this.cars = model.getCars();

        //Static pictures that will never change here please :)
        try {
            /*
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            */
            backgroundImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Background.png"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/volvoWorkshop.png"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    //Implementing the right images based on the direction of each car - One switch case for each model
    public BufferedImage getSaabImage(Car saab95) {
        try {
        switch (cars.get(cars.indexOf(saab95)).getDirection()) {
            case NORTH:
                saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95/Saab95_North.png"));
                break;
            case EAST:
                saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95/Saab95_East.png"));
                break;
            case SOUTH:
                saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95/Saab95_South.png"));
                break;
            case WEST:
                saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95/Saab95_West.png"));
                break;
        }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return saabImage;
    }

    public BufferedImage getVolvoImage(Car volvo240) {
        try {
            switch (cars.get(cars.indexOf(volvo240)).getDirection()) {
                case NORTH:
                    volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240/Volvo_North.png"));
                    break;
                case EAST:
                    volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240/Volvo_East.png"));
                    break;
                case SOUTH:
                    volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240/Volvo_South.png"));
                    break;
                case WEST:
                    volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240/Volvo_West.png"));
                    break;
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return volvoImage;
    }

    public BufferedImage getScaniaImage(Car scania) {
        try {
            switch (cars.get(cars.indexOf(scania)).getDirection()) {
                case NORTH:
                    scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania/Scania_North.png"));
                    break;
                case EAST:
                    scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania/Scania_East.png"));
                    break;
                case SOUTH:
                    scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania/Scania_South.png"));
                    break;
                case WEST:
                    scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania/Scania_West.png"));
                    break;
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return scaniaImage;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Draws the background b4 the cars, so its behind them.
        g.drawImage(backgroundImage, 0, 0, null);

        for (Car car : model.getCars()) {
            if (car instanceof Volvo240) {
                g.drawImage(getVolvoImage(car), (int) Math.round(car.getX()), (int) Math.round(car.getY()), null);
            }
            if (car instanceof Saab95) {
                g.drawImage(getSaabImage(car), (int) Math.round(car.getX()), (int) Math.round(car.getY()), null);
            }
            if (car instanceof Scania) {
                g.drawImage(getScaniaImage(car), (int) Math.round(car.getX()), (int) Math.round(car.getY()), null);
            }
            if (car instanceof CarTransport){
                g.drawImage(getScaniaImage(car), (int) Math.round(car.getX()), (int) Math.round(car.getY()), null);
            }
        }
         // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, (int) model.getWorkshop().getX(), (int) model.getWorkshop().getY(), null);
    }
}
