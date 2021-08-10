package api.automation.userManagent;




import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.automation.helper.GenericHelper;
import api.automation.helper.userManagementHelper;
import api.automation.pojo.userPojo;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUser {

	
	GenericHelper helpwer;
	Properties properties;
	String baseURL;
	userManagementHelper usermanagemnet;


	@BeforeClass

	public void setUp() throws IOException
	{

		helpwer=new GenericHelper();
		properties=helpwer.loadProperties("config");
		baseURL=properties.getProperty("baseUrl");
		usermanagemnet=new userManagementHelper(baseURL);
		
		
	}
	
	@Test(enabled=false)
	public void getUserDetails() throws Exception
	{
		Map<String ,String> testdata=new HashMap<String ,String>();
		testdata=helpwer.readJsonFile("getspecificuser","userManagement.json","userManagement");
		Response response;
		response =usermanagemnet.getSpecificUserDetails(testdata);
		response.prettyPrint();
		
		int statuscode=response.getStatusCode();
		
		
		String email=JsonPath.from(response.getBody().asString()).get("data.email").toString();
		String fname=JsonPath.from(response.getBody().asString()).get("data.first_name").toString();
		String lname=JsonPath.from(response.getBody().asString()).get("data.last_name").toString();
		
		assertThat((new Object[] {Integer.parseInt(testdata.get("expectedstatuscode")),testdata.get("expectedemail"),testdata.get("expectedfirst_name"),testdata.get("expectedlast_name")}),
				is(new Object[] {statuscode,email,fname,lname}));
	
	
	
	}
	@Test
	public void addnewUser() throws Exception,FileNotFoundException
	{
		Response response;
		
		//by hitting get users api we are trying to get users count 
		Response alluser=usermanagemnet.getallUser();
		List<String> fnames=JsonPath.from(alluser.getBody().asString()).get("data.first_name");
			
		int initialusercount=fnames.size();
		System.out.println("initialusercount");

		//reading data fronm json file and storing data in map object
		Map<String ,String> testdata=new HashMap<String ,String>();
		testdata=helpwer.readJsonFile("addUser","userManagement.json","userManagement");
		System.out.println(testdata);

		//we are using above fetehed data to add new user
		response =usermanagemnet.addnewUser(testdata);
		response.prettyPrint();
		
		//fetching status code
		
		int statuscode=response.getStatusCode();
		
		//extracting email,fname,lname from response
		String email1=JsonPath.from(response.getBody().asString()).get("data.email").toString();
		String fnames1=JsonPath.from(response.getBody().asString()).get("data.first_name").toString();
		String lname=JsonPath.from(response.getBody().asString()).get("data.last_name").toString();
	
		
		//after adding new user we are trying to get count by hitting gaetalluser aPi
		Response alluserafteraddingnewUSer=usermanagemnet.getallUser();
		List<String> fnameafteraddingnewUSer=JsonPath.from(alluserafteraddingnewUSer.getBody().asString()).get("data.first_name");
		int afteraddingnewUSer=fnameafteraddingnewUSer.size();
		
		
		//we are doing assertions
		
		assertThat((new Object[] {Integer.parseInt(testdata.get("expectedstatuscode")),testdata.get("expectedemail"),testdata.get("expectedfirst_name"),testdata.get("expectedlast_name"),initialusercount}),
				is(new Object[] {statuscode,email1,fnames1,lname,afteraddingnewUSer}));

	}
}
