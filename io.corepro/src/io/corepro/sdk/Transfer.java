package io.corepro.sdk;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class Transfer extends ModelBase {
	private Integer customerId;
	private Integer fromId;
	private Integer toId;
	private BigDecimal amount;
	private String tag;
	private BigInteger transactionId;
	
	public Transfer() {
		super();
	}
	
	public Transfer(Integer customerId, Integer fromId, Integer toId, BigDecimal amount, String tag) {
		this();
		this.setCustomerId(customerId);
		this.setFromId(fromId);
		this.setToId(toId);
		this.setAmount(amount);
		this.setTag(tag);
	}
	
	public static ArrayList<Transfer> create(Integer customerId, Integer fromId, Integer toId, BigDecimal amount, String tag, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Transfer t = new Transfer(customerId, fromId, toId, amount, tag);
		return t.create(connection, userDefinedObjectForLogging);
	}
	
	public ArrayList<Transfer> create(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<ArrayList<Transfer>> envelope = new Envelope<ArrayList<Transfer>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<Transfer>>>(){}.getType();
		return Requestor.performPost("transfer/create", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
	}
	
	
	public static ArrayList<Transfer> voidTransaction(Integer customerId, BigInteger transactionId, String tag, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Transfer t = new Transfer(customerId, null, null, null, tag);
		t.setTransactionId(transactionId);
		return t.voidTransaction(connection, userDefinedObjectForLogging);
	}
	
	public ArrayList<Transfer> voidTransaction(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<ArrayList<Transfer>> envelope = new Envelope<ArrayList<Transfer>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<Transfer>>>(){}.getType();
		return Requestor.performPost("transfer/void", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public BigInteger getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}
	
	
}
