package io.corepro.sdk;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class Transaction extends ModelBase {
	
	private Integer transactionCount;
	private Integer customerId;
	private BigInteger transactionId;
	private String tag;
	private Date createdDate;
	private String type;
	private String typeCode;
	private String status;
	private BigDecimal amount;
	private Date settledDate;
	private Date voidedDate;
	private String nachaDescription;
	private String friendlyDescription;
	private Date availableDate;
	private String returnCode;
	private Boolean isCredit;
	
	public Transaction() {
		super();
	}
	
	public Transaction(Integer customerId){
		this();
	}
	
	public static ArrayList<Transaction> list(Integer customerId, Integer accountId, String status, Date beginDate, Date endDate, Integer pageNumber, Integer pageSize, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Transaction t = new Transaction(customerId);
		return t.list(accountId, status, beginDate, endDate, pageNumber, pageSize, connection, userDefinedObjectForLogging);
	}
	
	public ArrayList<Transaction> list(Integer accountId, String status, Date beginDate, Date endDate, Integer pageNumber, Integer pageSize, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String begin = "";
		if (beginDate != null){
			begin = sdf.format(beginDate);
		}
		String end = "";
		if (endDate != null){
			end = sdf.format(endDate);
		}
		
		if (end != "" && begin == ""){
			// for the CorePro API to interpret the date range properly,
			// if end date is given, so must begin date.  So if it's missing, 
			// we add in a default we know will pull everything available
			begin = "1900-01-01";
		}

		Envelope<ArrayList<Transaction>> envelope = new Envelope<ArrayList<Transaction>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<Transaction>>>(){}.getType();
		return Requestor.performGet(String.format("transaction/list/%d/%d/%s/%s/%s?pageNumber=%d&pageSize=%d", this.getCustomerId(), accountId, status, begin, end, pageNumber, pageSize), connection, envelope, envelopeType, userDefinedObjectForLogging);
		
	}

	public Integer getTransactionCount() {
		return transactionCount;
	}

	public void setTransactionCount(Integer transactionCount) {
		this.transactionCount = transactionCount;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public BigInteger getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getSettledDate() {
		return settledDate;
	}

	public void setSettledDate(Date settledDate) {
		this.settledDate = settledDate;
	}

	public Date getVoidedDate() {
		return voidedDate;
	}

	public void setVoidedDate(Date voidedDate) {
		this.voidedDate = voidedDate;
	}

	public String getNachaDescription() {
		return nachaDescription;
	}

	public void setNachaDescription(String nachaDescription) {
		this.nachaDescription = nachaDescription;
	}

	public String getFriendlyDescription() {
		return friendlyDescription;
	}

	public void setFriendlyDescription(String friendlyDescription) {
		this.friendlyDescription = friendlyDescription;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public Boolean getIsCredit() {
		return isCredit;
	}

	public void setIsCredit(Boolean isCredit) {
		this.isCredit = isCredit;
	}
	
}
