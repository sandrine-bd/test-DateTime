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

        // Week-end (vendredi 18h -> lundi 9h)
        if ((day == DayOfWeek.FRIDAY && time.isAfter(sixPM)) ||
                (day == DayOfWeek.SATURDAY) ||
                (day == DayOfWeek.SUNDAY) ||
                (day == DayOfWeek.MONDAY && time.isBefore(nineAM))) {
            return "Bon week-end";
        }

        // Semaine
        if (day.getValue() >= DayOfWeek.MONDAY.getValue() &&
                day.getValue() <= DayOfWeek.FRIDAY.getValue()) {

            if (!time.isBefore(nineAM) && time.isBefore(onePM)) { // 9h-13h
                return "Bonjour";
            } else if (!time.isBefore(onePM) && time.isBefore(sixPM)) { // 13h-18h
                return "Bon après-midi";
            } else { // 18h-9h
                return "Bonsoir";
            }
        }

        return "Bienvenue"; // dans les autres cas (donc jamais)
    }
}
