import lab1.*;
import org.junit.jupiter.api.Test;
import java.awt.image.ConvolveOp;

/*
To potential TA who reveiw's our progress!
We have gone through our test and our code works! However when packaging our code from lab one we couldn't reach the variables needed.
We indend to ask about this next time we have a lab.
*/
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move() {
        Saab95 saab = new Saab95();
        saab.setCurrentSpeed(1);
        saab.move();
        assertEquals(saab.getPosX(), 0);
        assertEquals(saab.getPosY(), 1);
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
        double first = solvo.getSpeedFactor();
        solvo.setTurboOn();
        assertTrue(first < solvo.getSpeedFactor());

        Volvo240 volvo = new Volvo240();
        assertTrue(volvo.getSpeedFactor() < solvo.getSpeedFactor());
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
        saab.setGas(0.5);
        assertTrue(current < saab.getEnginepower());
        double neW = saab.getCurrentSpeed();
        saab.setGas(0.1);
        assertTrue(saab.getEnginepower() > neW);

    }

    @Test
    void brake() {
        Saab95 saab = new Saab95();
        saab.setCurrentSpeed(0.5);
        double before = saab.getCurrentSpeed();
        saab.setBrake(0.2);
        assertTrue(before > saab.getCurrentSpeed());
    }
}