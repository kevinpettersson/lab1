import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest {

    @Test
    void TestTruckLoadPositionChangeAfterMoveCall() {
        Saab95 saab = new Saab95();
        CarTransport truck = new CarTransport();

        truck.transform.currentSpeed = 0;
        truck.lowerTruckBed(70);
        truck.loadTruck(saab);
        truck.transform.currentSpeed = 1;
        truck.move();

        Point carPos = truck.truckLoad.peek().position;
        Point truckPos = truck.position;

        assertEquals(truckPos.getY(), carPos.getY());
        assertEquals(truckPos.getX(), carPos.getX());
    }

    @Test
    void truckLoadPos() {
    }

    @Test
    void loadTruck() {
        CarTransport ct = new CarTransport();
        ct.transform.currentSpeed = 0;
        ct.lowerTruckBed(70);
        Saab95 saab = new Saab95();

        ct.loadTruck(saab);

        assertEquals(ct.truckLoad.peek(), saab);

    }

    @Test
    void unloadTruck() {
        CarTransport ct = new CarTransport();
        ct.transform.currentSpeed = 0;
        ct.lowerTruckBed(70);
        Saab95 saab = new Saab95();

        ct.loadTruck(saab);

        ct.unloadTruck();


        assertEquals(saab.position.x, 1);
        assertEquals(saab.position.y, 1);
    }

    @Test
    void lowerTruckBed() {
        CarTransport ct = new CarTransport();
        ct.transform.currentSpeed = 0;
        ct.lowerTruckBed(70);
        assertTrue(ct.getTruckBedAngle() == 70);
    }

    @Test
    void riseTruckBed() {
        CarTransport ct = new CarTransport();
        ct.transform.currentSpeed = 0;

        ct.raiseTruckBed(86);
        assertTrue(ct.getTruckBedAngle() == 0);
    }

    @Test
    void speedFactor() {
    }

    @Test
    void incrementSpeed() {
        CarTransport ct = new CarTransport();
        ct.transform.currentSpeed = 0;
        ct.lowerTruckBed(70);
        double before = ct.transform.getCurrentSpeed();
        ct.transform.incrementSpeed(2);
        double after = ct.transform.getCurrentSpeed();
        assertEquals(before, after);

    }

    @Test
    void decrementSpeed() {
        CarTransport ct = new CarTransport();
        ct.transform.currentSpeed = 0;
        ct.lowerTruckBed(70);
        ct.raiseTruckBed(30);
        double before = ct.transform.getCurrentSpeed();
        ct.transform.incrementSpeed(2);
        double after = ct.transform.getCurrentSpeed();
        assertTrue(before < after);
    }
}