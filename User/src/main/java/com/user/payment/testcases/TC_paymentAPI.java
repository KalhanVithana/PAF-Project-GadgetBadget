package com.user.payment.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_paymentAPI {

	@Test
	public void test_getAllPayments() {
		
		given()
		
		.when()
			.get("http://localhost:8083/User/webapi/payments/payment/1")
			
		.then()
			.statusCode(200);
	}
	
	@Test
	public void test_getSpecificPayment() {
		
		given()
		
		.when()
			.get("http://localhost:8083/User/webapi/payments/payment/1")
			
		.then()
			.statusCode(200)
			.log().body()
			.body("id", equalTo(1));
	}

}
