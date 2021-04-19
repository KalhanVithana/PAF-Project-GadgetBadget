package com.user.User.TestCase.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestCase {
	
	
	@org.junit.Test
	public void test_UserCreate() {
		
		given()
		
		.when()
			.get("http://localhost:8082/User/webapi/acc/regi")
			
		.then()
			.statusCode(200);
	}
	
	

	@org.junit.Test
	public void test_Users() {
		
		given()
		
		.when()
			.get("http://localhost:8082/User/webapi/acc")
			
		.then()
			.statusCode(200);
	}
	
	@org.junit.Test
	public void test_User() {
		
		given()
		
		.when()
			.get("http://localhost:8082/User/webapi/acc/a/1")
			
		.then()
			.statusCode(200)
			.log().body()
			.body("id", equalTo(1));
	}
	

	
	
}
