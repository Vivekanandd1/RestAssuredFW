package BasicRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HTTPReq {
	int id;

	@Test
	void getUsers() {
		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
	}

	@Test (priority = 0)
	void createUser() {

		HashMap<String,String> data = new HashMap<>();
		data.put("name", "Brod");
		data.put("job", "Teacher");

		Response response = given().header("x-api-key", "reqres-free-v1").contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users");
				
				response.then().log().all();
		
		  id = response.jsonPath().getInt("id");
		
		// https://reqres.in/api/users

	}
    
	
	
	@Test  (priority = 2,dependsOnMethods = "createUser")
	void UpdateUser() {

		HashMap<String,String> data = new HashMap<>();
		data.put("name", "Bryan");
		data.put("job", "StreetRacer");

		given().header("x-api-key", "reqres-free-v1").contentType("application/json").body(data)

				.when().put("https://reqres.in/api/users/" + id)

				.then().statusCode(200).log().all();
	}
    
	
	
	@Test (priority = 3)
	void DeleteUser() {

		given().header("x-api-key", "reqres-free-v1")

				.when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();
	}

}
