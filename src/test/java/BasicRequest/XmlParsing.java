package BasicRequest;

import com.github.javafaker.Faker;

public class XmlParsing {
	
	public static void main(String[] args) {
		Faker fk = new Faker();
		
		String name = fk.name().firstName();
		System.out.println(name);
		
	}

}
