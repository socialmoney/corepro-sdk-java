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
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.*;


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
    	String url = "https://" + connectionInfo.getDomainName() + "/" + relativeUrl;
    	
    	try {

	    	HttpsURLConnection conn;
            if (connectionInfo.getProxyServerName() != null && !connectionInfo.getProxyServerName().equals("")
                    && connectionInfo.getProxyPort() != null && connectionInfo.getProxyPort() > 0){
	    		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(connectionInfo.getProxyServerName(), connectionInfo.getProxyPort()));
	        	conn = (HttpsURLConnection)(new URL(url).openConnection(proxy));
	    	} else {
	        	conn = (HttpsURLConnection)(new URL(url).openConnection());
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
    	String url = "https://" + connectionInfo.getDomainName() + "/" + relativeUrl;

    	try {
			HttpURLConnection conn;
			if (connectionInfo.getProxyServerName() != null && !connectionInfo.getProxyServerName().equals("")
					&& connectionInfo.getProxyPort() != null && connectionInfo.getProxyPort() > 0) {
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(connectionInfo.getProxyServerName(), connectionInfo.getProxyPort()));
				conn = (HttpURLConnection) (new URL(url).openConnection(proxy));
			} else {
				conn = (HttpURLConnection) (new URL(url).openConnection());
			}

			conn.setRequestMethod("POST");
			conn.addRequestProperty("Accept", "application/json; charset=utf-8");
			conn.addRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.addRequestProperty("User-Agent", SDK_USER_AGENT);
			conn.addRequestProperty("Authorization", connectionInfo.getHeaderValue());

			String body = Util.toJson(toPost);

			if (body != null && body.trim().length() > 0) {
				conn.setDoOutput(true);
				// write body to request stream
				OutputStream output = null;
				try {
					output = conn.getOutputStream();
					output.write(body.getBytes("UTF-8"));
				} finally {
					if (output != null) try {
						output.close();
					} catch (IOException logOrIgnore) {
					}
				}

			}

			return send(conn, connectionInfo, body, "json", envelope, envelopeType, userDefinedObjectForLogging);
		} catch (CoreProApiException cpex){
    		// make sure we don't wrap a CoreProApiException inside a new one; just rethrow it.
    		throw cpex;
    	} catch (Exception ex){
    		throw new CoreProApiException(ex, null);
    	}
			
    }

    
    private static <T> T send(HttpURLConnection conn, Connection connectionInfo, String requestBody, String format, Envelope<T> envelope, Type envelopeType, Object userDefinedObjectForLogging) throws IOException, HttpRequestException, CoreProApiException{
		// fire off request, wait for status response

    	String responseBody;
		StringWriter writer = new StringWriter();
		InputStream response;
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

    private static String dateFix(String input){
    	String rv = "";

    	String flatInput = input.replace("\n", "").replace("\r", "");
    	StringBuilder sb = new StringBuilder();

    	// testing... flatInput = "abc 1976-07-04T00:00:00+00:00 def 2016-08-08T11:33:33.2118667-05:00 ghi";
    	// example of correct format: 2016-08-22T00:00:00.123-04:00

    	// eg: 2016-08-22T00:00:00-04:00
    	String noMilliseconds = "(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2})([-+]\\d{2}:\\d{2})";
    	Pattern p1 = Pattern.compile(noMilliseconds);
    	try {
			Matcher m1 = p1.matcher(flatInput);
			int endPos = 0;
			while (m1.find()){
				sb.append(flatInput.substring(endPos, m1.start()));
				sb.append(m1.group(1));
				sb.append(".000");
				sb.append(m1.group(2));
				endPos = m1.end();
			}
			if (endPos < flatInput.length()){
				sb.append(flatInput.substring(endPos));
			}
			//rv = m1.replaceAll(m1.group(0) + ".000" + m1.group(1));
		} catch (IllegalStateException ise) {
    		// no match found. just use input value.
    		sb.append(flatInput);
		}


		flatInput = sb.toString();
		sb = new StringBuilder();



		// eg: 2016-08-22T00:00:00.1234567-04:00
		try {
			String extraMilliseconds = "(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\d{1,4}([-+]\\d{2}:\\d{2})";
			Pattern p2 = Pattern.compile(extraMilliseconds);
			Matcher m2 = p2.matcher(flatInput);
			int endPos = 0;
			while (m2.find()){
				sb.append(flatInput.substring(endPos, m2.start()));
				sb.append(m2.group(1));
				sb.append(m2.group(2));
				endPos = m2.end();
			}
			if (endPos < flatInput.length()){
				sb.append(flatInput.substring(endPos));
			}
			//rv = m2.replaceAll(m2.group(0) + m2.group(1));
		} catch (IllegalStateException ise) {
			// no match found. ignore.
		}

    	return sb.toString();
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
					// HACK: corepro date formatting is currently not consistent with documentation.
					//       to compensate, this temporary hack is in place.
					String modifiedResponseBody = dateFix(responseBody);
					envelope = Util.fromJson(modifiedResponseBody, envelopeType);
			    	envelope.setRawRequestBody(modifiedResponseBody);
			    	envelope.setRawResponseBody(modifiedResponseBody);
					
					T data = envelope.getData();
					
					if (data != null){
						UUID requestId = envelope.getRequestId();
						
						if (data instanceof List<?>){
							List<?> items = (List<?>)data;
							if (items.size() > 0){
								Method setRequestIdMethod = null;
								Class<? extends Object> cls = items.get(0).getClass();
								Method[] methods = cls.getMethods();
								for(Method m : methods){
									if (m.getName().equals("setRequestId")){
										setRequestIdMethod = m;
										break;
									}
								}

								if (setRequestIdMethod != null){
									for(Object item : items){
										setRequestIdMethod.invoke(item, requestId);
									}
								}
							}
						} else if (data instanceof ModelBase){
							Class<? extends Object> cls = data.getClass();
							Method[] methods = cls.getMethods();
							for(Method m : methods){
								if (m.getName().equals("setRequestId")){
									m.invoke(data, requestId);
								}
							}
						}
						
						
					}
					
				} catch (Exception ex){
					System.out.println(ex.getMessage());
				}
				
    	}
		if ((envelope.getErrors() != null && envelope.getErrors().size() > 0) || (envelope.getStatus() != 200 && envelope.getStatus() != 201)){
			throw new CoreProApiException(envelope.getErrors(), envelope.getStatus(), envelope.getRawResponseBody());
		} else {
			return envelope.getData();
		}
    	
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
