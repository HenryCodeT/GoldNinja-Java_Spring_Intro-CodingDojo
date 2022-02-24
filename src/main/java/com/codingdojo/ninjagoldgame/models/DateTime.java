package com.codingdojo.ninjagoldgame.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTime {
	public String getDateFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd yyyy HH:mm a",Locale.ENGLISH); 
		Date date =new Date();
		String outPut = formatter.format(date);
		return outPut;
	}
}
