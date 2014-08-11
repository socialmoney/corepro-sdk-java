package io.corepro.sdk.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class Logger {
	
	private static String __logFilePath;
	
	public static String getLogFilePath(){
		return __logFilePath;
	}
	
	public static void setLogFilePath(String logFilePath){
		__logFilePath = logFilePath;
	}
	
	private static ILogWriter __registeredLogWriter;
	
	public static void registerLogWriter(ILogWriter logWriter){
		__registeredLogWriter = logWriter;
	}
	
	public static boolean isLogEnabled(){
		return (__logFilePath != null && __logFilePath != "") || __registeredLogWriter != null;
	}
	
	static {
		try {
			__registeredLogWriter = null;
			__logFilePath = Util.readProperty("CoreProLogFilePath");
		} catch (Exception ex){
			// eat any errors reading form app.properties
		}
	}
	
	public static void write(Exception exception, String additionalInfo, Object userDefinedObjectForLogging){
		// TODO: write log here
		
		Date timestamp = new Date();
		long threadId = Thread.currentThread().getId();
		
		if (__registeredLogWriter != null){
			try {
				__registeredLogWriter.write(timestamp, threadId, exception, additionalInfo, userDefinedObjectForLogging);
			} catch (Exception ex){
				// eat errors??
			}
		}
		
		if (isLogEnabled()){
			try {
				writeToLogFile(timestamp, threadId, exception.getMessage() + ". " + additionalInfo + ". " + exception.getStackTrace(), userDefinedObjectForLogging);
			} catch (IOException ioe) {
				// eat errors??
			}
		}
		
	}
	
	public static void write(String body, Object userDefinedObjectForLogging) {
		Date timestamp = new Date();
		long threadId = Thread.currentThread().getId();
		
		if (__registeredLogWriter != null){
			try {
				__registeredLogWriter.write(timestamp, threadId, body, userDefinedObjectForLogging);
			} catch (Exception ex){
				// eat errors??
			}
		}
		
		if (isLogEnabled()){
			try {
				writeToLogFile(timestamp, threadId, body, userDefinedObjectForLogging);
			} catch (IOException ioe) {
				// eat errors??
			}
		}
		
	}
	public static void write(HttpURLConnection urlConnection, String body, Object userDefinedObjectForLogging) {
		
		Date timestamp = new Date();
		long threadId = Thread.currentThread().getId();
		
		StringBuilder sb = new StringBuilder();
		sb.append(urlConnection.getURL().toString() + "\n");
		
		sb.append(body);
		
		String output = sb.toString();
		
		if (__registeredLogWriter != null){
			try {
				__registeredLogWriter.write(timestamp, threadId, urlConnection, output, userDefinedObjectForLogging);
			} catch (Exception ex){
				// eat errors??
			}
		}
		
		if (isLogEnabled()){
			try {
				writeToLogFile(timestamp, threadId, output, userDefinedObjectForLogging);
			} catch (IOException ioe) {
				// eat errors??
			}
		}
	}

	
	private static void writeToLogFile(Date timestamp, long threadId, String body, Object userDefinedObjectForLogging) throws IOException{
		String logFilePath = Logger.getLogFilePath();
		if (logFilePath != null && logFilePath != ""){
			Path path = FileSystems.getDefault().getPath(logFilePath);
			if (Files.notExists(path)){
				Files.createFile(path);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#|" + timestamp + "|" + threadId + "|" + body + "|" + userDefinedObjectForLogging + "\n");
			byte[] bytes = sb.toString().getBytes("UTF-8");
			Files.write(path, bytes, StandardOpenOption.APPEND);
		}
	}
}
