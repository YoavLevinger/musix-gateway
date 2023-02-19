package org.jmusixmatch;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class GsonDateDeSerializer implements JsonDeserializer<Date> {

    static final Logger logger = LogManager.getLogger();

    private static final String[] DATE_FORMATS = new String[]{
            "YYYYmmdd",
            "YYYY",
            "YYYYMMdd",
            "YYYYmmDD",
            "YYYYMMDD",
            "yyyymmdd",
            "yyyy",
            "YYYY-mm-dd",
            "YYYY-MM-dd",
            "YYYY-mm-DD",
            "YYYY-MM-DD"
    };


    @Override
    public Date deserialize(JsonElement jsonElement, Type typeOF,
                            JsonDeserializationContext context) throws JsonParseException {
        for (String format : DATE_FORMATS) {
            try {
                return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
            } catch (ParseException e) {
                //do noting, it will try additional date format if possible
                logger.warn("Attempted to parse date [{}] with format [{}]", jsonElement.getAsString(), format);
                if (jsonElement.getAsString().isEmpty()) return null;
            }
        }
        throw new JsonParseException("Un-parseable date: \"" + jsonElement.getAsString()
                + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
    }


}
