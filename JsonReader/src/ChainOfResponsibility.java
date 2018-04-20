import java.io.IOException;

import com.google.gson.stream.JsonReader;

public abstract class ChainOfResponsibility {
	
	private String type;
	private ChainOfResponsibility superior;
	
	public ChainOfResponsibility( ChainOfResponsibility superior ) {
		this.setSuperior(superior);
	}
	public ChainOfResponsibility() {
		this(null);
	}
	
	public void setType(String t) {
		type = t;
	}
	public String getType() {
		return type;
	}
	
	public void setSuperior(ChainOfResponsibility superior) {
		this.superior = superior;
	}
	
	public ChainOfResponsibility getSuperior() {
		return superior;
	}
	
	public abstract Element read(JsonReader reader, String type) throws IOException;
	
	public boolean isResponsible(String type) {
		return type.equalsIgnoreCase(this.getType());
	}
	
}
