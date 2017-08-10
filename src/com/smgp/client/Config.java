package com.smgp.client;
 
import java.io.FileInputStream;
import java.io.IOException; 
import java.util.HashMap;
import java.util.Properties;
 

public class Config {
	 
    private String configFile = "classPath:properties/smgp.properties";
	 private  HashMap <String,String> configproperty=new HashMap<String,String>();
	 
   public Config() throws IOException {
  	 this.ReadProperty(configFile);
   }
	 public  Config(String configFile2) throws IOException {
		// TODO Auto-generated method stub
		 this.ReadProperty(configFile2);
	}
	private  void ReadProperty(String cfile) throws IOException{
		
		
		Properties properties = new Properties();
		String base = Config.class.getResource("/")
				.getPath();
		try {
			properties.load(new FileInputStream(base
					+ "properties/smgp.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		configproperty.put("smgwip",properties.getProperty("smgwip").trim());
		configproperty.put("smgwport",properties.getProperty("smgwport").trim());
		configproperty.put("smgwaccount",properties.getProperty("smgwaccount").trim());
		configproperty.put("smgwpasswd",properties.getProperty("smgwpasswd").trim());
		configproperty.put("smgwspid",properties.getProperty("smgwspid").trim());
		configproperty.put("smgpspnum",properties.getProperty("smgpspnum").trim());
		configproperty.put("productid",properties.getProperty("productid").trim());
		 
	 }
	public  String get(String key){
		return configproperty.get(key);
	}
}