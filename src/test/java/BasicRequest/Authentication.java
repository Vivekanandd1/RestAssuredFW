package BasicRequest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Authentication {
	
	
	@Test
	void BasicAuth() {
		given().auth().basic("Username", "postman")
		.when().get("http://echo.getpostman.com/basic-auth")
		.then().statusCode(200).log().all();	
	}
	
	@Test
	void DigestAuth() {
		given().auth().digest("Username", "postman")
		.when().get("http://echo.getpostman.com/basic-auth")
		.then().statusCode(200).log().all();	
	}
	
	@Test
	void PreemptiveAuth() {
		given().auth().preemptive().basic("Username", "postman")
		.when().get("http://echo.getpostman.com/basic-auth")
		.then().statusCode(200).log().all();	
	}
	
	@Test
	void BearerToken() {
		String Token = "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";
		
		given().header("Authorization","Bearer"+ Token)
		
		.when().get("https://api.github.com/users/repos")
		
		.then().statusCode(200).log().all();
	}
	
	@Test
	void BasicAuthOne() {
		
		
		given().auth().basic("user", "passwd")
		
		.when().get("https://httpbin.org/basic-auth/user/passwd")
		
		.then().statusCode(200).log().all();
	}

}
