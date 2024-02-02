import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    @Test
    void getTruckBedAngle() {

    }

    @Test
    void riseTruckbed() {
        Scania scania = new Scania();
        scania.currentSpeed = 0;
        scania.truckBedAngle = 60;
        scania.riseTruckbed(20);
        assertTrue(scania.getTruckBedAngle() == 40);
    }

    @Test
    void lowerTruckbed() {
        Scania scania = new Scania();
        scania.currentSpeed = 0;
        scania.truckBedAngle = 60;
        scania.lowerTruckbed(70);
        assertTrue(scania.getTruckBedAngle() == 70);
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
}