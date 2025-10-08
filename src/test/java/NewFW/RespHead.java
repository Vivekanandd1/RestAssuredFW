package NewFW;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RespHead {
	
	@Test
	public void singleUsr() {
		RequestSpecification res = RestAssured.given();
		
		res.baseUri("https://reqres.in/");
		res.basePath("/api/users/2");
		
		 Response resp = res.get();
		 
       String Header =   resp.getHeader("Content-Type");
       System.out.println("The Header is:" + Header);
       
     Headers HeaderList = resp.getHeaders();
     
     for( Header header:HeaderList) {
    	 System.out.println( header.getName()+" : "+ header.getValue());
     }
	}

}
