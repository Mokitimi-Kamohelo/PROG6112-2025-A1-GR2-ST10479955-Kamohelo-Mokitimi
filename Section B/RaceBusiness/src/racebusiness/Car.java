/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racebusiness;

public abstract class Car {
    private final String id;
    private String brand;
    private int topSpeed; // km/h

    protected Car(String id, String brand, int topSpeed) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id required");
        if (brand == null || brand.isBlank()) throw new IllegalArgumentException("brand required");
        if (topSpeed <= 0) throw new IllegalArgumentException("topSpeed must be > 0");
        this.id = id;
        this.brand = brand;
        this.topSpeed = topSpeed;
    }

    public String getId() { return id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) {
        if (brand == null || brand.isBlank()) throw new IllegalArgumentException("brand required");
        this.brand = brand;
    }
    public int getTopSpeed() { return topSpeed; }
    public void setTopSpeed(int topSpeed) {
        if (topSpeed <= 0) throw new IllegalArgumentException("topSpeed must be > 0");
        this.topSpeed = topSpeed;
    }

    public abstract String getType();

    public String summary() {
        return getType() + " - " + brand + " (ID: " + id + ", Top Speed: " + topSpeed + " km/h)";
    }
}

