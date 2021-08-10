package api.automation.helper;

import java.util.HashMap;
import java.util.Map;

import api.automation.pojo.userPojo;
import api.automation.utils.RestUtils;
import api.automation.utils.URLGenerator;
import io.restassured.response.Response;

public class userManagementHelper {

	String baseUrl;
	RestUtils utils;
	URLGenerator urlgenerator;
	userPojo userPojo;
	
	public userManagementHelper(String baseUrl)
	{
		this.baseUrl=baseUrl;
		utils=new RestUtils();
		urlgenerator=new URLGenerator(baseUrl);
		userPojo=new userPojo();
	}
	public Response getSpecificUserDetails(Map<String,String>  testdata) throws Exception
	{
		Response response ;
		int id=Integer.parseInt(testdata.get("id"));
		
		try {
			response=utils.get(urlgenerator.getUsers+"/"+id);
			
			if(response.getStatusCode()!=200) {
				throw new Exception ("failed to get user details"+id+"and using API"+urlgenerator.getUsers+"/"+id+"and response body is"+response.getBody().asString());
			}
				
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return response;
	}
	
	public Response getallUser() throws Exception
	{
		Response response ;
		
		String key="page";
		int value=2;
		
		Map<String ,Integer> map=new HashMap<String ,Integer>();
		map.put(key, value);
		
		try {
			response=utils.getwithparam(urlgenerator.getUsers,map);
			
			if(response.getStatusCode()!=200) {
				throw new Exception ("failed to get user details and using API"+urlgenerator.getUsers+"and response body is"+response.getBody().asString());
			}
				
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return response;
	}
	
	public Response addnewUser(Map<String,String>  testdata) throws Exception
	{
		Response response ;
		String payload=userPojo.getuserPayload(testdata);
		
		try {
			
			response=utils.post(urlgenerator.addUsers, payload);
			
			if(response.getStatusCode()!=201) {
				throw new Exception ("failed to add new  user details using API"+urlgenerator.addUsers+"and response body is"+response.getBody().asString());
			}
				
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return response;
	}
}
