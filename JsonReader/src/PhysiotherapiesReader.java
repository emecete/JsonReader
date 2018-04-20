import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class PhysiotherapiesReader extends ChainOfResponsibility {

	public PhysiotherapiesReader(ChainOfResponsibility superior) {
		super(superior);
		setType("physiotherapies");
	}
	public PhysiotherapiesReader() {
		super();
		setType("physiotherapies");
	}
	
	@Override
	public Element read(JsonReader reader, String type) throws IOException {
		if(this.isResponsible(type)) {
			String physiotherapyName = null;
			String image = null;
			
			reader.beginObject();
			while (reader.hasNext()) {
				String name = reader.nextName();
				if (name.equalsIgnoreCase("name")) {
					physiotherapyName = reader.nextString();
				} else if(name.equalsIgnoreCase("image")) {
					image = reader.nextString();
				} else {	
					reader.skipValue();
				}
			}
			reader.endObject();
			return new Physiotherapy(physiotherapyName, image);
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
