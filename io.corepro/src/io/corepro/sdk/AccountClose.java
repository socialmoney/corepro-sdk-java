package io.corepro.sdk;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class AccountClose extends ModelBase {
	
	private Integer customerId;
	private Integer accountId;
	private Integer closeToAccountId;
	private BigInteger transactionId;
	private String transactionTag;
	private BigDecimal closingBalanceAmount;
	private BigDecimal interestPaidAmount;
	private BigDecimal backupWithholdingAmount;
	private BigDecimal totalClosingAmount;
	private Boolean isClosedToExternalAccount;
	
	public AccountClose() {
		
	}
	public AccountClose(Integer customerId, Integer accountId){
		this();
		this.customerId = customerId;
		this.accountId = accountId;
	}
	
	public static AccountClose close(Integer customerId, Integer accountId, Integer closeToAccountId, String transactionTag, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		AccountClose ac = new AccountClose(customerId, accountId);
		ac.setCloseToAccountId(closeToAccountId);
		ac.setTransactionTag(transactionTag);
		return ac.close(connection,  userDefinedObjectForLogging);
	}
	
	public AccountClose close(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<AccountClose> envelope = new Envelope<AccountClose>();
		Type envelopeType = new TypeToken<Envelope<AccountClose>>(){}.getType();
		return Requestor.performPost("account/close", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
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
	public Integer getCloseToAccountId() {
		return closeToAccountId;
	}
	public void setCloseToAccountId(Integer closeToAccountId) {
		this.closeToAccountId = closeToAccountId;
	}
	public BigInteger getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionTag() {
		return transactionTag;
	}
	public void setTransactionTag(String transactionTag) {
		this.transactionTag = transactionTag;
	}
	public BigDecimal getClosingBalanceAmount() {
		return closingBalanceAmount;
	}
	public void setClosingBalanceAmount(BigDecimal closingBalanceAmount) {
		this.closingBalanceAmount = closingBalanceAmount;
	}
	public BigDecimal getInterestPaidAmount() {
		return interestPaidAmount;
	}
	public void setInterestPaidAmount(BigDecimal interestPaidAmount) {
		this.interestPaidAmount = interestPaidAmount;
	}
	public BigDecimal getBackupWithholdingAmount() {
		return backupWithholdingAmount;
	}
	public void setBackupWithholdingAmount(BigDecimal backupWithholdingAmount) {
		this.backupWithholdingAmount = backupWithholdingAmount;
	}
	public BigDecimal getTotalClosingAmount() {
		return totalClosingAmount;
	}
	public void setTotalClosingAmount(BigDecimal totalClosingAmount) {
		this.totalClosingAmount = totalClosingAmount;
	}
	public Boolean getIsClosedToExternalAccount() {
		return isClosedToExternalAccount;
	}
	public void setIsClosedToExternalAccount(Boolean isClosedToExternalAccount) {
		this.isClosedToExternalAccount = isClosedToExternalAccount;
	}
}
