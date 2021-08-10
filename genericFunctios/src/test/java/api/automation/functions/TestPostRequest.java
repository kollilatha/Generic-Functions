package api.automation.functions;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import api.automation.pojo.userPojo;
import api.automation.utils.RestUtils;
import io.restassured.response.Response;
public class TestPostRequest {

	@Test
	public void addUser()
	{
		String url="https://reqres.in/api/users";
		RestUtils restutils=new RestUtils();
		
		userPojo users=new userPojo();
		
		Map<String ,String > testdatas=new HashMap<String, String>();
		testdatas.put("first_name","kolli");
		testdatas.put("last_name","latha");
		testdatas.put("email","kollilatha97@gmail.com");
		testdatas.put("avatar","https://reqres.in/img/faces/7-image.jpg");
		testdatas.put("id","18");
		testdatas.put("page","2");
		testdatas.put("per_page","6");
		testdatas.put("total","12");
		testdatas.put("total_pages","2");
		
		
		
		String payload=users.getuserPayload(testdatas);
		Response res=restutils.post(url,payload);
		res.prettyPrint();
	}
	
}
