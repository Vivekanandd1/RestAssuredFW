package NewFW;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class FileUpload {
	
	@Test
	public void flupld() {
		
		File samplefile = new File("C:\\Users\\Admin\\Desktop\\File.txt");
		File samplefile1 = new File("C:\\Users\\Admin\\Desktop\\File1.txt");
		 RequestSpecification res =  RestAssured.given();
		 res.baseUri("http://httpbin.org/post");
		 /*Takeaway: Content Type has to be multipart/form-data in file upload case	*/
		 res.contentType("mutlipart/form-data");
		 Response resp = res.body(samplefile).body(samplefile1).post();
		 
		 resp.prettyPrint();
		 
		 Assert.assertEquals(resp.statusCode(), 200);
	}

}
