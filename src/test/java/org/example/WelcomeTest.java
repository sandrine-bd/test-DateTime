package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WelcomeTest {

    private final Welcome welcome = new Welcome();

    @Test
    public void testBonjour() {
        LocalDateTime dt = LocalDateTime.of(2025, Month.APRIL, 7, 10, 0); // Lundi 10h
        assertEquals("Bonjour", welcome.getMessage(dt));
    }

    @Test
    public void testBonApresMidi() {
        LocalDateTime dt = LocalDateTime.of(2025, Month.APRIL, 8, 15, 0); // Mardi 15h
        assertEquals("Bon après-midi", welcome.getMessage(dt));
    }

    @Test
    public void testBonsoir() {
        LocalDateTime dt = LocalDateTime.of(2025, Month.APRIL, 9, 20, 0); // Mercredi 20h
        assertEquals("Bonsoir", welcome.getMessage(dt));
    }

    @Test
    public void testBonWeekendVendrediSoir() {
        LocalDateTime dt = LocalDateTime.of(2025, Month.APRIL, 11, 19, 0); // Vendredi 19h
        assertEquals("Bon week-end", welcome.getMessage(dt));
    }

    @Test
    public void testBonWeekendSamedi() {
        LocalDateTime dt = LocalDateTime.of(2025, Month.APRIL, 12, 11, 0); // Samedi 11h
        assertEquals("Bon week-end", welcome.getMessage(dt));
    }

    @Test
    public void testBonWeekendDimanche() {
        LocalDateTime dt = LocalDateTime.of(2025, Month.APRIL, 13, 14, 0); // Dimanche 14h
        assertEquals("Bon week-end", welcome.getMessage(dt));
    }

    @Test
    public void testBonWeekendLundiMatin() {
        LocalDateTime dt = LocalDateTime.of(2025, Month.APRIL, 14, 8, 0); // Lundi 8h
        assertEquals("Bon week-end", welcome.getMessage(dt));
    }
}
