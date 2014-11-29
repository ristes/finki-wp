package mk.ukim.finki.wp.json;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Custom Jackson serializer for displaying Joda Time dates.
 */
public class ShortDateSerializer extends JsonSerializer<DateTime> {

	public static DateTimeFormatter formatter = DateTimeFormat.forPattern(
			"yyyy-MM-dd").withZone(DateTimeZone.getDefault());

	@Override
	public void serialize(DateTime value, JsonGenerator generator,
			SerializerProvider serializerProvider) throws IOException {
		if (value != null) {
			generator.writeString(formatter.print(value));
		} else {
			generator.writeObject(value);
		}
	}

}
