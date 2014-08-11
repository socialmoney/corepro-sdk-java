package io.corepro.sdk;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.FileContent;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class Statement extends ModelBase {
	private Integer statementId;
	private Integer customerId;
	private String type;
	private Integer month;
	private Integer year;
	
	public Statement() {
		
	}
	
	public Statement(Integer customerId, Integer statementId){
		this();
		this.setCustomerId(customerId);
		this.setStatementId(statementId);
	}
	
	
	public static ArrayList<Statement> list(Integer customerId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Statement s = new Statement(customerId, null);
		return s.list(connection, userDefinedObjectForLogging);
	}
	
	public ArrayList<Statement> list(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		if (connection == null){
			connection = Connection.createFromConfig(null,  null,  null);
		}

		Envelope<ArrayList<Statement>> envelope = new Envelope<ArrayList<Statement>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<Statement>>>(){}.getType();
		return Requestor.performGet(String.format("statement/list/%d", this.getCustomerId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
		
	}
	
	public static Statement get(Integer customerId, Integer statementId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Statement s = new Statement(customerId, null);
		return s.get(connection, userDefinedObjectForLogging);
	}
	
	public Statement get(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		if (connection == null){
			connection = Connection.createFromConfig(null,  null,  null);
		}

		Envelope<Statement> envelope = new Envelope<Statement>();
		Type envelopeType = new TypeToken<Envelope<Statement>>(){}.getType();
		return Requestor.performGet(String.format("statement/get/%d/%d", this.getCustomerId(), this.getStatementId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
		
	}
	
	public static FileContent download(Integer customerId, Integer statementId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Statement s = new Statement(customerId, null);
		return s.download(connection, userDefinedObjectForLogging);
	}
	
	public FileContent download(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		if (connection == null){
			connection = Connection.createFromConfig(null,  null,  null);
		}

		Envelope<FileContent> envelope = new Envelope<FileContent>();
		Type envelopeType = new TypeToken<Envelope<FileContent>>(){}.getType();
		return Requestor.performGet(String.format("statement/download/%d/%d", this.getCustomerId(), this.getStatementId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
		
	}

	public Integer getStatementId() {
		return statementId;
	}

	public void setStatementId(Integer statementId) {
		this.statementId = statementId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	
	
}
