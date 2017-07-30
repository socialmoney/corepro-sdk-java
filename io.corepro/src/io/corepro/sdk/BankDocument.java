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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.FileContent;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class BankDocument extends ModelBase {
	public Integer bankId;
	public Integer customerId;
	public Integer documentId;
	public String documentType;
	public String culture;
	public String html;
	public String title;
	public String downloadUrl;
	public Date effectiveDate;
	public Date expireDate;
	
	public static ArrayList<BankDocument> list(String cultureName, String documentType, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<ArrayList<BankDocument>> envelope = new Envelope<ArrayList<BankDocument>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<BankDocument>>>(){}.getType();
		
		return Requestor.performGet(String.format("bankdocument/list/%s/%s",  cultureName, documentType), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}
	
	public static FileContent download(String cultureName, Integer documentId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<FileContent> envelope = new Envelope<FileContent>();
		Type envelopeType = new TypeToken<Envelope<FileContent>>(){}.getType();
		
		return Requestor.performGet(String.format("bankdocument/download/%s/%d",  cultureName, documentId), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

}
