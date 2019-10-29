package mbooks.technical.date;

import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
public class SimpleDate {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");

    private static final SimpleDateFormat sdfTime = new SimpleDateFormat("dd MMM yyyy à HH:mm");

    public String getDate( Date date){
        if ( date != null)
            return "le " + sdf.format( date );
        else
            return "";
    }

    public String getDateTime( Date date){
        if ( date != null)
            return "le " + sdfTime.format( date );
        else
            return "";
    }


}
