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
    CarController cc = new CarController(); // SKA ÄNDRAS !!!!!!!!!!!!!!!!!
    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    // To keep track of a single car's position
    //Point volvoPoint = new Point();
    //Point scaniaPoint = new Point(100,100);
    //Point saabPoint = new Point(200,200);

    BufferedImage volvoWorkshopImage;
    Workshop<Volvo240> volvo240Workshop = new Workshop<>(10, new Point(300,300));
    //Point volvoWorkshopPoint = new Point (300,300);
    //CarController cc = cc.getCC();

    // TODO: Make this general for all cars
    void moveit(int x, int y, Car car){

        for (Car c : cc.cars) {
            c.setX(x);
            c.setY(y);
        }

        //volvoPoint.x = x;
        //volvoPoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cc.cars) {
            if (car instanceof Volvo240) {
                g.drawImage(volvoImage, (int) car.getX(), (int) car.getY(), null);
            }
            if (car instanceof Saab95) {
                g.drawImage(saabImage, (int) car.getX(), (int) car.getY(), null);
            }
            if (car instanceof Scania) {
                g.drawImage(scaniaImage, (int) car.getX(), (int) car.getY(), null);
            }
        }
         // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, (int) volvo240Workshop.getX(), (int) volvo240Workshop.getY(), null);
    }
}
