package common;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LENOVO on 04/01/2016.
 */
public final class DateUtils {

    public static final String dateToString(Date date) {
        String convertedDate = null;
        SimpleDateFormat dateFormatter = null;

        try {
            if (date != null) {
                dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                convertedDate = dateFormatter.format(date);
            }
        } catch(Exception ex) {
            Log.e("Error: ", ex.getMessage());
            convertedDate = null;
        }

        return convertedDate;
    }

    public static final Date stringToDate(String stringDateFormat) {
        SimpleDateFormat dateFormatter = null;
        Date convertDate = null;

        try {
            if (stringDateFormat != null) {
                dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                convertDate = dateFormatter.parse(stringDateFormat);
            }
        } catch(Exception ex) {
            Log.e("Error: ", ex.getMessage());
            convertDate = null;
        }

        return convertDate;
    }
}
