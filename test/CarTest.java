
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move() {
        Saab95 saab = new Saab95();
        saab.move();
        assertEquals(saab.position.x, 0);
        assertNotEquals(saab.position.y, 0);
    }

    @Test
    void turnLeft() {

        Saab95 saab = new Saab95();
        saab.turnLeft();
        assertEquals(saab.direction, Direction.WEST);
    }

    @Test
    void turnRight() {
        Saab95 saab = new Saab95();
        saab.turnRight();
        assertEquals(saab.direction, Direction.EAST);
    }

    @Test
    void getModelName() {
    }

    @Test
    void getNrDoors() {
    }

    @Test
    void getEnginePower() {
    }

    @Test
    void getCurrentSpeed() {
    }

    @Test
    void getColor() {
    }

    @Test
    void setColor() {
    }

    @Test
    void startEngine() {
    }

    @Test
    void stopEngine() {
    }

    @Test
    void speedFactor() {
    }

    @Test
    void incrementSpeed() {
    }

    @Test
    void decrementSpeed() {
    }

    @Test
    void gas() {
        Saab95 saab = new Saab95();
        double current = saab.currentSpeed;
        saab.gas(0.5);
        assertTrue(current < saab.currentSpeed);
    }

    @Test
    void brake() {
        Saab95 saab = new Saab95();
        saab.currentSpeed = 0.5;
        double before = saab.currentSpeed;
        saab.brake(0.2);
        assertTrue(before > saab.currentSpeed);
    }
}