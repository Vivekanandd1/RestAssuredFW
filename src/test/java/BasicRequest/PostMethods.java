package BasicRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;

/*Different ways to create post request body
 * 1.Using Hashmap
 * 2.Org.json
 * 3.POJO Class
 * 4.Json file data
 * https://reqres.in/api/users
 * */
public class PostMethods {
	
	
	@Test
	void UsingHashMap() {
		HashMap<String, String> data = new HashMap<>();
		data.put("name", "Brodkk");
		data.put("job", "Teacher");
		

		Response response = given().header("x-api-key", "reqres-free-v1").contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users");
		
		System.out.println(response.body());
				
		response.then().statusCode(201).log().all();
		
		int id = response.jsonPath().getInt("id");
        System.out.println("User ID: " + id);

	}
	
	@Test
	void UsingJsonLab() {
		
			JSONObject data = new JSONObject();
			data.put("name", "Mixer");
			data.put("job", "Milkman");
		
		Response response = given().header("x-api-key", "reqres-free-v1").contentType("application/json").body(data.toString())

				.when().post("https://reqres.in/api/users");
		
		System.out.println(response.body());
				
		response.then().statusCode(201).body("name",equalTo("Mixer")).log().all();
		
		int id = response.jsonPath().getInt("id");
        System.out.println("User ID: " + id);

	}
	
	@Test
	void UsingJSON() throws FileNotFoundException {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\APIAutomationFW\\src\\test\\java\\BasicRequest\\data.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject jo  = new JSONObject(jt);
			
		
		given().header("x-api-key", "reqres-free-v1").contentType("application/json").body(jo.toString())

				.when().post("https://reqres.in/api/users")
				
				.then().statusCode(201).body("name", equalTo("brock")).log().all();
		
		      
		
		

	}

}
