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
    private final Model model;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, Model model) {
        this.model = model;
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
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Car car : model.getCars()) {
            if (car instanceof Volvo240) {
                g.drawImage(volvoImage, (int) Math.round(car.getX()), (int) Math.round(car.getY()), null);
            }
            if (car instanceof Saab95) {
                g.drawImage(saabImage, (int) Math.round(car.getX()), (int) Math.round(car.getY()), null);
            }
            if (car instanceof Scania) {
                g.drawImage(scaniaImage, (int) Math.round(car.getX()), (int) Math.round(car.getY()), null);
            }
            if (car instanceof CarTransport){
                g.drawImage(scaniaImage, (int) Math.round(car.getX()), (int) Math.round(car.getY()), null);
            }
        }
         // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, (int) model.getWorkshop().getX(), (int) model.getWorkshop().getY(), null);
    }
}
