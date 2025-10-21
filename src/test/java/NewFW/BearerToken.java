package NewFW;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken {
	
	@Test
	   public void BearerAuth() {
		   RequestSpecification res = RestAssured.given();

			res.baseUri("https://gorest.co.in");
			res.basePath("/public/v2/users");
			   
			JSONObject jLoad = new JSONObject();
			jLoad.put("name", "Viveka");
			jLoad.put("gender", "male");
			jLoad.put("email", "vivek@yopmail.com");
			jLoad.put("status", "active");
			
			String AuthToken = "Bearer 9452f8defe2050620fad5ce22cbeb1fda97bf4f192b6fb19e8fbfddfe1280285";
			
			Response resp = res.header("Authorization", AuthToken).contentType("application/json").body(jLoad.toString()).post();
			 
			System.out.println(resp.statusLine());
			System.out.println(resp.getBody().asString());
			
			
			
			
	   }

}
