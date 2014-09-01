package io.corepro.sdk;

import io.corepro.sdk.utils.Requestor;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		// configure Requestor to handle SSL certs the "default" way (i.e. accept it as long as the domain name is correct)
		try {
			Requestor.acceptAnySslCert();
		} catch (KeyManagementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		// for testing, you can use Fiddler web proxy
		// Requestor.useProxy("localhost",  8888);
		
		try {
			int customerId = 2654;    // need a valid customerId here
//			String apiKey = "";    // need a valid API Key here
//			String apiSecret = ""; // need a valid API Secret here
//			String domainName = "sandbox-api.corepro.io";
			
			Connection connection = null; //new Connection(apiKey, apiSecret, domainName);
			
			// example: list all accounts for the given customer
			ArrayList<Account> accounts = Account.list(customerId, connection, null);
			for(int i=0;i<accounts.size();i++){
				Account a = accounts.get(i);
				System.out.println(a);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
