package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./Configurations\\config.properties");
			prop.load(ip);
		} catch (IOException e) {
			System.out.println("Exception is: " +e.getMessage());
		}
		
	}
	
	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	public String getUserName() {
		String username = prop.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}
	public String getchromePath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	public String getIEPath() {
		String iepath = prop.getProperty("iepath");
		return iepath;
	}
	public String getFirefoxPath() {
		String firefox = prop.getProperty("firefoxpath");
		return firefox;
	}

}
