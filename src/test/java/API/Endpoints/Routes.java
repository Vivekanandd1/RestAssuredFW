package API.Endpoints;

/*Main URL: https://petstore.swagger.io
 Create User(Post): https://petstore.swagger.io/v2/user
 Get User(Get): https://petstore.swagger.io/v2/user/{UserName}
 Delete User(Delete): https://petstore.swagger.io/v2/user/{UserName}
 Update User(Update): https://petstore.swagger.io/v2/user/{UserName}
 */

public class Routes {


	public static String Base_URL = "https://petstore.swagger.io/v2";
	public static String Post_URL = Base_URL+"/user";
	public static String Get_URL = Base_URL+"/user/{username}";
	public static String Delete_URL = Base_URL+"/user/{username}";
	public static String Update_URL = Base_URL+"/user/{username}";
	
}
