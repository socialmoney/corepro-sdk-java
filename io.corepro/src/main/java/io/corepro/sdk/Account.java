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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.AccountAccess;
import io.corepro.sdk.models.AccountIdOnly;
import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class Account extends ModelBase {
	private Integer customerId;
	private Integer accountId;
	private String name;
	private String accountNumber;
	private String accountNumberMasked;
	private String status;
	private String type;
	private Integer productId;
	private Date createdDate;
	private Date closedDate;
	private BigDecimal closedAmount;
	private BigInteger closedTransactionId;
	private String closedReason;

	private BigDecimal availableBalance;
	private BigDecimal accountBalance;
	private Boolean isPrimary;
	private Boolean isCloseable;
	private String routingNumber;
	private String routingNumberMasked;

	private BigDecimal targetAmount;
	private Date targetDate;
	private String category;
	private String subCategory;
	private String tag;
	private String miscellaneous;
	private String recurringContributionType;
	private BigDecimal recurringContributionAmount;
	private Integer recurringContributionFromExternalAccountId;
	private Date recurringContributionStartDate;
	private Date recurringContributionEndDate;
	private Date recurringContributionNextDate;

	private Integer RegDWithdrawalCount;
	private Date targetMetDate;
	private BigDecimal targetMetPercent;
	private String customField1;
	private String customField2;
	private String customField3;
	private String customField4;
	private String customField5;
	private BigDecimal pendingBalance;
	private Integer primaryCustomerId;
	private String legalName1;
	private String legalName2;
	private String accessTypeCode;
	private Integer totalCustomers;
	private Boolean isJointAccount;
	private Boolean isPrimaryCustomer;
	private BigDecimal interestApr;
	private BigDecimal interestApy;
	private Integer tier;
	private String tierDescription;
	private BigDecimal tierMinimumAmount;
	private BigDecimal tierMaximumAmount;
	private Date lastModifiedDate;
	private Date balanceLastModifiedDate;
	private String externalProgramTag;
	private Integer cardPriority;
	private Integer customerPriority;



	public Account() {
		super();
	}
	
	public Account(Integer customerId){
		this();
		this.setCustomerId(customerId);
	}

	public Account(Integer customerId, Integer accountId){
		this(customerId);
		this.setAccountId(accountId);
	}
	
	public Account(Integer customerId, String tag){
		this(customerId);
		this.setTag(tag);
	}
	
	
	public String toString() {
		return "Id: " + this.getAccountId() + ", Name:" + this.getName() + ", #:" + this.getAccountNumberMasked() + ", avail:" + this.getAvailableBalance();
	}
	
	public static List<Account> list(Integer customerId, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new Account(customerId).list(connection,  userDefinedObjectForLogging);
	}
	
	public List<Account> list(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		Envelope<List<Account>> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<List<Account>>>(){}.getType();
		
		return Requestor.performGet(String.format("account/list/%d",  this.getCustomerId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	public static Account get(Integer customerId, Integer accountId, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new Account(customerId, accountId).get(connection,  userDefinedObjectForLogging);
	}
	
	public Account get(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		Envelope<Account> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<Account>>(){}.getType();
		return Requestor.performGet(String.format("account/get/%d/%d",  this.getCustomerId(), this.getAccountId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	public static Account getByTag(Integer customerId, String tag, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new Account(customerId, tag).getByTag(connection,  userDefinedObjectForLogging);
	}
	
	public Account getByTag(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		if (connection == null){
			connection = Connection.createFromConfig(null,  null,  null);
		}
		Envelope<Account> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<Account>>(){}.getType();
        String urlEncodedTag = java.net.URLEncoder.encode(this.getTag(), "UTF-8");
        return Requestor.performGet(String.format("account/getByTag/%d/%s",  this.getCustomerId(), urlEncodedTag), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}
	
	public static AccountClose close(Integer customerId, Integer accountId, Integer closeToAccountId, String transactionTag, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		return AccountClose.close(customerId, accountId, closeToAccountId, transactionTag, connection, userDefinedObjectForLogging);
	}

	public AccountClose close(Integer closeToAccountId, String transactionTag, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		return AccountClose.close(this.getCustomerId(), this.getAccountId(), closeToAccountId, transactionTag, connection, userDefinedObjectForLogging);
	}
	
	public static Integer create(Integer customerId, String name, String type, Integer productId, String tag,
            String category, String subCategory, String miscellaneous,
            BigDecimal targetAmount, Date targetDate,
            String recurringContributionType, BigDecimal recurringContributionAmount, Integer recurringContributionFromExternalAccountId,
            Date recurringContributionStartDate, Date recurringContributionEndDate, Boolean isCloseable,
            Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Account a = new Account(customerId);
		
		a.setName(name);
		a.setTargetAmount(targetAmount);
		a.setTargetDate(targetDate);
		a.setCategory(subCategory);
		a.setSubCategory(subCategory);
		a.setTag(tag);
		a.setType(type);
		a.setProductId(productId);
		a.setMiscellaneous(miscellaneous);
		a.setRecurringContributionType(recurringContributionType);
		a.setRecurringContributionAmount(recurringContributionAmount);
		a.setRecurringContributionStartDate(recurringContributionStartDate);
		a.setRecurringContributionFromExternalAccountId(recurringContributionFromExternalAccountId);
		a.setRecurringContributionEndDate(recurringContributionEndDate);
		a.setIsCloseable(isCloseable);
		
		return a.create(connection, userDefinedObjectForLogging);
	}
	
	public Integer create(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<AccountIdOnly> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<AccountIdOnly>>(){}.getType();
		AccountIdOnly accountIdOnly = Requestor.performPost("account/create", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		return accountIdOnly.getAccountId();
	}
	
	public static Boolean update(Integer customerId, Integer accountId, String name, String tag,
            String category, String subCategory, String miscellaneous,
            BigDecimal targetAmount, Date targetDate,
            String recurringContributionType, BigDecimal recurringContributionAmount, Integer recurringContributionFromExternalAccountId,
            Date recurringContributionStartDate, Date recurringContributionEndDate, Boolean isCloseable,
            Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Account a = new Account(customerId, accountId);
		
		a.setName(name);
		a.setTargetAmount(targetAmount);
		a.setTargetDate(targetDate);
		a.setCategory(subCategory);
		a.setSubCategory(subCategory);
		a.setTag(tag);
		a.setMiscellaneous(miscellaneous);
		a.setRecurringContributionType(recurringContributionType);
		a.setRecurringContributionAmount(recurringContributionAmount);
		a.setRecurringContributionStartDate(recurringContributionStartDate);
		a.setRecurringContributionFromExternalAccountId(recurringContributionFromExternalAccountId);
		a.setRecurringContributionEndDate(recurringContributionEndDate);
		a.setIsCloseable(isCloseable);
		
		return a.update(connection, userDefinedObjectForLogging);
	}
	
	public Boolean update(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<Object> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<Object>>(){}.getType();
		Requestor.performPost("account/update", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		return true;
	}

	public AccountAccess addAccess(Integer targetCustomerId, String accessTypeCode, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        AccountAccess aa = new AccountAccess();
        aa.setAccountId(this.accountId);
        aa.setCustomerId(this.customerId);
        aa.setTargetCustomerId(targetCustomerId);
        aa.setAccessTypeCode(accessTypeCode);
        return aa.addAccess(connection, userDefinedObjectForLogging);
    }

    public AccountAccess editAccess(Integer targetCustomerId, String accessTypeCode, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        AccountAccess aa = new AccountAccess();
        aa.setCustomerId(this.customerId);
        aa.setAccountId(this.accountId);
        aa.setTargetCustomerId(targetCustomerId);
        aa.setAccessTypeCode(accessTypeCode);
        return aa.editAccess(connection, userDefinedObjectForLogging);
    }

    public AccountAccess removeAccess(Integer targetCustomerId, String accessTypeCode, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        AccountAccess aa = new AccountAccess();
        aa.setCustomerId(this.customerId);
        aa.setAccountId(this.accountId);
        aa.setTargetCustomerId(targetCustomerId);
        aa.setAccessTypeCode(accessTypeCode);
        return aa.removeAccess(connection, userDefinedObjectForLogging);
    }

    public List<AccountAccess> listAccess(Integer targetCustomerId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        AccountAccess aa = new AccountAccess();
        aa.setCustomerId(this.customerId);
        aa.setAccountId(this.accountId);
        aa.setTargetCustomerId(targetCustomerId);
        return aa.listAccess(connection, userDefinedObjectForLogging);
    }

    public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumberMasked() {
		return accountNumberMasked;
	}

	public void setAccountNumberMasked(String accountNumberMasked) {
		this.accountNumberMasked = accountNumberMasked;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getProductId() { return productId; }

	public void setProductId(Integer productId) { this.productId = productId; }

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Boolean getIsCloseable() {
		return isCloseable;
	}

	public void setIsCloseable(Boolean isCloseable) {
		this.isCloseable = isCloseable;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public BigDecimal getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(BigDecimal targetAmount) {
		this.targetAmount = targetAmount;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getMiscellaneous() {
		return miscellaneous;
	}

	public void setMiscellaneous(String miscellaneous) {
		this.miscellaneous = miscellaneous;
	}

	public String getRecurringContributionType() {
		return recurringContributionType;
	}

	public void setRecurringContributionType(String recurringContributionType) {
		this.recurringContributionType = recurringContributionType;
	}

	public BigDecimal getRecurringContributionAmount() {
		return recurringContributionAmount;
	}

	public void setRecurringContributionAmount(
			BigDecimal recurringContributionAmount) {
		this.recurringContributionAmount = recurringContributionAmount;
	}

	public Integer getRecurringContributionFromExternalAccountId() {
		return recurringContributionFromExternalAccountId;
	}

	public void setRecurringContributionFromExternalAccountId(
			Integer recurringContributionFromExternalAccountId) {
		this.recurringContributionFromExternalAccountId = recurringContributionFromExternalAccountId;
	}

	public Date getRecurringContributionStartDate() {
		return recurringContributionStartDate;
	}

	public void setRecurringContributionStartDate(
			Date recurringContributionStartDate) {
		this.recurringContributionStartDate = recurringContributionStartDate;
	}

	public Date getRecurringContributionEndDate() {
		return recurringContributionEndDate;
	}

	public void setRecurringContributionEndDate(
			Date recurringContributionEndDate) {
		this.recurringContributionEndDate = recurringContributionEndDate;
	}

	public Date getRecurringContributionNextDate() {
		return recurringContributionNextDate;
	}

	public void setRecurringContributionNextDate(
			Date recurringContributionNextDate) {
		this.recurringContributionNextDate = recurringContributionNextDate;
	}

	public BigDecimal getClosedAmount() {
		return closedAmount;
	}

	public void setClosedAmount(BigDecimal closedAmount) {
		this.closedAmount = closedAmount;
	}

	public BigInteger getClosedTransactionId() {
		return closedTransactionId;
	}

	public void setClosedTransactionId(BigInteger closedTransactionId) {
		this.closedTransactionId = closedTransactionId;
	}

	public String getClosedReason() {
		return closedReason;
	}

	public void setClosedReason(String closedReason) {
		this.closedReason = closedReason;
	}

	public String getRoutingNumberMasked() {
		return routingNumberMasked;
	}

	public void setRoutingNumberMasked(String routingNumberMasked) {
		this.routingNumberMasked = routingNumberMasked;
	}

	public Date getTargetMetDate() {
		return targetMetDate;
	}

	public void setTargetMetDate(Date targetMetDate) {
		this.targetMetDate = targetMetDate;
	}

	public BigDecimal getTargetMetPercent() {
		return targetMetPercent;
	}

	public void setTargetMetPercent(BigDecimal targetMetPercent) {
		this.targetMetPercent = targetMetPercent;
	}

	public String getCustomField1() {
		return customField1;
	}

	public void setCustomField1(String customField1) {
		this.customField1 = customField1;
	}

	public String getCustomField2() {
		return customField2;
	}

	public void setCustomField2(String customField2) {
		this.customField2 = customField2;
	}

	public String getCustomField3() {
		return customField3;
	}

	public void setCustomField3(String customField3) {
		this.customField3 = customField3;
	}

	public String getCustomField4() {
		return customField4;
	}

	public void setCustomField4(String customField4) {
		this.customField4 = customField4;
	}

	public String getCustomField5() {
		return customField5;
	}

	public void setCustomField5(String customField5) {
		this.customField5 = customField5;
	}

	public BigDecimal getPendingBalance() {
		return pendingBalance;
	}

	public void setPendingBalance(BigDecimal pendingBalance) {
		this.pendingBalance = pendingBalance;
	}

	public Integer getPrimaryCustomerId() {
		return primaryCustomerId;
	}

	public void setPrimaryCustomerId(Integer primaryCustomerId) {
		this.primaryCustomerId = primaryCustomerId;
	}

	public String getLegalName1() {
		return legalName1;
	}

	public void setLegalName1(String legalName1) {
		this.legalName1 = legalName1;
	}

	public String getLegalName2() {
		return legalName2;
	}

	public void setLegalName2(String legalName2) {
		this.legalName2 = legalName2;
	}

	public String getAccessTypeCode() {
		return accessTypeCode;
	}

	public void setAccessTypeCode(String accessTypeCode) {
		this.accessTypeCode = accessTypeCode;
	}

	public Integer getTotalCustomers() {
		return totalCustomers;
	}

	public void setTotalCustomers(Integer totalCustomers) {
		this.totalCustomers = totalCustomers;
	}

	public Boolean getIsJointAccount() {
		return isJointAccount;
	}

	public void setIsJointAccount(Boolean jointAccount) {
		isJointAccount = jointAccount;
	}

	public Boolean getIsPrimaryCustomer() {
		return isPrimaryCustomer;
	}

	public void setIsPrimaryCustomer(Boolean primaryCustomer) {
		isPrimaryCustomer = primaryCustomer;
	}

	public BigDecimal getInterestApr() {
		return interestApr;
	}

	public void setInterestApr(BigDecimal interestApr) {
		this.interestApr = interestApr;
	}

	public BigDecimal getInterestApy() {
		return interestApy;
	}

	public void setInterestApy(BigDecimal interestApy) {
		this.interestApy = interestApy;
	}

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

	public String getTierDescription() {
		return tierDescription;
	}

	public void setTierDescription(String tierDescription) {
		this.tierDescription = tierDescription;
	}

	public BigDecimal getTierMinimumAmount() {
		return tierMinimumAmount;
	}

	public void setTierMinimumAmount(BigDecimal tierMinimumAmount) {
		this.tierMinimumAmount = tierMinimumAmount;
	}

	public BigDecimal getTierMaximumAmount() {
		return tierMaximumAmount;
	}

	public void setTierMaximumAmount(BigDecimal tierMaximumAmount) {
		this.tierMaximumAmount = tierMaximumAmount;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Date getBalanceLastModifiedDate() {
		return balanceLastModifiedDate;
	}

	public void setBalanceLastModifiedDate(Date balanceLastModifiedDate) {
		this.balanceLastModifiedDate = balanceLastModifiedDate;
	}

	public String getExternalProgramTag() {
		return externalProgramTag;
	}

	public void setExternalProgramTag(String externalProgramTag) {
		this.externalProgramTag = externalProgramTag;
	}

	public Integer getCardPriority() {
		return cardPriority;
	}

	public void setCardPriority(Integer cardPriority) {
		this.cardPriority = cardPriority;
	}

	public Integer getCustomerPriority() {
		return customerPriority;
	}

	public void setCustomerPriority(Integer customerPriority) {
		this.customerPriority = customerPriority;
	}

	public Integer getRegDWithdrawalCount() {
		return RegDWithdrawalCount;
	}

	public void setRegDWithdrawalCount(Integer regDWithdrawalCount) {
		RegDWithdrawalCount = regDWithdrawalCount;
	}
}
