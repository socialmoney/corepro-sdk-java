package io.corepro.sdk;

import java.io.UnsupportedEncodingException;

import io.corepro.sdk.utils.Base64;
import io.corepro.sdk.utils.Logger;
import io.corepro.sdk.utils.Util;

public class Connection {
	
	private String domainName;
	private String apiKey;
	private String apiSecret;
	private String headerValue;
	private String proxyHost;
	private Integer proxyPort;
	
	public Connection() {
		
	}
	
	public Connection(String apiKey, String apiSecret, String domainName){
		setApiKey(apiKey);
		setApiSecret(apiSecret);
		setDomainName(domainName);
	}

	public Connection(String apiKey, String apiSecret, String domainName, String proxyHost, Integer proxyPort){
		this(apiKey, apiSecret, domainName);
		setProxyHost(proxyHost);
		setProxyPort(proxyPort);
	}

	public static Connection createFromConfig(String apiKeyOverride, String apiSecretOverride, String domainNameOverride) throws CoreProApiException {
		Connection c = new Connection();
		if (apiKeyOverride != null){
			c.setApiKey(apiKeyOverride);
		} else {
			c.setApiKey(Util.readProperty("CoreProApiKey"));
		}
		if (apiSecretOverride != null){
			c.setApiSecret(apiSecretOverride);
		} else {
			c.setApiSecret(Util.readProperty("CoreProApiSecret"));
		}
		
		if (domainNameOverride != null){
			c.setDomainName(domainNameOverride);
		} else {
			c.setDomainName(Util.readProperty("CoreProDomainName"));
		}
		
		c.setProxyHost(Util.readProperty("CoreProProxyHost"));
		try {
			Integer val = Integer.parseInt(Util.readProperty("CoreProProxyPort"));
			c.setProxyPort(val);
		} catch (Exception ex){
			// eat any integer parsing errors here
		}
		
		if (c.getDomainName() == null || c.getDomainName() == ""){
			c.setDomainName("api.corepro.io");
		}
		
		return c;
	}
	
	private static String normalizeDomainName(String value){

        // given "https://domainname.tld" or "http://domainname.tld/page123" or "//domainname.tld/mypagehere?page=1" or "domainname.tld", return just "domainname.tld"
		
		String rv = value;
		if (rv != null && rv != ""){
			rv = rv.replace("https://",  "").replace("http://", "").replace("//",  "").split("/")[0];
		}
		
		return rv;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = normalizeDomainName(domainName);
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
		this.headerValue = null;
	}

	public String getHeaderValue() throws UnsupportedEncodingException, NullPointerException {
		if (headerValue == null){
			try {
				if (getApiKey() == null || getApiKey() == "" || getApiSecret() == null || getApiSecret() == "") {
					throw new NullPointerException("Both apiKey and apiSecret must be specified when making a CorePro request");
				}
				
				String rawHeader = getApiKey() + ":" + getApiSecret();
				byte[] bytes = rawHeader.getBytes("UTF-8");
				String b64 = Base64.encode(bytes);
				
				this.headerValue = "Basic " + b64;
				
			} catch (Exception ex){
				Logger.write(ex, null, null);
			}
			
		}
		return headerValue;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public Integer getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(Integer proxyPort) {
		this.proxyPort = proxyPort;
	}

}
