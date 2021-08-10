package api.automation.userManagent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import api.automation.helper.GenericHelper;

public class TestUserManagement {
public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException {
	
	
	GenericHelper helper=new GenericHelper();
	Map<String,String> map=new HashMap<String, String>();
	
	map=helper.readJsonFile("maths","books.json","libraryManagement");
	System.out.println(map.get("author"));
	
	Properties prop=helper.loadProperties("config");
	System.out.println(prop.get("baseUrl"));
}


}
