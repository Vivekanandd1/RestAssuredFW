package BasicRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;

public class ParsingJsonResponse {

	@Test
	void TestResponseData() {

		given().contentType("ContentType.JSON").when().get("http://localhost:3000/store")

				.then().statusCode(200).header("Content-Type", "application/json")
				.body("item[4].language", equalTo("Uyghur"));
	}

	@Test
	void TestNGResponseData() {

		Response res = given().contentType("ContentType.JSON").when().get("http://localhost:3000/store");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.contentType(), "application/json");
		String Lang = res.jsonPath().get("item[4].language").toString();
		Assert.assertEquals(Lang, "Uyghur");

	}

	@Test
	void TestJsonField() {

		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");

		JSONObject jo = new JSONObject(res.asString());
		
		for(int i=0;i<jo.getJSONArray("item").length();i++) {
			String Langs = jo.getJSONArray("item").getJSONObject(i).get("language").toString();
			System.out.println(Langs);
		}

	}

}
