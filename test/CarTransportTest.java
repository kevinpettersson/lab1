import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest {

    @Test
    void move() {
        Saab95 saab = new Saab95();
        CarTransport truck = new CarTransport();
        truck.loadTruck(saab);
        truck.move();
        assertEquals(truck.truckLoad.peek().position.getX(), truck.position.getY());
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