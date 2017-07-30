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

package io.corepro.sdk.models;

import java.util.ArrayList;

public class CustomerResponse extends ModelBase {
	private Integer customerId;
	private ArrayList<CustomerMessage> messages;
	private ArrayList<CustomerQuestion> questions;
	private String verificationId;
	private String verificationStatus;
	
	public CustomerResponse() {
		this.setMessages(new ArrayList<CustomerMessage>());
		this.setQuestions(new ArrayList<CustomerQuestion>());
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public ArrayList<CustomerMessage> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<CustomerMessage> messages) {
		this.messages = messages;
	}

	public ArrayList<CustomerQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<CustomerQuestion> questions) {
		this.questions = questions;
	}

	public String getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(String verificationId) {
		this.verificationId = verificationId;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}
}
