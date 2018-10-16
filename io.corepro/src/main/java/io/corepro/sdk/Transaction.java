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

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class Transaction extends ModelBase {
	
	private Integer transactionCount;
	private Integer customerId;
	private BigInteger transactionId;
	private BigInteger masterId;
	private String tag;
	private Date createdDate;
	private String type;
	private String typeCode;
	private String status;
	private BigDecimal amount;
	private Date settledDate;
	private Date voidedDate;
	private String description;
	private String friendlyDescription;
	private Date availableDate;
	private String returnCode;
	private Boolean isCredit;
	private String feeCode;
	private String feeDescription;
	private String institutionName;
	private String customField1;
	private BigDecimal runningAccountBalance;
	private Boolean isSameDaySettle;

	public Transaction() {
		super();
	}
	
	public Transaction(Integer customerId){
		this();
		this.setCustomerId(customerId);
	}
	
	public static List<Transaction> list(Integer customerId, Integer accountId, String status, Date beginDate, Date endDate, Integer pageNumber, Integer pageSize, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Transaction t = new Transaction(customerId);
		return t.list(accountId, status, beginDate, endDate, pageNumber, pageSize, connection, userDefinedObjectForLogging);
	}
	
	public List<Transaction> list(Integer accountId, String status, Date beginDate, Date endDate, Integer pageNumber, Integer pageSize, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String begin = "";
		if (beginDate != null){
			begin = sdf.format(beginDate);
		}
		String end = "";
		if (endDate != null){
			end = sdf.format(endDate);
		}
		
		if (!end.equals("") && begin.equals("")){
			// for the CorePro API to interpret the date range properly,
			// if end date is given, so must begin date.  So if it's missing, 
			// we add in a default we know will pull everything available
			begin = "1900-01-01";
		}

		Envelope<List<Transaction>> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<List<Transaction>>>(){}.getType();
		return Requestor.performGet(String.format("transaction/list/%d/%d/%s/%s/%s?pageNumber=%d&pageSize=%d", this.getCustomerId(), accountId, status, begin, end, pageNumber, pageSize), connection, envelope, envelopeType, userDefinedObjectForLogging);
		
	}

    public List<Transaction> get(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<List<Transaction>> envelope = new Envelope<>();
        Type envelopeType = new TypeToken<Envelope<List<Transaction>>>(){}.getType();
        return Requestor.performGet(String.format("transaction/get/%d/%d", this.getCustomerId(), this.getTransactionId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public List<Transaction> getByTag(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<List<Transaction>> envelope = new Envelope<>();
        Type envelopeType = new TypeToken<Envelope<List<Transaction>>>(){}.getType();
        String urlEncodedTag = this.getTag();
        try {
            urlEncodedTag = java.net.URLEncoder.encode(urlEncodedTag, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Requestor.performGet(String.format("transaction/getbytag/%d/%s", this.getCustomerId(), urlEncodedTag), connection, envelope, envelopeType, userDefinedObjectForLogging);
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

	public BigInteger getMasterId() {
		return masterId;
	}

	public void setMasterId(BigInteger masterId) {
		this.masterId = masterId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getFeeDescription() {
        return feeDescription;
    }

    public void setFeeDescription(String feeDescription) {
        this.feeDescription = feeDescription;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public BigDecimal getRunningAccountBalance() {
        return runningAccountBalance;
    }

    public void setRunningAccountBalance(BigDecimal runningAccountBalance) {
        this.runningAccountBalance = runningAccountBalance;
    }

    public Boolean getIsSameDaySettle() {
        return isSameDaySettle;
    }

    public void setIsSameDaySettle(Boolean sameDaySettle) {
        isSameDaySettle = sameDaySettle;
    }
}
