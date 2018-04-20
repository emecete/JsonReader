import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		try{
			DatabaseJsonReader grc = new DatabaseJsonReader();
			InputStream usersIS = new FileInputStream (new File("./res/datos.json"));
			ArrayList<Element> elements = (ArrayList<Element>)grc.readJsonStream(usersIS);
			for(Element e:elements) {
				if(e != null) System.out.println(e.toString());
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
}
