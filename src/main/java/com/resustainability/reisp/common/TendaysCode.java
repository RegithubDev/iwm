package com.resustainability.reisp.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TendaysCode {

	 public static String tenthDay() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate today = LocalDate.now();

	        List<String> lastTenDays = IntStream.rangeClosed(0, 9)
	                .mapToObj(today::minusDays)
	                .map(date -> date.format(formatter))
	                .collect(Collectors.toList());

	        System.out.println("Last value: " + lastTenDays.get(lastTenDays.size() - 1));
			return lastTenDays.get(lastTenDays.size() - 1);
	    }
}
