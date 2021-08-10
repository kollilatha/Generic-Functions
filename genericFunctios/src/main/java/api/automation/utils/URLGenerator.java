package api.automation.utils;

public class URLGenerator {

	public String getUsers="/users";
	public String addUsers="/users";
	public String updateUser="/users/";
	public String deleteUser="/users";
	
	public URLGenerator(String baseUrl)
	{
		getUsers=baseUrl+getUsers;
		addUsers=baseUrl+addUsers;
		updateUser=baseUrl+updateUser;
		deleteUser=baseUrl+deleteUser;
	}
	
}
