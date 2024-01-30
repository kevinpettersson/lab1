import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest {

    @Test
    void TestTruckLoadPositionChangeAfterMoveCall() {
        Saab95 saab = new Saab95();
        CarTransport truck = new CarTransport();

        truck.currentSpeed = 0;
        truck.lowerTruckBed();
        truck.loadTruck(saab);
        truck.currentSpeed = 1;
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
    }

    @Test
    void unloadTruck() {
    }

    @Test
    void lowerTruckBed() {
    }

    @Test
    void riseTruckBed() {
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