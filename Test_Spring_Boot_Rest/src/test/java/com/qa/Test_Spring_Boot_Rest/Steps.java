package com.qa.Test_Spring_Boot_Rest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.json.JSONObject;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Then;

public class Steps {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	private JSONObject params;
	
	
	@Given("^the website exists$")
	public void the_website_exists() {
		request = given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:8090/swagger-ui.html");
		assertEquals(200, response.getStatusCode());
		
	}
	
	@When("^a user wants to view all hotels$")
	public void a_user_wants_to_view_all_hotels() {
		response = request.when().get("http://localhost:8090/example/v1/hotels?page=0&size=100");
		System.out.println(response.prettyPeek());

	}
	
	@Then("^the status code reads (\\d+)$")
	public void the_status_code_reads(int arg1) {
		assertEquals(arg1, response.getStatusCode());
	}
	
	@When("^the user creates a hotel$")
	public void the_user_creates_a_hotel() {
		params = new JSONObject();
		
		params.put("city", "Amsterdam");
		params.put("description", "Close to the Anne Frank museum.");
		params.put("name", "Amsterdam");
		params.put("rating", 3);
		
		System.out.println(
				request.body(params.toString()						
						));
	
		response = request.post("http://localhost:8090/example/v1/hotels/");
		assertEquals(201, response.getStatusCode());
	}
	
	@Given("^a hotel exists$")
	public void a_hotel_exists() {
		request = given().contentType(ContentType.JSON);

	}

	@When("^user deletes hotel (\\d+)$")
	public void user_deletes_hotel(int arg1) {
		response = request.delete("http://localhost:8090/example/v1/hotels/" + arg1);

	}

	@When("^a user wants specifc hotel (\\d+)$")
	public void a_user_wants_specifc_hotel(int arg1) {
		response = request.when().get("http://localhost:8090/example/v1/hotels/" + arg1);
	}

	@When("^user updates hotel (\\d+)$")
	public void user_updates_hotel(int arg1) {
	params = new JSONObject();
		
		params.put("city", "Amstelveen");
		params.put("description", "City 10 miles just south of Amsterdam. Lovely city.");
		params.put("id", arg1);
		params.put("name", "Amstelveen");
		params.put("rating", 4.5);
		
		request.body(params.toString());
		
		response = request.put("http://localhost:8090/example/v1/hotels/"+ arg1);
	}


}
