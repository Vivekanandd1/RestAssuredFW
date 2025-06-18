package API.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import API.Payload.User;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserEndpoints {
	
	public static Response CreateUser(User Payload){
		Response response = given().header("api_key", "special-key").contentType(ContentType.JSON).accept(ContentType.JSON).body(Payload)
		
		.when().post(Routes.Post_URL);
		
		return response;
	}
	
	public static Response ReadUser(String username){
		Response response = given().header("api_key", "special-key").pathParam("username", username)
		
		.when().get(Routes.Get_URL);
		
		return response;
	}
	
	public static Response UpdateUser(String username, User Payload){
		Response response = given().header("api_key", "special-key").contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", username).body(Payload)
		
		.when().put(Routes.Update_URL);
		
		return response;
	}
	
	public static Response DeleteUser(String username){
		Response response = given().header("api_key", "special-key").pathParam("username", username)
		
		.when().delete(Routes.Delete_URL);
		
		return response;
	}

}
