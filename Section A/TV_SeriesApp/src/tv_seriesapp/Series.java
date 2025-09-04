/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tv_seriesapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void CaptureSeries() {
        System.out.println("\nCAPTURE A NEW SERIES - 2025");

        System.out.print("Enter the series id: ");
        String id = input.nextLine();

        System.out.print("Enter the series name: ");
        String name = input.nextLine();

        String age;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            age = input.nextLine();
            try {
                int ageNum = Integer.parseInt(age);
                if (ageNum >= 2 && ageNum <= 18) {
                    break;
                } else {
                    System.out.println("Invalid! Age restriction must be between 2 and 18.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid! Please enter numbers only.");
            }
        }

        System.out.print("Enter the number of episodes for " + name + ": ");
        String episodes = input.nextLine();

        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series captured successfully!");
    }

    public void SearchSeries() {
        System.out.print("Enter the series ID to search: ");
        String id = input.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                System.out.println("Series found:\n" + s);
                return;
            }
        }
        System.out.println("No series data could be found.");
    }

    public void UpdateSeries() {
        System.out.print("Enter the series ID to update: ");
        String id = input.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                System.out.print("Enter new series name: ");
                s.SeriesName = input.nextLine();

                // Validate age again
                while (true) {
                    System.out.print("Enter new age restriction: ");
                    String age = input.nextLine();
                    try {
                        int ageNum = Integer.parseInt(age);
                        if (ageNum >= 2 && ageNum <= 18) {
                            s.SeriesAge = age;
                            break;
                        } else {
                            System.out.println("Invalid! Age must be 2–18.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid! Numbers only.");
                    }
                }

                System.out.print("Enter new number of episodes: ");
                s.SeriesNumberOfEpisodes = input.nextLine();

                System.out.println("Series updated successfully!");
                return;
            }
        }
        System.out.println("Series not found.");
    }

    public void DeleteSeries() {
        System.out.print("Enter the series ID to delete: ");
        String id = input.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                System.out.print("Are you sure you want to delete this series? (Y/N): ");
                String confirm = input.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    seriesList.remove(s);
                    System.out.println("Series deleted successfully.");
                } else {
                    System.out.println("Delete cancelled.");
                }
                return;
            }
        }
        System.out.println("Series not found.");
    }

    public void SeriesReport() {
        System.out.println("\nSERIES REPORT - 2025");
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        } else {
            for (SeriesModel s : seriesList) {
                System.out.println(s);
            }
        }
    }

    public void ExitSeriesApplication() {
        System.out.println("Exiting application");
        System.exit(0);
    }

    public void addSeries(SeriesModel s) {
        seriesList.add(s);
    }

    public SeriesModel searchSeriesById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean updateSeriesById(String id, String newName, String newAge, String newEpisodes) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                s.SeriesName = newName;
                s.SeriesAge = newAge;
                s.SeriesNumberOfEpisodes = newEpisodes;
                return true;
            }
        }
        return false;
    }

    public boolean deleteSeriesById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                seriesList.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean validateAgeRestriction(int age) {
        return age >= 2 && age <= 18;
    }

    public ArrayList<SeriesModel> getSeriesList() {
        return seriesList;
    }
}