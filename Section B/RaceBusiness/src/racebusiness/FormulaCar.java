/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racebusiness;

public class FormulaCar extends Car {
    private int aeroRating; // 1..100

    public FormulaCar(String id, String brand, int topSpeed, int aeroRating) {
        super(id, brand, topSpeed);
        if (aeroRating < 1 || aeroRating > 100) throw new IllegalArgumentException("aeroRating 1..100");
        this.aeroRating = aeroRating;
    }

    public int getAeroRating() { return aeroRating; }
    public void setAeroRating(int aeroRating) {
        if (aeroRating < 1 || aeroRating > 100) throw new IllegalArgumentException("aeroRating 1..100");
        this.aeroRating = aeroRating;
    }

    @Override
    public String getType() { return "FormulaCar"; }
}
