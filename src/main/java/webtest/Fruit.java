package webtest;

import java.awt.Color;
import java.awt.Shape;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fruit {

	public Shape getShape() {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isSweet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) throws ParseException {
		// with SimpleDateFormat
		// 1. if we don't specify time it will be 00:00:00
		// 2. if we don't specify date it will be Jan 01 1970
		
		String date = "1:45 PM";
		
		SimpleDateFormat simple = new SimpleDateFormat("h:mm a");
		System.out.println(simple.parse(date));
		
		
		DateTimeFormatter form = DateTimeFormatter.ofPattern("h:mm a");
		//LocalDateTime dateTime = LocalDateTime.parse(date, form);
		
		LocalTime localTime = LocalTime.parse(date, form);	
		System.out.println(localTime);
		
		String date2 = "2:24p";
		date2 = date2.replace("p", " PM").replace("a", " AM");
		localTime = LocalTime.parse(date2, form);	
		System.out.println(localTime);
		
		LocalDateTime finalDate = LocalDateTime.of(LocalDate.now(), localTime);
		System.out.println(finalDate);
		
		LocalDateTime plusDays = finalDate.plusDays(2);
		System.out.println(finalDate.compareTo(plusDays));
		
		
		
		// ==================================
		String original = "2017/02/15";
		DateTimeFormatter newOne = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate newDate = LocalDate.parse(original, newOne);
		System.out.println(newDate);
		
		SimpleDateFormat newSimple = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println(newSimple.parse(original));
		
		
		//LocalDateTime time = LocalDate.parse("2017/02/15", newOne).atStartOfDay();
		
		
		// ==================================
		Calendar cal = new GregorianCalendar();
		
		date = date + " " + cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(date);
		System.out.println(new SimpleDateFormat("h:mm a yyyy/MM/dd").parse(date));
		
	}

}
