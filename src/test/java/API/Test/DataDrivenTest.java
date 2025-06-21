package API.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import API.Endpoints.UserEndpoints;
import API.Payload.User;
import API.Utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {
	
	@Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void TestPostUsers(String UserID, String UserName, String FirstName, String LastName, String Email,String Password, String Phone) throws InterruptedException {
		
		
		Thread.sleep(3000);
		User Payload = new User();
		
		Payload.setId(Integer.parseInt(UserID));
		Payload.setUsername(UserName);
		Payload.setFirstName(FirstName);;
		Payload.setLastName(LastName);;
		Payload.setEmail(Email);
		Payload.setPassword(Password);
		Payload.setPhone(Phone);
		
		Response response = UserEndpoints.CreateUser(Payload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	
	@Test(priority = 2,dataProvider = "UserName",dataProviderClass = DataProviders.class)
	public void TestDeleteUser(String UserName) throws InterruptedException {
		Thread.sleep(3000);
		Response response = UserEndpoints.DeleteUser(UserName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
