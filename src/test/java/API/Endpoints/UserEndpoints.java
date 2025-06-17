package API.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import API.Payload.User;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserEndpoints {
	
	public static Response CreateUser(User Payload){
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(Payload)
		
		.when().post(Routes.Post_URL);
		
		return response;
	}
	
	public static Response ReasdUser(String UserName){
		Response response = given().pathParam("UserName", UserName)
		
		.when().get(Routes.Get_URL);
		
		return response;
	}
	
	public static Response UpdateUser(String UserName, User Payload){
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("UserName",UserName).body(Payload)
		
		.when().post(Routes.Update_URL);
		
		return response;
	}
	
	public static Response DeleteUser(String UserName){
		Response response = given().pathParam("UserName", UserName)
		
		.when().delete(Routes.Delete_URL);
		
		return response;
	}

}
