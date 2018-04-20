
public class Medicine implements Element{
	
	private String name;
	
	public Medicine(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Medicine: \n" + "name -> " + name ;
	}
	
}
