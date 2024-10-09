package api.testcases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoint;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {
/*Test(priority=1,dataProvider = "AllData",dataProviderClass=DataProviders.class)
	public void testCreateUser(String usrtID,String UserName,String fname,String lName,String email,String pwd,String phone)
	{
		
		
		User userPayload = new User();
			
			userPayload.setId(Integer.parseInt(usrtID));
			userPayload.setUsername(UserName);
			userPayload.setFirstName(fname);
			userPayload.setLastName(lName);
			userPayload.setEmail(pwd);
			userPayload.setPassword(email);
			userPayload.setPhone(phone);
		
		Response response = UserEndPoint.createUser(userPayload);
		
		//log response 
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 201);
	}*/
	
	@Test(priority=1, dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String usrtID, String UserName, String fname, String lName, String email, String pwd, String phone) {
	    User userPayload = new User();
	 
	    userPayload.setId(Integer.parseInt(usrtID));
	    userPayload.setUsername(UserName);
	    userPayload.setFirstName(fname);
	    userPayload.setLastName(lName);
	    userPayload.setEmail(email); // Corrected
	    userPayload.setPassword(pwd); // Corrected
	    userPayload.setPhone(phone);
	 
	    Response response = UserEndPoint.createUser(userPayload);
	 
	    // Log response
	    response.then().log().all();
	 
	    // Validation
	    Assert.assertEquals(response.getStatusCode(), 201); // Check for 201 Created status if applicable
	}


	@Test(priority=2, dataProvider = "UserNameData", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username)
	{
		
		Response response = UserEndPoint.DeleteUser(username);
		
		System.out.println("Delete user Data.");
		//log response 
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 201);
	}
	
}
