package NewFW;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
public class QueryParam {
	@Test
	public void BodyValidation() {
		RequestSpecification res = RestAssured.given();

		res.baseUri("https://reqres.in/");
		res.basePath("/api/users");
		res.queryParam("page", "2").queryParam("id", "7");
		res.header("x-api-key", "reqres-free-v1");
		
		Response response = res.get();
		String BodyText = response.getBody().asString();
		System.out.println(BodyText);
		
		 JsonPath Jpath = response.jsonPath();
		 String First = Jpath.get("data.first_name");
		 System.out.println("Name is :" + First);
		 Assert.assertEquals(First, "Mihael", "Verify Name");
		
	}
}
