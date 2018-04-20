import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;

public class DatabaseJsonReader {

	private ChainOfResponsibility cor = new RescueMedicinePresentationsReader(new MedicineReader(new PhysiotherapiesReader()));
	
	public List<Element> readJsonStream(InputStream in) throws IOException {
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		try {
			return readElements(reader);
		} finally {
			reader.close();
		}
	}
	
	public List<Element> readElements(JsonReader reader) throws IOException {
		List<Element> elements = new ArrayList<Element>();

		reader.beginObject();
		while (reader.hasNext()) {
			String type = reader.nextName();
			reader.beginArray();
			while(reader.hasNext()) {
				elements.add(cor.read(reader, type));
			}
			reader.endArray();
		}
		reader.endObject();
		return elements;
	}
	
}
