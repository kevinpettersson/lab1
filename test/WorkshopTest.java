import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WorkshopTest {

    @Test
    void pickupVehicle() {
        Workshop<Car> carWorkshop = new Workshop<>(10, new Point(0,0));
        Saab95 saab = new Saab95();
        carWorkshop.leaveVehicle(saab);
        carWorkshop.pickupVehicle(saab);
        String str = carWorkshop.getCompletedWork().get(0);

        assertEquals(str, saab.getModelName());

    }

    @Test
    void leaveVehicle() {
        Workshop<Car> carWorkshop = new Workshop<>(10, new Point(0,0));
        Saab95 saab = new Saab95();
        carWorkshop.leaveVehicle(saab);
        assertEquals(carWorkshop.getCurrentLoad(), 1);

    }

    @Test
    void getCompletedWork() {
        ArrayList <String> str = new ArrayList<>();
        str.add("Saab95");

        Workshop<Car> carWorkshop = new Workshop<>(10, new Point(0,0));
        Saab95 saab = new Saab95();
        carWorkshop.leaveVehicle(saab);
        carWorkshop.pickupVehicle(saab);
        assertEquals(str, carWorkshop.getCompletedWork());

    }

    @Test
    void getAcceptableModels() {
    }

    @Test
    void getCapacity() {
    }

    @Test
    void getCurrentLoad() {
    }
}