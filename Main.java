import java.awt.*;

public class Main {

    static public void main (String[] args) {
        Saab95 saab = new Saab95();

        System.out.println(saab.getModelName());
        System.out.println(saab.getCurrentSpeed());
        System.out.println(saab.getNrDoors());
        System.out.println(saab.getColor());
    }
}
