/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tv_seriesapp;

import java.util.Scanner;

public class Tv_SeriesApp {
    public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        Series seriesManager = new Series();

        System.out.println("LATEST SERIES - 2025");
        System.out.println();
        System.out.println("Enter (1) to launch the app menu or any other key to exit");

        String choice = input.nextLine();
        if (!choice.equals("1")) {
            System.out.println("Application closed.");
            return;
        }

        while (true) {
            System.out.println("\nPlease select one of the following menu items for the TV series");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a new TV series");
            System.out.println("(3) Update a TV series age restriction");
            System.out.println("(4) Delete a TV series");
            System.out.println("(5) Print a series report - 2025");
            System.out.println("(6) Exit application");

            String option = input.nextLine();

            switch (option) {
                case "1": seriesManager.CaptureSeries(); break;
                case "2": seriesManager.SearchSeries(); break;
                case "3": seriesManager.UpdateSeries(); break;
                case "4": seriesManager.DeleteSeries(); break;
                case "5": seriesManager.SeriesReport(); break;
                case "6": seriesManager.ExitSeriesApplication(); break;
                default: System.out.println("Invalid option. Try again."); break;
            }
        }
    }
}