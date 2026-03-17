package com.gla.interface_abstraction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateUtil {
    static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}