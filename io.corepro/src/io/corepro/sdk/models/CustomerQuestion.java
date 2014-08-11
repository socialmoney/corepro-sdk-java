package io.corepro.sdk.models;

import java.util.ArrayList;

public class CustomerQuestion {
	private ArrayList<String> answers;
	private String prompt;
	private String type;
	public CustomerQuestion() {
		this.setAnswers(new ArrayList<String>());
	}
	public ArrayList<String> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
