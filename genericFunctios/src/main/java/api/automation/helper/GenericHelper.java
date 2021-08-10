package api.automation.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class GenericHelper {
	
	public Map<String,String> readJsonFile(String methodName,String jsonFile,String folderName) throws JsonIOException, JsonSyntaxException, FileNotFoundException
	{
		
		String filepath=System.getProperty("user.dir")+File.separator+"Resources"+File.separator+folderName+File.separator+jsonFile;
		JsonElement jsonElement=(new JsonParser()).parse(new FileReader(filepath));
		
		JsonObject jsonobject=jsonElement.getAsJsonObject();
		
		JsonElement element=jsonobject.get(methodName);
		
		JsonObject jobj=element.getAsJsonObject();
		Map<String,String> map=new HashMap<String,String>();
		
		Iterator iterator=jobj.entrySet().iterator();
		
		
		while(iterator.hasNext()) {
			Entry entry=(Entry)iterator.next();
			
			map.put(entry.getKey().toString(), entry.getValue().toString().replace("\"", ""));
		}
		
		return map;
		
	}
	
	public  Properties loadProperties(String filename ) throws IOException
	{
	String path=System.getProperty("user.dir")+File.separator+"resources"+File.separator+filename+".properties";
	
	File file=new File(path);
	FileInputStream fin=new FileInputStream(file);
	
	Properties prop=new Properties();
	prop.load(fin);
	return prop;
	 
		
	}
	
	

	}
