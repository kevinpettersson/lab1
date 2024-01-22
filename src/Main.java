
public class Main {

    static public void main (String[] args) {
        Saab95 saab = new Saab95();
        saab.currentSpeed = 1;
       System.out.println(saab.position);
       saab.move();
        System.out.println(saab.position);
        saab.turnLeft();
        saab.move();
        System.out.println(saab.position);



    }
}
