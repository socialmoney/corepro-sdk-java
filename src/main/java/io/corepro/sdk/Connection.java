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
	private String proxyServerName;
	private Integer proxyPort;
	
	public Connection() {
		
	}
	
	public Connection(String apiKey, String apiSecret, String domainName){
		setApiKey(apiKey);
		setApiSecret(apiSecret);
		setDomainName(domainName);
	}

	public Connection(String apiKey, String apiSecret, String domainName, String proxyServerName, Integer proxyPort){
		this(apiKey, apiSecret, domainName);
		setProxyServerName(proxyServerName);
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
		
		c.setProxyServerName(Util.readProperty("CoreProProxyServerName"));
		try {
			Integer val = Integer.parseInt(Util.readProperty("CoreProProxyPort") + "");
			c.setProxyPort(val);
		} catch (Exception ex){
			// eat any integer parsing errors here
		}
		
		if (c.getDomainName() == null || c.getDomainName().equals("")){
			c.setDomainName("api.corepro.io");
		}
		
		return c;
	}
	
	private static String normalizeDomainName(String value){

        // given "https://domainname.tld" or "http://domainname.tld/page123" or "//domainname.tld/mypagehere?page=1" or "domainname.tld", return just "domainname.tld"
		
		String rv = value;
		if (rv != null && !rv.equals("")){
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
                if (getApiKey() == null || getApiKey().equals("") || getApiSecret() == null || getApiSecret().equals("")) {
                    throw new NullPointerException("Both apiKey and apiSecret must be specified when making a CorePro request");
                }

                String rawHeader = getApiKey() + ":" + getApiSecret();
                byte[] bytes = rawHeader.getBytes("UTF-8");
                String b64 = Base64.encode(bytes);

                this.headerValue = "Basic " + b64;
            } catch (NullPointerException npe){
                Logger.write(npe, null, null);
                throw npe;
			} catch (Exception ex){
				Logger.write(ex, null, null);
			}
			
		}
		return headerValue;
	}

	public String getProxyServerName() {
		return proxyServerName;
	}

	public void setProxyServerName(String proxyServerName) {
		this.proxyServerName = proxyServerName;
	}

	public Integer getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(Integer proxyPort) {
		this.proxyPort = proxyPort;
	}

}
