package api.automation.utils;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtils {

	public Response get(String url)
	{
		return RestAssured.given()
		.header("Authorization","Bearer")
		.header("Content-Type","application/json")
		.log().all()
		.get(url);
	}
	
	public Response getwithparam(String url,Map<String,Integer> map)
	{
		return RestAssured.given()
		.queryParams(map)
		.log().all()
		.get(url);
	}
	
	public Response post(String url,String body)
	{
		return RestAssured.given()
		.contentType("application/json")
		.log().all()
		.body(body)
		.post(url);
	}

	
	public Response put(String url,String body)
	{
		return RestAssured.given()
		.contentType("application/json")
		.log().all()
		.body(body)
		.put(url);
	}
	
	public Response delete(String url,Map<String,Integer> map)
	{
		return RestAssured.given()
		.queryParams(map)
		.log().all()
		.delete(url);
	}
}
