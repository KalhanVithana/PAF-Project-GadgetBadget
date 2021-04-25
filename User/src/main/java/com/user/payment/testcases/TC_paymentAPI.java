package com.user.payment.testcases;


<<<<<<< HEAD
import org.testng.annotations.Test;
=======
import org.testng.Assert;
>>>>>>> branch 'kaveesha' of https://github.com/KalhanVithana/PAF-Project-GadgetBadget.git


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;


//All payment testcases
public class TC_paymentAPI {

	//get all payment testcase
	@Test(priority = 1)
	public void test_getAllPayments() {
		
		given()
		
		.when()
			.get("http://localhost:8085/User/webapi/payments")
			
		.then()
			.statusCode(200)
			.log().body();
	}
	
	
	//get specific payment testcase
	@Test(priority = 2)
	public void test_getSpecificPayment() {
		
		given()
		
		.when()
			.get("http://localhost:8085/User/webapi/payments/payment/1")
			
		.then()
			.statusCode(200)
			.log().body()
			.body("id", equalTo(1));
	}
	
	
	//insert payment testcase
	@Test(priority = 3)
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
			.post("http://localhost:8085/User/webapi/payments/payment")
				
		.then()
			.statusCode(200)
			.log().body();
	}
	

	//update payment testcase
	@Test(priority = 4)
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
			.put("http://localhost:8085/User/webapi/payments/payment")
			
		.then()
			.statusCode(200)
			.log().body();
	}
	
	
	//delete payment testcase
	@Test(priority = 5)
	public void test_deletePayment() {
		
		given()

		.when()
			.delete("http://localhost:8085/User/webapi/payments/payment/6")
			
		.then()
			.statusCode(200)
			.log().body();

	}
	
	

}
