import java.awt.*;
import java.util.Arrays;

public class Main {

    static public void main (String[] args) {
        Saab95 saab = new Saab95();
        saab.currentSpeed = 2;
        System.out.println(saab.currentSpeed);
        System.out.println(saab.heading);
        System.out.println(Arrays.toString(saab.position));
        saab.move();
        System.out.println(Arrays.toString(saab.position));
        saab.turnLeft(270);
        saab.move();
        System.out.println(Arrays.toString(saab.position));

    }
}
