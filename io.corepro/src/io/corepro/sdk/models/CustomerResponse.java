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
