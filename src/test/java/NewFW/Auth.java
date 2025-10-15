package NewFW;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class Auth {
   
	
	@Test
   public void Authtypes() {
	   RequestSpecification res = RestAssured.given();

		res.baseUri("http://echo.getpostman.com");
		res.basePath("/basic-auth");
		
		Response response = res.auth().preemptive().basic("postman", "password").get();
		System.out.println(response.statusLine());
   }
}
