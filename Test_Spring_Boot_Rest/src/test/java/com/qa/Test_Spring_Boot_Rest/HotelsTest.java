package com.qa.Test_Spring_Boot_Rest;

import static io.restassured.RestAssured.given;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class HotelsTest {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	private JSONObject params;
	
	@Before
	public void setup() {
		//RequestSpecification allows you to specify how the request will look
		request = given().contentType(ContentType.JSON);
	}
	
	@Test

	public void testGet() {
		
		response = request.when().get("http://localhost:8090/example/v1/hotels?page=0&size=100");
		System.out.println(response.getStatusCode());
		assertEquals(200, response.getStatusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Test
	public void testPost() {
		
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
	
	@Test
	@Ignore
	public void testDelete() {
		int id = 25;
		response = request.delete("http://localhost:8090/example/v1/hotels/" + id);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPeek());
		assertEquals(204, response.getStatusCode());
		
	}
	
	@Test
	public void testGetById() {
		int id = 22;
		response = request.when().get("http://localhost:8090/example/v1/hotels/" + id);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPeek());
		
		assertEquals(200, response.getStatusCode());
	}
	
	@Test
	public void testPut() {
		
		params = new JSONObject();
		
		params.put("city", "Amstelveen");
		params.put("description", "City 10 miles just south of Amsterdam. Lovely city.");
		params.put("id", 23);
		params.put("name", "Amstelveen");
		params.put("rating", 4.5);
		
		request.body(params.toString());
		
		response = request.put("http://localhost:8090/example/v1/hotels/23");
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPeek());
		
		assertEquals(204, response.getStatusCode());
		
	}
}
