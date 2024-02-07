import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import lab1.*;
class ScaniaTest {

    @Test
    void getTruckBedAngle() {

    }



    @Test
    void raiseTruckbed() {
        Scania scania = new Scania();
        scania.transform.currentSpeed = 0;
        scania.setTruckBedAngle(60);
        scania.raiseTruckBed(20);
        assertTrue(scania.getTruckBedAngle() == 40);
    }

    @Test
    void lowerTruckbed() {
        Scania scania = new Scania();
        scania.transform.currentSpeed = 0;
        scania.setTruckBedAngle(60);
        scania.lowerTruckBed(70);
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