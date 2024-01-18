import java.awt.*;

public class Main {

    static public void main (String[] args) {
        Saab95 saab = new Saab95(3,125, 10, Color.blue, "bajs");

        System.out.println(saab.getModelName());
        System.out.println(saab.getCurrentSpeed());
        System.out.println(saab.getNrDoors());
        System.out.println(saab.getColor());
    }
}
