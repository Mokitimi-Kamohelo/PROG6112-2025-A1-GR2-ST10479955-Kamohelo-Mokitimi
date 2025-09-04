/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package racebusiness;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RacingBusinessTest {

    @Test
    void addEntitiesAndReport() {
        RacingBusiness RB = new RacingBusiness(2, 2, 1);
        assertTrue(RB.addCar(new CupCar("C1", "Porsche", 310, true)));
        assertTrue(RB.addCar(new RallyCar("C2", "Mitsubishi", 270, 85)));
        assertFalse(RB.addCar(new FormulaCar("C3", "Extra", 340, 90)));

        assertTrue(RB.addDriver(new Driver("D1", "Sam Speed", "Professional")));
        assertTrue(RB.addDriver(new Driver("D2", "Jill Drift", "Expert")));
        assertFalse(RB.addDriver(new Driver("D3", "Extra", "Rookie")));

        Car[] cars = RB.getCarsSnapshot();
        Driver[] drivers = RB.getDriversSnapshot();
        assertEquals(2, cars.length);
        assertEquals(2, drivers.length);

        Race r = new Race("Short Race", new Car[]{cars[0]}, new Driver[]{drivers[0]}, 2);
        assertTrue(RB.addRace(r));
        assertFalse(RB.addRace(r));

        String report = RB.businessReport();
        assertTrue(report.contains("Cars (2):"));
        assertTrue(report.contains("Drivers (2):"));
        assertTrue(report.contains("Races (1):"));
    }

    @Test
    void carValidation() {
        assertThrows(IllegalArgumentException.class, () -> new CupCar("", "Brand", 300, true));
        assertThrows(IllegalArgumentException.class, () -> new CupCar("X", "", 300, true));
        assertThrows(IllegalArgumentException.class, () -> new CupCar("X", "Brand", 0, true));
    }
}

