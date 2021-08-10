package api.automation.functions;



import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import api.automation.pojo.userPojo;
import api.automation.utils.RestUtils;
import io.restassured.response.Response;

public class TestGetRequest {

	
	@Test
	public void getUsers()
	{
		String url="https://reqres.in/api/users";
		String key="page";
		int value=1;
		RestUtils restutils=new RestUtils();
		
		Map<String ,Integer> map=new HashMap<String ,Integer>();
		map.put(key, value);
		 	
		Response res=restutils.getwithparam(url,map);
		res.prettyPrint();
	}
	
	
	
}
