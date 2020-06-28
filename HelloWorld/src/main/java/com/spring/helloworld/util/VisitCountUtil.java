package com.spring.helloworld.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitCountUtil {
	
	
	private Date dateCurrent;
	
	public boolean compareDate(Date dateInDB) throws ParseException {
		
		System.out.println(dateInDB + "=-=-=-=-=-=-=-=-=-=-=-=- date");
		
		dateCurrent = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String today = sdf.format(dateCurrent);
		dateCurrent = sdf.parse(today);
		
		String dbDay = sdf.format(dateInDB);
		dateInDB = sdf.parse(dbDay);
		
		
		int result = dateCurrent.compareTo(dateInDB);
		
		if(result > 0) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
}
