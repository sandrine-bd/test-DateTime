package org.example;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Welcome {

    public String getMessage() {
        return getMessage(LocalDateTime.now());
    }

    public String getMessage(LocalDateTime dateTime) {
        DayOfWeek day = dateTime.getDayOfWeek();
        LocalTime time = dateTime.toLocalTime();

        LocalTime nineAM = LocalTime.of(9, 0);
        LocalTime onePM = LocalTime.of(13, 0);
        LocalTime sixPM = LocalTime.of(18, 0);

        // Cas particulier du week-end (vendredi 18h -> lundi 9h)
        if ((day == DayOfWeek.FRIDAY && time.isAfter(sixPM)) ||
                (day == DayOfWeek.SATURDAY) ||
                (day == DayOfWeek.SUNDAY) ||
                (day == DayOfWeek.MONDAY && time.isBefore(nineAM))) {
            return "Bon week-end";
        }

        // Cas en semaine
        if (day.getValue() >= DayOfWeek.MONDAY.getValue() &&
                day.getValue() <= DayOfWeek.FRIDAY.getValue()) {

            if (!time.isBefore(nineAM) && time.isBefore(onePM)) {
                return "Bonjour";
            } else if (!time.isBefore(onePM) && time.isBefore(sixPM)) {
                return "Bon après-midi";
            } else {
                return "Bonsoir";
            }
        }

        return "Bienvenue";
    }
}
