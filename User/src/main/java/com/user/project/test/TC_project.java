package com.user.project.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//import com.user.project.test;

public class TC_project {
	@Test
	public void test_getprojects() {
		
		given()
		
		.when()
			.get("http://localhost:8081/User/webapi/project")
			
		.then()
			.statusCode(200);
	}
	@Test
	public void test_postprojects() {
		
		given()
		
		.when()
			.post("http://localhost:8081/User/webapi/project")
			
		.then()
			.statusCode(200);
	}
	
}
