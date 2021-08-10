package api.automation.readProperties;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class readProperties {

	
	public static void main(String[] args) throws IOException {
		
		String propertyfile="config";
		Properties pro=loadProperties(propertyfile);
		System.out.println(pro.get("baseUrl"));
	}
	public static Properties loadProperties(String filename ) throws IOException
	{
	String path=System.getProperty("user.dir")+File.separator+"resources"+File.separator+filename+".properties";
	
	File file=new File(path);
	FileInputStream fin=new FileInputStream(file);
	
	Properties prop=new Properties();
	prop.load(fin);
	return prop;
	 
		
	}
}
