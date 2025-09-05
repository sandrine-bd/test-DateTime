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

        // vendredi 18h - lundi 9h
        if ((day == DayOfWeek.FRIDAY && time.isAfter(sixPM)) ||
                (day == DayOfWeek.SATURDAY) ||
                (day == DayOfWeek.SUNDAY) ||
                (day == DayOfWeek.MONDAY && time.isBefore(nineAM))) {
            return "Bon week-end";
            }

        // lundi, mardi, mercredi, jeudi 18h-9h
        if ((time.isAfter(sixPM) && time.isBefore(nineAM)) &&
                ((day == DayOfWeek.MONDAY) || (day == DayOfWeek.TUESDAY) ||
                (day == DayOfWeek.WEDNESDAY) || (day == DayOfWeek.THURSDAY))) {
            return "Bonsoir";
        }

        // lundi, mardi, mercredi, jeudi, vendredi
        if ((day == DayOfWeek.MONDAY) || (day == DayOfWeek.TUESDAY) ||
                (day == DayOfWeek.WEDNESDAY) || (day == DayOfWeek.THURSDAY) ||
                (day == DayOfWeek.FRIDAY)) {
            if (time.isAfter(onePM) && time.isBefore(sixPM)) { // 13h-18h
                return "Bon après-midi";
            }
            if (time.isAfter(nineAM) && time.isBefore(onePM)) { // 9h-13h
                return "Bonjour";
            }
        }
        return "Bienvenue";
    }
}
