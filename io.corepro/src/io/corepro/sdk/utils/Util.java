package io.corepro.sdk.utils;

import io.corepro.sdk.CoreProApiException;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Util {
	
	public static boolean IsNullOrEmpty(String value){
		return value == null || value.trim().length() == 0;
	}
	
	public static <T> T fromJson(String json, Type t){
		Gson gson = new GsonBuilder().create();
		return gson.<T>fromJson(json, t);
	}
	
	public static String toJson(Object o) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(o);
	}
	
	public static String readProperty(String propertyName) throws CoreProApiException {
		try {
			Properties prop = new Properties();
			File dir = new File(".");
			String path = dir.getCanonicalPath() + File.separatorChar + "app.properties";
			File file = new File(path);
			if (file.exists()){
				FileInputStream infile = new FileInputStream(file.getAbsolutePath());
				prop.load(infile);
				String rv = prop.getProperty(propertyName);
				return rv;
			} else {
				return null;
			}
		} catch (java.lang.Exception ex){
			throw new CoreProApiException(ex, "Could not read value for " + propertyName + " from app.properties file. Reason: " + ex.getMessage() );
		}
	}
	
	public static Long getSecondsSinceUnixEpoch(int minutesFromNow){
		Long rv = System.currentTimeMillis() / 1000L;
		if (minutesFromNow != 0){
			rv = rv + (minutesFromNow * 60);
		}
		return rv;
	}
}
