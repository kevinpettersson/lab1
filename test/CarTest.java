
import org.junit.jupiter.api.Test;

import java.awt.image.ConvolveOp;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move() {
        Saab95 saab = new Saab95();
        saab.transform.currentSpeed = 1;
        saab.move();
        assertEquals(saab.position.getX(), 0);
        assertEquals(saab.position.getY(), 1);
    }

    @Test
    void turnLeft() {

        Saab95 saab = new Saab95();
        saab.turnLeft();
        assertEquals(saab.getDirection(), Direction.WEST);
    }

    @Test
    void turnRight() {
        Saab95 saab = new Saab95();
        saab.turnRight();
        assertEquals(saab.getDirection(), Direction.EAST);
        saab.turnRight();
        assertEquals(saab.getDirection(), Direction.SOUTH);
        saab.turnRight();
        assertEquals(saab.getDirection(), Direction.WEST);
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
        Saab95 solvo = new Saab95();
        solvo.setTurboOff();
        double first = solvo.transform.speedFactor();
        solvo.setTurboOn();
        assertTrue(first < solvo.transform.speedFactor());

        Volvo240 volvo = new Volvo240();
        assertTrue(volvo.transform.speedFactor() < solvo.transform.speedFactor());
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
        double current = saab.transform.getCurrentSpeed();
        saab.transform.gas(0.5);
        assertTrue(current < saab.transform.getEnginepower());
        double neW = saab.transform.getCurrentSpeed();
        saab.transform.gas(0.1);
        assertTrue(saab.transform.getEnginepower() > neW);

    }

    @Test
    void brake() {
        Saab95 saab = new Saab95();
        saab.transform.currentSpeed = 0.5;
        double before = saab.transform.getCurrentSpeed();
        saab.transform.brake(0.2);
        assertTrue(before > saab.transform.getCurrentSpeed());
    }
}