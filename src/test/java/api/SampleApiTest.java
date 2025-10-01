package api;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;   // ✅ correct one


import io.restassured.RestAssured;

public class SampleApiTest {
	@Test
	public void testGetUsers() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertTrue(res.asString().contains("email"));
	}
	

}
