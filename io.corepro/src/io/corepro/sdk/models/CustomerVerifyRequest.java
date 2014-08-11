package io.corepro.sdk.models;

import java.util.ArrayList;

public class CustomerVerifyRequest extends ModelBase {
	private Integer customerId;
	private String verificationId;
	private ArrayList<CustomerAnswer> answers;
	
	public CustomerVerifyRequest(){
		this.setAnswers(new ArrayList<CustomerAnswer>());
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(String verificationId) {
		this.verificationId = verificationId;
	}

	public ArrayList<CustomerAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<CustomerAnswer> answers) {
		this.answers = answers;
	}
}
