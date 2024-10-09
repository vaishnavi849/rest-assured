package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	User userPayload;
	@BeforeClass()
	public void generateTestData()
	{
		faker = new Faker();
	 userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	public void testCreateUser()
	{
		Response response = UserEndPoint.createUser(userPayload);
		
		//log response 
		response.then().log().all();
		
		//validayion
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGetUserData()
	{
		Response response = UserEndPoint.GetUser(this.userPayload.getUsername());
		
		System.out.println("Read user Data.");
		//log response 
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateUser()
	{
		userPayload.setFirstName(faker.name().firstName());
		Response response = UserEndPoint.UpdateUser(this.userPayload.getUsername(),userPayload);
		
		
		//log response 
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Read User to check if first name is updated
		Response responsepostUpdate = UserEndPoint.UpdateUser(this.userPayload.getUsername(),userPayload);
		System.out.println(" After Update user Data.");
		responsepostUpdate.then().log().all();
	}
	
	@Test(priority=4)
	public void testDeleteUser()
	{
		
		Response response = UserEndPoint.DeleteUser(this.userPayload.getUsername());
		
		System.out.println("Delete user Data.");
		//log response 
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}

