/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package racebusiness;

public class RaceBusiness {
    public static void main(String[] args) {
        // Initialize business with capacities
        RacingBusiness RB = new RacingBusiness(10, 10, 10);

        // Cars (inheritance in action)
        Car ferrari = new CupCar("C001", "Ferrari", 320, true);
        Car redBull = new FormulaCar("C002", "Red Bull", 350, 95);
        Car subaru = new RallyCar("C003", "Subaru", 280, 90);

        RB.addCar(ferrari);
        RB.addCar(redBull);
        RB.addCar(subaru);

        // Drivers
        Driver hamilton = new Driver("D001", "Lewis Hamilton", "Expert");
        Driver verstappen = new Driver("D002", "Max Verstappen", "Expert");
        Driver kenBlock = new Driver("D003", "Ken Block", "Professional");

        RB.addDriver(hamilton);
        RB.addDriver(verstappen);
        RB.addDriver(kenBlock);

        // Create a race with 3 laps
        Car[] participants = { ferrari, redBull, subaru };
        Driver[] drivers = { hamilton, verstappen, kenBlock };
        Race gp = new Race("Grand Prix", participants, drivers, 3);

        // Record lap times (seconds)
        gp.recordLapTime(0, 0, 72.3); gp.recordLapTime(0, 1, 70.5); gp.recordLapTime(0, 2, 68.7);
        gp.recordLapTime(1, 0, 71.9); gp.recordLapTime(1, 1, 69.8); gp.recordLapTime(1, 2, 67.1);
        gp.recordLapTime(2, 0, 75.2); gp.recordLapTime(2, 1, 74.9); gp.recordLapTime(2, 2, 73.0);

        RB.addRace(gp);

        // Print reports
        System.out.println(RB.businessReport());
        System.out.println(gp.report());
    }
}
