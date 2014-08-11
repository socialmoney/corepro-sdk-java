package io.corepro.sdk.models;

public class CustomerMessage {
	private String verificationId;
	private String verificationMessage;

	public String getVerificationId() {
		return verificationId;
	}
	public void setVerificationId(String verificationId) {
		this.verificationId = verificationId;
	}
	public String getVerificationMessage() {
		return verificationMessage;
	}
	public void setVerificationMessage(String verificationMessage) {
		this.verificationMessage = verificationMessage;
	}
}
