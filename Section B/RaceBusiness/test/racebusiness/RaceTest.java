/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package racebusiness;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {

    @Test
    void averageAndWinnerWork() {
        Car c1 = new CupCar("C1", "BMW", 320, true);
        Car c2 = new FormulaCar("C2", "Audi", 350, 90);

        Driver d1 = new Driver("D1", "Driver1", "Pro");
        Driver d2 = new Driver("D2", "Driver2", "Pro");

        Race race = new Race("Test Race", new Car[]{c1, c2}, new Driver[]{d1, d2}, 3);
        // Ferrari laps
        race.recordLapTime(0, 0, 70);
        race.recordLapTime(0, 1, 69);
        race.recordLapTime(0, 2, 68);
        race.recordLapTime(1, 0, 69.5);
        race.recordLapTime(1, 1, 68.5);
        race.recordLapTime(1, 2, 67.5);

        double[] avgs = race.averageLapTimes();
        assertEquals(69.0, avgs[0], 1e-6);
        assertEquals((69.5 + 68.5 + 67.5) / 3.0, avgs[1], 1e-6);

        int winnerIdx = race.winnerIndexByAverage();
        assertEquals(1, winnerIdx);
    }

    @Test
    void recordLapValidations() {
        Car c1 = new CupCar("C1", "CarA", 300, false);
        Driver d1 = new Driver("D1", "A", "Rookie");

        Race race = new Race("Validation Race", new Car[]{c1}, new Driver[]{d1}, 2);

        assertThrows(IllegalArgumentException.class, () -> race.recordLapTime(0, 0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> race.recordLapTime(2, 0, 70));
        assertThrows(IndexOutOfBoundsException.class, () -> race.recordLapTime(0, 3, 70));
    }
}
