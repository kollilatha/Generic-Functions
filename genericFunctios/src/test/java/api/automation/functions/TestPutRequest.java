package api.automation.functions;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import api.automation.pojo.userPojo;
import api.automation.utils.RestUtils;
import io.restassured.response.Response;

public class TestPutRequest {

	

	
	@Test
	public void  updateUser()
	{
		String url="https://reqres.in/api/users/6";
		
		RestUtils restutils=new RestUtils();
		userPojo users=new userPojo();
		

		Map<String ,String> map=new HashMap<String ,String>();
		map.put("first_name", "sonu");
		map.put("last_name", "bommi");
		String payload=users.updateUserPayload(map);
		
		Response res=restutils.put(url,payload);
		res.prettyPrint();
	}
}
