package mk.ukim.finki.wp.json;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Custom Jackson serializer for displaying Joda Time dates.
 */
public class CustomDateDeserializer extends JsonDeserializer<DateTime> {

	public static DateTimeFormatter formatter = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm");
	public static DateTimeFormatter genericFormtter = ISODateTimeFormat
			.dateTimeParser();

	@Override
	public DateTime deserialize(JsonParser parser,
			DeserializationContext context) throws IOException,
			JsonProcessingException {
		String date = parser.getText();
		try {
			return formatter.parseDateTime(date);
		} catch (IllegalArgumentException e) {
			return genericFormtter.parseDateTime(date);
		}
	}
}
