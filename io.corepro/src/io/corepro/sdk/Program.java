package io.corepro.sdk;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.models.ProgramInterestRate;
import io.corepro.sdk.models.ProgramLimit;
import io.corepro.sdk.utils.Requestor;

public class Program extends ModelBase {
	
	private String name;
	private String verificationType;
	private BigDecimal regDFeeAmount;
	private BigDecimal regDMonthlyTransactionWithdrawCountMax;
	private ProgramLimit perTransactionWithdrawLimit;
	private ProgramLimit perUserDailyWithdrawLimit;
	private ProgramLimit perUserMonthlyWithdrawLimit;
	private ProgramLimit perProgramDailyWithdrawLimit;
	
	private ProgramLimit perTransactionDepositLimit;
	private ProgramLimit perUserDailyDepositLimit;
	private ProgramLimit perUserMonthlyDepositLimit;
	private ProgramLimit perProgramDailyDepositLimit;
	
	private String website;
	private Boolean isInternalToInternalTransferEnabled;
	private BigDecimal decimalCount;
	private Boolean isInterestEnabled;
	private String allowedAccountType;
	private Boolean isRecurringContributionEnabled;
	
	private ArrayList<ProgramInterestRate> interestRates;
	private Date filledDate;
	
	public Program() {
		super();
		this.setInterestRates(new ArrayList<ProgramInterestRate>());
	}
	
	public static Program get(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<Program> envelope = new Envelope<Program>();
		Type envelopeType = new TypeToken<Envelope<Program>>(){}.getType();
		return Requestor.performGet("program/get", connection, envelope, envelopeType, userDefinedObjectForLogging);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVerificationType() {
		return verificationType;
	}

	public void setVerificationType(String verificationType) {
		this.verificationType = verificationType;
	}

	public BigDecimal getRegDFeeAmount() {
		return regDFeeAmount;
	}

	public void setRegDFeeAmount(BigDecimal regDFeeAmount) {
		this.regDFeeAmount = regDFeeAmount;
	}

	public BigDecimal getRegDMonthlyTransactionWithdrawCountMax() {
		return regDMonthlyTransactionWithdrawCountMax;
	}

	public void setRegDMonthlyTransactionWithdrawCountMax(
			BigDecimal regDMonthlyTransactionWithdrawCountMax) {
		this.regDMonthlyTransactionWithdrawCountMax = regDMonthlyTransactionWithdrawCountMax;
	}

	public ProgramLimit getPerTransactionWithdrawLimit() {
		return perTransactionWithdrawLimit;
	}

	public void setPerTransactionWithdrawLimit(
			ProgramLimit perTransactionWithdrawLimit) {
		this.perTransactionWithdrawLimit = perTransactionWithdrawLimit;
	}

	public ProgramLimit getPerUserDailyWithdrawLimit() {
		return perUserDailyWithdrawLimit;
	}

	public void setPerUserDailyWithdrawLimit(ProgramLimit perUserDailyWithdrawLimit) {
		this.perUserDailyWithdrawLimit = perUserDailyWithdrawLimit;
	}

	public ProgramLimit getPerUserMonthlyWithdrawLimit() {
		return perUserMonthlyWithdrawLimit;
	}

	public void setPerUserMonthlyWithdrawLimit(
			ProgramLimit perUserMonthlyWithdrawLimit) {
		this.perUserMonthlyWithdrawLimit = perUserMonthlyWithdrawLimit;
	}

	public ProgramLimit getPerProgramDailyWithdrawLimit() {
		return perProgramDailyWithdrawLimit;
	}

	public void setPerProgramDailyWithdrawLimit(
			ProgramLimit perProgramDailyWithdrawLimit) {
		this.perProgramDailyWithdrawLimit = perProgramDailyWithdrawLimit;
	}

	public ProgramLimit getPerTransactionDepositLimit() {
		return perTransactionDepositLimit;
	}

	public void setPerTransactionDepositLimit(ProgramLimit perTransactionDepositLimit) {
		this.perTransactionDepositLimit = perTransactionDepositLimit;
	}

	public ProgramLimit getPerUserDailyDepositLimit() {
		return perUserDailyDepositLimit;
	}

	public void setPerUserDailyDepositLimit(ProgramLimit perUserDailyDepositLimit) {
		this.perUserDailyDepositLimit = perUserDailyDepositLimit;
	}

	public ProgramLimit getPerUserMonthlyDepositLimit() {
		return perUserMonthlyDepositLimit;
	}

	public void setPerUserMonthlyDepositLimit(ProgramLimit perUserMonthlyDepositLimit) {
		this.perUserMonthlyDepositLimit = perUserMonthlyDepositLimit;
	}

	public ProgramLimit getPerProgramDailyDepositLimit() {
		return perProgramDailyDepositLimit;
	}

	public void setPerProgramDailyDepositLimit(
			ProgramLimit perProgramDailyDepositLimit) {
		this.perProgramDailyDepositLimit = perProgramDailyDepositLimit;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Boolean getIsInternalToInternalTransferEnabled() {
		return isInternalToInternalTransferEnabled;
	}

	public void setIsInternalToInternalTransferEnabled(
			Boolean isInternalToInternalTransferEnabled) {
		this.isInternalToInternalTransferEnabled = isInternalToInternalTransferEnabled;
	}

	public BigDecimal getDecimalCount() {
		return decimalCount;
	}

	public void setDecimalCount(BigDecimal decimalCount) {
		this.decimalCount = decimalCount;
	}

	public Boolean getIsInterestEnabled() {
		return isInterestEnabled;
	}

	public void setIsInterestEnabled(Boolean isInterestEnabled) {
		this.isInterestEnabled = isInterestEnabled;
	}

	public String getAllowedAccountType() {
		return allowedAccountType;
	}

	public void setAllowedAccountType(String allowedAccountType) {
		this.allowedAccountType = allowedAccountType;
	}

	public Boolean getIsRecurringContributionEnabled() {
		return isRecurringContributionEnabled;
	}

	public void setIsRecurringContributionEnabled(
			Boolean isRecurringContributionEnabled) {
		this.isRecurringContributionEnabled = isRecurringContributionEnabled;
	}

	public ArrayList<ProgramInterestRate> getInterestRates() {
		return interestRates;
	}

	public void setInterestRates(ArrayList<ProgramInterestRate> interestRates) {
		this.interestRates = interestRates;
	}

	public Date getFilledDate() {
		return filledDate;
	}

	public void setFilledDate(Date filledDate) {
		this.filledDate = filledDate;
	}

	
	
}
