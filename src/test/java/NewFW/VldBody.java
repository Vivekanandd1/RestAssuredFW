package NewFW;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class VldBody {

	@Test
	public void BodyValidation() {
		RequestSpecification res = RestAssured.given();

		res.baseUri("https://reqres.in/");
		res.basePath("/api/users?page=2");

		res.header("x-api-key", "reqres-free-v1");

		Response resp = res.get();
		ResponseBody<?> resBody = resp.getBody();
		String LastBody = resBody.asString();

		System.out.println(LastBody);
		
//		Assert.assertEquals(LastBody.contains("vivek"), true, "check for name not matching");
		
		JsonPath JsnPth = resBody.jsonPath();
		 String Firstname = JsnPth.get("data[0].first_name");
		 Assert.assertEquals(Firstname, "George","Incorrect value");
		 
	}

}
