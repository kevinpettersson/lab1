
import org.junit.jupiter.api.Test;

import java.awt.image.ConvolveOp;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move() {
        Saab95 saab = new Saab95();
        saab.currentSpeed = 1;
        saab.move();
        assertEquals(saab.position.x, 0);
        assertEquals(saab.position.y, 1);
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
        Saab95 solvo = new Saab95();
        solvo.setTurboOff();
        double first = solvo.speedFactor();
        solvo.setTurboOn();
        assertTrue(first < solvo.speedFactor());

        Volvo240 volvo = new Volvo240();
        assertTrue(volvo.speedFactor() < solvo.speedFactor());
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
        double current = saab.getCurrentSpeed();
        saab.gas(0.5);
        assertTrue(current < saab.getEnginePower());
        double neW = saab.getCurrentSpeed();
        saab.gas(0.1);
        assertTrue(saab.getEnginePower() > neW);

    }

    @Test
    void brake() {
        Saab95 saab = new Saab95();
        saab.currentSpeed = 0.5;
        double before = saab.getCurrentSpeed();
        saab.brake(0.2);
        assertTrue(before > saab.getCurrentSpeed());
    }
}