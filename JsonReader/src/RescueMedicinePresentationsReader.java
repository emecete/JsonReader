import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class RescueMedicinePresentationsReader extends ChainOfResponsibility {
	
	public RescueMedicinePresentationsReader(ChainOfResponsibility superior) {
		super(superior);
		setType("RescueMedicinePresentations");
	}
	public RescueMedicinePresentationsReader() {
		super();
		setType("RescueMedicinePresentations");
	}
	
	@Override
	public Element read(JsonReader reader, String type) throws IOException  {
		if(this.isResponsible(type)) {
			String medicineRef = null;
			String activeIngRef = null;
			String inhalerRef = null;
			String dose = null;

			reader.beginObject();
			while (reader.hasNext()) {
				String name = reader.nextName();
				if (name.equalsIgnoreCase("medicineRef")) {
					medicineRef = reader.nextString();
				} else if(name.equalsIgnoreCase("activeIngRef")) {
					activeIngRef = reader.nextString();
				} else if(name.equalsIgnoreCase("inhalerRef")) {
					inhalerRef = reader.nextString();
				} else if(name.equalsIgnoreCase("dose")) {
					dose = reader.nextString();
				} else {
					reader.skipValue();
				}
			}
			reader.endObject();
			return new RescueMedicinePresentations(medicineRef, activeIngRef, inhalerRef, dose);
		} else {
			if(this.getSuperior() != null) {
				return this.getSuperior().read(reader, type); 
			} else {
				reader.skipValue();
				//throw new RuntimeException("Peticion no respondida. RescueMedicinePresentations no leido");
			}
		}
		return null;
	}

}
