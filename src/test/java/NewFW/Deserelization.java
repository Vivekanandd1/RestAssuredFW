package NewFW;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Deserelization {
	
	
	@Test
	public void UserCrt() {
	   RequestSpecification res = RestAssured.given();
	   res.baseUri("https://reqres.in");
		res.basePath("/api/users");
		JSONObject jd = new JSONObject();
		 jd.put("name", "Vatsal");
		 jd.put("job","AI Engineer");
		 
		 
		Response resp=  res.header("x-api-key", "reqres-free-v1").header("Content-Type", "application/json").body(jd.toString()).post();
		 System.out.println("Response JSON: " + resp.getBody().asString());
		ResponseBody<?> bodys = resp.getBody();
		DeserlizationResponsee respclass = bodys.as(DeserlizationResponsee.class);
		
		Assert.assertEquals(respclass.name, "Vatsal");
		Assert.assertEquals(respclass.job, "AI Engineer");
		
		
	}

}
