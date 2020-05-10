package com.moonrider.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;


@QuarkusTest
public class ExpensionTrackingResourceTest {

	@Test
	public void getExpenses_shouldReturnStatus200() {
		given()
			.when()
			.get("/expenses")
			.then()
			.statusCode(200);
	}
	
	@Test
	public void getExpenses_shouldReturnPayload() {
		given()
			.when()
			.get("/expenses")
			.then()
			.body(
					"expenseId", notNullValue(),
					"name", notNullValue(),
					"price", notNullValue()
			);
	}
	
}
