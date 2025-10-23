package NewFW;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqMaps {
	
	@Test
	public void AuthToken() {
		Map<String,String> creds = new HashMap<>();
		creds.put("username", "admin");
		creds.put("password", "password123");
		
		 Response resp = RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/auth")
		.contentType("application/json").body(creds).post();
		 
		 resp.prettyPrint();
	}
	
	@Test
	public void Usercrate() {
		Map<String,Object> creds = new HashMap<>();
		
		Map<String,String> Home = new HashMap<>();
		Home.put("addressType", "Home");
		Home.put("Location", "Town");
		
		Map<String,String> Office = new HashMap<>();
		Office.put("addressType", "Office");
		Office.put("Location", "City");
		Object[] Arr = {Home,Office};
		creds.put("name", "marcus");
		creds.put("job", "leader");
		creds.put("IsMarried", true);
		creds.put("Address", Arr);
		creds.put("Skills", Arrays.asList("Java","Selenium", "Postaman"));
		
		 Response resp = RestAssured.given().header("x-api-key","reqres-free-v1").baseUri("https://reqres.in").basePath("/api/users")
		.contentType("application/json").body(creds).post();
		 
		 resp.prettyPrint();
	}

}
