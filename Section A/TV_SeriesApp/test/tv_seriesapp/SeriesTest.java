/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tv_seriesapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class SeriesTest {
    private Series series;

    @BeforeEach
    public void setUp() {
        series = new Series();
        series.addSeries(new SeriesModel("S02", "Breaking Good", "16", "29"));
    }

    @Test
    public void TestSearchSeries() {
        SeriesModel found = series.searchSeriesById("S02");
        assertNotNull(found, "Series should be found");
        assertEquals("Breaking Good", found.SeriesName);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        SeriesModel found = series.searchSeriesById("S999");
        assertNull(found, "Series should not be found");
    }

    @Test
    public void TestUpdateSeries() {
        boolean updated = series.updateSeriesById("S05", "Breaking Good Once Again", "18", "12");
        assertTrue(updated, "Series should be updated");
        SeriesModel found = series.searchSeriesById("S05");
        assertEquals("Breaking Good Once Again", found.SeriesName);
        assertEquals("18", found.SeriesAge);
        assertEquals("12", found.SeriesNumberOfEpisodes);
    }

    @Test
    public void TestDeleteSeries() {
        boolean deleted = series.deleteSeriesById("S05");
        assertTrue(deleted, "Series should be deleted");
        assertNull(series.searchSeriesById("S001"), "Deleted series should not exist");
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = series.deleteSeriesById("S999");
        assertFalse(deleted, "Series should not be deleted because it doesn't exist");
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(series.validateAgeRestriction(15), "Age 15 should be valid");
        assertTrue(series.validateAgeRestriction(2), "Age 2 should be valid");
        assertTrue(series.validateAgeRestriction(18), "Age 18 should be valid");
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse(series.validateAgeRestriction(1), "Age 1 should be invalid");
        assertFalse(series.validateAgeRestriction(19), "Age 19 should be invalid");
        assertFalse(series.validateAgeRestriction(-5), "Negative age should be invalid");
    }
}
