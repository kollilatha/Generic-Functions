package api.automation.functions;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import api.automation.pojo.userPojo;
import api.automation.utils.RestUtils;
import io.restassured.response.Response;

public class TestDeleteRequest {

	@Test
	public void delUser()
	{
		String url="https://reqres.in/api/users";
		
		RestUtils restutils=new RestUtils();
		
		
		Map<String ,Integer> map=new HashMap<String ,Integer>();
		map.put("id", 1);
		
		Response res=restutils.delete(url, map);
		res.prettyPrint();
	
	}
}
