/*
 * Copyright (C) 2017 Q2 Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
				return prop.getProperty(propertyName);
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
