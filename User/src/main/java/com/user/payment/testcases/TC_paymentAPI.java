package com.user.payment.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;


public class TC_paymentAPI {

	@Test
	public void test_getAllPayments() {
		
		given()
		
		.when()
			.get("http://localhost:8083/User/webapi/payments")
			
		.then()
			.statusCode(200)
			.log().body();
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
	
	
	@Test
	public void test_insertPayment() {
		
		JSONObject data = new JSONObject();
		
		data.put("accountNo", 554698735);
		data.put("amount", 500000.0);
		data.put("buyerName", "Perera");
		data.put("date", "2021-03-11");
		data.put("description", "Processing...");
		data.put("id", 6);
		data.put("type", "Credit");
		

		given()
			.contentType("application/json")
			.body(data)
				
		.when()
			.post("http://localhost:8083/User/webapi/payments/payment")
				
		.then()
			.statusCode(200)
			.log().body();
	}
	

	@Test
	public void test_updatePayment() {

		JSONObject data = new JSONObject();
		
		data.put("accountNo", 554698735);
		data.put("amount", 900000.0);
		data.put("buyerName", "Wijesekara");
		data.put("date", "2021-02-03");
		data.put("description", "Processing...");
		data.put("id", 6);
		data.put("type", "Credit");


		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.put("http://localhost:8083/User/webapi/payments/payment")
			
		.then()
			.statusCode(200)
			.log().body();
	}
	
	
	

}
