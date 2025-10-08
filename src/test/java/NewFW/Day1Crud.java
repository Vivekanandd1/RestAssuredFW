package NewFW;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Day1Crud {

	@Test
	public void getMethod() {
		// https://reqres.in/api/users?page=2
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Response Code: " + response.getStatusCode());
		System.out.println("Response Body: " + response.getBody().asString());
		System.out.println("Response Time: " + response.getTime());
		System.out.println("Response Header: " + response.getHeader("Content-Type"));
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Test
	public void Bddgetmethod() {
		baseURI = "https://reqres.in/api/users?";

		given().queryParam("page", "2").when().get().then().statusCode(200);
	}

	@Test
	public void PostMeth() throws InterruptedException {
		JSONObject JB = new JSONObject();
		JB.put("name", "Vatsal");
		JB.put("job", "QA");

		baseURI = "https://reqres.in/api/users";
		Response response = given().header("x-api-key", "reqres-free-v1").header("Content-Type", "application/json")
				.contentType(ContentType.JSON).body(JB.toString()).when().post();

		int retries = 3; // max retries

		for (int i = 0; i < retries; i++) {
			if (response.statusCode() == 429) {
				Thread.sleep(2000);
			} else {
				break;
			}
		}

		response.then().statusCode(201).log().all();

	}

	
	@Description("This test case is for Login/Logout functinality")
    @Owner("Vivekanand Deshmukh") 
	@Test
	public void PUTMeth() throws InterruptedException {
		  JSONObject JB = new JSONObject();
		    JB.put("name", "Kitty");
		    JB.put("job", "QA");

		    RestAssured.baseURI = "https://reqres.in/api/users/2"; // specify user id to update

		    Response response = null;
		    int retries = 3;

		    for (int i = 0; i < retries; i++) {
		        response = RestAssured.given()
		                .header("x-api-key", "reqres-free-v1") // optional for reqres
		                .contentType(ContentType.JSON)
		                .body(JB.toString())
		                .when()
		                .put();

		        if (response.statusCode() == 429) {
		            System.out.println("Got 429 Too Many Requests. Retrying after 2 seconds...");
		            Thread.sleep(2000);
		        } else {
		            break; // exit loop if not 429
		        }
		    }

		    // Correct assertion for PUT
		    response.then().statusCode(200).log().all();
	}

	@Test
	public void DelMeth() throws InterruptedException {

		baseURI = "https://reqres.in/api/users/194";
		Response response = null;

		int retries = 3;

		for (int i = 0; i < retries; i++) {
			response = given().header("x-api-key", "reqres-free-v1").header("Content-Type", "application/json").when()
					.delete();
			if (response.statusCode() == 429) {
				Thread.sleep(2000);
			} else {
				break;
			}
		}

		response.then().statusCode(204).log().all();

	}

}
