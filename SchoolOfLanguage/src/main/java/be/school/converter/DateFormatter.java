package be.school.converter;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import be.school.util.DateUtil;





@Service
public class DateFormatter implements Formatter<Date> {

	@Override
	public String print(Date date, Locale locale) {
		return DateUtil.formatyyyyMMdd(date);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
			return DateUtil.parseyyyyMMddWithParseException(text);
	}

	protected DateFormat getDateFormat(Locale locale){
		DateFormat daFormat = new SimpleDateFormat("yyyy-MM-dd",locale);
		daFormat.setLenient(false);
		return daFormat;
		
	}
   
  
}
