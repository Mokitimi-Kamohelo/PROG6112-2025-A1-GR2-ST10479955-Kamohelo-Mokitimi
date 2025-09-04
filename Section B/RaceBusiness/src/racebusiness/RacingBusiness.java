/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racebusiness;

public class RacingBusiness {
    private final Car[] cars;
    private final Driver[] drivers;
    private final Race[] races;
    private int carCount = 0;
    private int driverCount = 0;
    private int raceCount = 0;

    public RacingBusiness(int maxCars, int maxDrivers, int maxRaces) {
        if (maxCars <= 0 || maxDrivers <= 0 || maxRaces <= 0) throw new IllegalArgumentException("capacities > 0");
        this.cars = new Car[maxCars];
        this.drivers = new Driver[maxDrivers];
        this.races = new Race[maxRaces];
    }

    public boolean addCar(Car car) {
        if (car == null) return false;
        if (carCount >= cars.length) return false;
        cars[carCount++] = car;
        return true;
    }

    public boolean addDriver(Driver driver) {
        if (driver == null) return false;
        if (driverCount >= drivers.length) return false;
        drivers[driverCount++] = driver;
        return true;
    }

    public boolean addRace(Race race) {
        if (race == null) return false;
        if (raceCount >= races.length) return false;
        races[raceCount++] = race;
        return true;
    }

    public Car[] getCarsSnapshot() {
        Car[] snapshot = new Car[carCount];
        for (int i = 0; i < carCount; i++) snapshot[i] = cars[i];
        return snapshot;
    }

    public Driver[] getDriversSnapshot() {
        Driver[] snapshot = new Driver[driverCount];
        for (int i = 0; i < driverCount; i++) snapshot[i] = drivers[i];
        return snapshot;
    }

    public Race[] getRacesSnapshot() {
        Race[] snapshot = new Race[raceCount];
        for (int i = 0; i < raceCount; i++) snapshot[i] = races[i];
        return snapshot;
    }

    public String businessReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Racing Car Business Report ===\n\n");

        sb.append("Cars (").append(carCount).append("):\n");
        for (int i = 0; i < carCount; i++) {
            sb.append("  ").append(i + 1).append(". ").append(cars[i].summary()).append("\n");
        }
        sb.append("\nDrivers (").append(driverCount).append("):\n");
        for (int i = 0; i < driverCount; i++) {
            sb.append("  ").append(i + 1).append(". ").append(drivers[i].summary()).append("\n");
        }
        sb.append("\nRaces (").append(raceCount).append("):\n");
        for (int i = 0; i < raceCount; i++) {
            sb.append("  ").append(i + 1).append(". ").append(races[i].getRaceName()).append("\n");
        }
        return sb.toString();
    }
}
