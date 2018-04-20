import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class MedicineReader extends ChainOfResponsibility{
	
	public MedicineReader(ChainOfResponsibility superior) {
		super(superior);
		setType("medicines");
	}
	public MedicineReader() {
		super();
		setType("medicines");
	}

	@Override
	public Element read(JsonReader reader, String type) throws IOException  {
		if(this.isResponsible(type)) {
			String medicineName = null;
			reader.beginObject();
			while (reader.hasNext()) {
				String name = reader.nextName();
				if (name.equalsIgnoreCase("name")) {
					medicineName = reader.nextString();
				} else {
					reader.skipValue();
				}
			}
			reader.endObject();
			return new Medicine(medicineName);
		} else {
			if(this.getSuperior() != null) {
				return this.getSuperior().read(reader, type); 
			} else {
				reader.skipValue();
				//throw new RuntimeException("Peticion no respondida. Medicine no leido");
			}
		}
		return null;
		
	}

}
