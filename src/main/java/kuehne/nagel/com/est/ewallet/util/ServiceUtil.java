package kuehne.nagel.com.est.ewallet.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiceUtil {
	
	public static String generateCode(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSS");
		return formatter.format(date);
	}

}
