package NewFW;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CrudOperations {
	
	
	@BeforeClass
	public void Setup() {
		RequestSpecification res = RestAssured.given();
		res.baseUri("http://localhost:3000");
		res.basePath("/students");
		RestAssured.requestSpecification = res;
	}
	
	@Test
	public void readUsrDt() {
		Response resp = RestAssured.get();
		resp.prettyPrint();
	}
	
	@Test
	public void CreateUsr() {
		
		JSONObject jd = new JSONObject();
		jd.put("studentId", "S005");
		jd.put("firstName", "Vatsal");
		jd.put("lastName", "Deshmukh");
		
		
	  Response	resp = RestAssured.given().header("Content-Type","application/json").contentType(ContentType.JSON).body(jd.toString()).post();
		resp.prettyPrint();
	}


}
