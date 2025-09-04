/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racebusiness;

public class CupCar extends Car {
    private boolean turbo;

    public CupCar(String id, String brand, int topSpeed, boolean turbo) {
        super(id, brand, topSpeed);
        this.turbo = turbo;
    }

    public boolean hasTurbo() { return turbo; }
    public void setTurbo(boolean turbo) { this.turbo = turbo; }

    @Override
    public String getType() { return "SportsCar"; }
}

