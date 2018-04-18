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

import io.corepro.sdk.utils.Requestor;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

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


        // 2014-12-18 bweaver - Moved proxy stuff to Connection object where it belongs
		// for testing, you can use Fiddler web proxy
		//Requestor.useProxy("localhost",  8888);

//		try {
//
//			int customerId = 240893;    // need a valid customerId here
//			String apiKey = "example1";    // need a valid API Key here
//			String apiSecret = "example1"; // need a valid API Secret here
//			String domainName = "sandbox-api.corepro.io";
//
//			Connection connection = new Connection(apiKey, apiSecret, domainName);
//
//            Customer c = Customer.get(customerId, connection, null);
//
//            Program p = Program.get(connection, null);
//
//            System.out.println(p.getCheckingProducts().get("checking").getPerTransactionDepositLimit().getMaximumAmount());
//
//
//			// example: list all accounts for the given customer
//			List<Account> accounts = Account.list(customerId, connection, null);
//			for(int i=0;i<accounts.size();i++){
//				Account a = accounts.get(i);
//				System.out.println(a);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
}
