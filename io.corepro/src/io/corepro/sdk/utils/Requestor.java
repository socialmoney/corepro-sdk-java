package io.corepro.sdk.utils;

import io.corepro.sdk.Connection;
import io.corepro.sdk.CoreProApiException;
import io.corepro.sdk.CoreProError;
import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.UUID;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;


public class Requestor {
	
	public static X509TrustManager[] trustAllCertificates = new X509TrustManager[] {
		new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
			public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}
			public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}
		}
	};

	public static void initTrustManager(X509TrustManager[] trustManager) throws KeyManagementException, NoSuchAlgorithmException{
		if (trustManager != null){
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustManager, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		}
	}
	
	private static HostnameVerifier acceptAnyHostName() {
		return new HostnameVerifier() {
			public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession){
				return true;
			}
		};
	}
	
	public static void acceptAnySslCert() throws KeyManagementException, NoSuchAlgorithmException {
		HttpsURLConnection.setDefaultHostnameVerifier(acceptAnyHostName());
		Requestor.initTrustManager(Requestor.trustAllCertificates);
	}
	
	private static String __proxyHostName;
	private static int __proxyPort;

	public static void useProxy(String proxyHostName, int proxyPort){
		__proxyHostName = proxyHostName;
		__proxyPort = proxyPort;
	}

    private static String __defaultDomainName;
    public static String getDefaultDomainName() throws Exception {
        if (__defaultDomainName == null || __defaultDomainName.trim().equals("")) {
        	__defaultDomainName = Util.readProperty("DomainName");
        }
        return __defaultDomainName;
    }
    public static void setDefaultDomainName(String value) {
        __defaultDomainName = value;
    }

    static final String SDK_USER_AGENT = "CorePro Java SDK v1.0";

    
    public static <T> T performGet(String relativeUrl, Connection connectionInfo, Envelope<T> envelope, Type envelopeType, Object userDefinedObjectForLogging) throws CoreProApiException {
		if (connectionInfo == null){
			connectionInfo = Connection.createFromConfig(null,  null,  null);
		}
		if (connectionInfo.getProxyHost() != null && connectionInfo.getProxyHost() != ""){
			__proxyHostName = connectionInfo.getProxyHost();
			__proxyPort = connectionInfo.getProxyPort();
		}
    	String url = "https://" + connectionInfo.getDomainName() + "/" + relativeUrl;
    	
    	try {
    	
	    	HttpURLConnection conn = null;
	    	if (__proxyHostName != null){
	    		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(__proxyHostName, __proxyPort));
	        	conn = (HttpURLConnection)(new URL(url).openConnection(proxy));
	    	} else {
	        	conn = (HttpURLConnection)(new URL(url).openConnection());
	    	}
	    	
	
	    	conn.setRequestMethod("GET");
	    	conn.addRequestProperty("Accept", "application/json; charset=utf-8");
	    	conn.addRequestProperty("Content-Type", "application/json; charset=utf-8");
	    	conn.addRequestProperty("User-Agent", SDK_USER_AGENT);
			conn.addRequestProperty("Authorization", connectionInfo.getHeaderValue());
	    	return send(conn, connectionInfo, null, "json", envelope, envelopeType, userDefinedObjectForLogging);
    	} catch (Exception ex){
    		throw new CoreProApiException(ex, null);
    	}
    }


    
    public static <T> T performPost(String relativeUrl, Connection connectionInfo, Object toPost, Envelope<T> envelope, Type envelopeType, Object userDefinedObjectForLogging) throws CoreProApiException {
		if (connectionInfo == null){
			connectionInfo = Connection.createFromConfig(null,  null,  null);
		}
		if (connectionInfo.getProxyHost() != null && connectionInfo.getProxyHost() != ""){
			__proxyHostName = connectionInfo.getProxyHost();
			__proxyPort = connectionInfo.getProxyPort();
		}
    	String url = "https://" + connectionInfo.getDomainName() + "/" + relativeUrl;

    	try {
	    	HttpURLConnection conn = null;
	    	if (__proxyHostName != null){
	    		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(__proxyHostName, __proxyPort));
	        	conn = (HttpURLConnection)(new URL(url).openConnection(proxy));
	    	} else {
	        	conn = (HttpURLConnection)(new URL(url).openConnection());
	    	}
	    	
	    	conn.setRequestMethod("POST");
	    	conn.addRequestProperty("Accept", "application/json; charset=utf-8");
	    	conn.addRequestProperty("Content-Type", "application/json; charset=utf-8");
	    	conn.addRequestProperty("User-Agent", SDK_USER_AGENT);
			conn.addRequestProperty("Authorization", connectionInfo.getHeaderValue());
	    	
	    	String body = Util.toJson(toPost);
	    	
	    	if (body != null && body.trim().length() > 0){
	    		conn.setDoOutput(true);
	    		// write body to request stream
	    		OutputStream output = null;
	    		try {
	    			 output = conn.getOutputStream();
	    			 output.write(body.getBytes("UTF-8"));
	    		} finally {
	    			 if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
	    		}
	    		
	    	}
			
			return send(conn, connectionInfo, body, "json", envelope, envelopeType, userDefinedObjectForLogging);
    	} catch (Exception ex){
    		throw new CoreProApiException(ex, null);
    	}
			
    }

    
    private static <T> T send(HttpURLConnection conn, Connection connectionInfo, String requestBody, String format, Envelope<T> envelope, Type envelopeType, Object userDefinedObjectForLogging) throws IOException, HttpRequestException, CoreProApiException{
		// fire off request, wait for status response

    	String responseBody = null;
		StringWriter writer = new StringWriter();
		InputStream response = null;
		BufferedReader reader = null;
		try {
			
			int status = conn.getResponseCode();
			if (status >= 200 && status <= 299){
				response = conn.getInputStream();

				reader = new BufferedReader(new InputStreamReader(response, "UTF-8"));
				for (String line; (line = reader.readLine()) != null;) {
					writer.write(line);
					writer.write("\n");
				}
				responseBody = writer.toString();


		    	return parseResponse(conn, status, format, requestBody, responseBody, envelope, envelopeType, userDefinedObjectForLogging);

			} else {
				// failed. grab error info, throw
				response = conn.getErrorStream();

				reader = new BufferedReader(new InputStreamReader(response, "UTF-8"));
				for (String line; (line = reader.readLine()) != null;) {
					writer.write(line);
					writer.write("\n");
				}
				responseBody = writer.toString();

				return parseResponse(conn, status, format, requestBody, responseBody, envelope, envelopeType, userDefinedObjectForLogging);
			}
		} finally {
			if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
		}
    }
    
    private static<T> T parseResponse(HttpURLConnection conn, int statusCode, String format, String requestBody, String responseBody, Envelope<T> envelope, Type envelopeType, Object userDefinedObjectForLogging) throws CoreProApiException {

    	switch (statusCode){
	    	case 501:
	        	envelope.getErrors().add(new CoreProError(50501, "Not Implemented"));
	        	break;
	    	case 502:
	        	envelope.getErrors().add(new CoreProError(50502, "Bad Gateway"));
	        	break;
	    	case 503:
	        	envelope.getErrors().add(new CoreProError(50503, "Service Unavailable"));
	        	break;
	    	case 504:
	        	envelope.getErrors().add(new CoreProError(50504, "Gateway Timeout"));
	        	break;
	    	case 505:
	        	envelope.getErrors().add(new CoreProError(50505, "Http Version Not Supported"));
	        	break;
			default:
				try {
					envelope = Util.fromJson(responseBody, envelopeType);
			    	envelope.setRawRequestBody(requestBody);
			    	envelope.setRawResponseBody(responseBody);
					
					T data = envelope.getData();
					
					if (data != null){
						UUID requestId = envelope.getRequestId();
						
						if (data instanceof ArrayList<?>){
							ArrayList<?> items = (ArrayList<?>)data;
							if (items.size() > 0){
								Method setRequestIdMethod = null;
								Class<? extends Object> cls = items.get(0).getClass();
								Method[] methods = cls.getMethods();
								for(int j=0;j<methods.length;j++){
									if (methods[j].getName() == "setRequestId"){
										setRequestIdMethod = methods[j];
										break;
									}
								}
								
								if (setRequestIdMethod != null){
									for(int i=0;i<items.size();i++){
										Object item = items.get(i);
										setRequestIdMethod.invoke(item, requestId);
									}
								}
							}
						} else if (data instanceof ModelBase){
							Class<? extends Object> cls = data.getClass();
							Method[] methods = cls.getMethods();
							for(int j=0;j<methods.length;j++){
								if (methods[j].getName() == "setRequestId"){
									methods[j].invoke(data, requestId);
									break;
								}
							}
						}
						
						
					}
					
				} catch (Exception ex){
					
				}
				
    	}
		if ((envelope.getErrors() != null && envelope.getErrors().size() > 0) || (envelope.getStatus() != 200 && envelope.getStatus() != 201)){
			throw new CoreProApiException(envelope.getErrors(), envelope.getStatus(), envelope.getRawResponseBody());
		} else {
			return envelope.getData();
		}
    	
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
