package Wrappers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurrentDateTime {

	public static String getCurrentDateTomeFormat() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
		return sdf.format(date);
	}
}
