package lab1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void setPos() {
        Saab95 saab = new Saab95();
        saab.position.setPos(2,4);
        assertEquals(saab.position.getX(), 2);
        assertEquals(saab.position.getY(), 4);

    }

    @Test
    void getX() {
        Saab95 saab = new Saab95();
        assertEquals(saab.position.getX(), 0);
        saab.turnRight();
        saab.transform.currentSpeed = 1;
        saab.move();
        assertEquals(saab.position.getX(), 1);


    }

    @Test
    void getY() {
        Saab95 saab = new Saab95();
        assertEquals(saab.position.getY(), 0);
    }

    @Test
    void testToString() {
    }
}