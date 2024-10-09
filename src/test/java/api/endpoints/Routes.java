package api.endpoints;

public class Routes {
	
	/*Create Users	Post	https://petstore.swagger.io/v2/user
	Get  Users	Get	https://petstore.swagger.io/v2//user/{username}
	Update Users	Put	https://petstore.swagger.io/v2//user/{username}
	Delete Users	Delete	https://petstore.swagger.io/v2//user/{username}
*/

	public static String base_url = "https://petstore.swagger.io/v2";
	
	// user module  urls
	
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String put_url = base_url + "/user/{username}";
	public static String del_url = base_url + "/user/{username}";
	
	// pet module urls
	
	
	
	//store module urls
}
