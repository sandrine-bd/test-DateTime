package org.example;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Welcome {
    public String getMessage() {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek day = now.getDayOfWeek();
        LocalTime time = now.toLocalTime();

        LocalTime nineAM = LocalTime.of(9, 0);
        LocalTime onePM = LocalTime.of(13, 0);
        LocalTime sixPM = LocalTime.of(18, 0);

        // vendredi 18h - lundi 9h
        if ((day == DayOfWeek.FRIDAY && time.isAfter(sixPM)) ||
                (day == DayOfWeek.SATURDAY) ||
                (day == DayOfWeek.SUNDAY) ||
                (day == DayOfWeek.MONDAY && time.isBefore(nineAM))) {
            return "Bon week-end";
            }

        // 18h-9h lundi, mardi, mercredi, jeudi
        if ((time.isAfter(sixPM) && time.isBefore(nineAM)) &&
                ((day == DayOfWeek.MONDAY) || (day == DayOfWeek.TUESDAY) ||
                (day == DayOfWeek.WEDNESDAY) || (day == DayOfWeek.THURSDAY))) {
            return "Bonsoir";
        }

        // lundi, mardi, mercredi, jeudi, vendredi
        if ((day == DayOfWeek.MONDAY) || (day == DayOfWeek.TUESDAY) ||
                (day == DayOfWeek.WEDNESDAY) || (day == DayOfWeek.THURSDAY) ||
                (day == DayOfWeek.FRIDAY)) {
            if (time.isAfter(onePM) && time.isBefore(sixPM)) {
                return "Bon après-midi";
            }
            if (time.isAfter(nineAM) && time.isBefore(onePM)) {
                return "Bonjour";
            }
        }
        return "Bienvenue";
    }
}
