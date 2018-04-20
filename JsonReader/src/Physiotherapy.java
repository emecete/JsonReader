
public class Physiotherapy implements Element {
	private String name;
	private String image;

	public Physiotherapy(String name, String image) {
		this.name = name;
		this.image = image;
	}

	public String toString() {
		return "Physiotherapy: \n" + "name -> " + name + "\nimage -> "  + image ;
	}
}
