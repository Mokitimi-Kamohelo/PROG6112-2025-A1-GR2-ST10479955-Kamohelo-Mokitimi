/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racebusiness;

public class RallyCar extends Car {
    private int offRoadRating; // 1..100

    public RallyCar(String id, String brand, int topSpeed, int offRoadRating) {
        super(id, brand, topSpeed);
        if (offRoadRating < 1 || offRoadRating > 100) throw new IllegalArgumentException("offRoadRating 1..100");
        this.offRoadRating = offRoadRating;
    }

    public int getOffRoadRating() { return offRoadRating; }
    public void setOffRoadRating(int offRoadRating) {
        if (offRoadRating < 1 || offRoadRating > 100) throw new IllegalArgumentException("offRoadRating 1..100");
        this.offRoadRating = offRoadRating;
    }

    @Override
    public String getType() { return "RallyCar"; }
}
