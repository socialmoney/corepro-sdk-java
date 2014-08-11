package io.corepro.sdk;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.reflect.TypeToken;

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
	private Date createdDate;
	private Date closedDate;
	private BigDecimal availableBalance;
	private BigDecimal accountBalance;
	private Boolean isPrimary;
	private Boolean isCloseable;
	private String routingNumber;
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
	
	public static ArrayList<Account> list(Integer customerId, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new Account(customerId).list(connection,  userDefinedObjectForLogging);
	}
	
	public ArrayList<Account> list(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		if (connection == null){
			connection = Connection.createFromConfig(null,  null,  null);
		}
		Envelope<ArrayList<Account>> envelope = new Envelope<ArrayList<Account>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<Account>>>(){}.getType();
		
		return Requestor.performGet(String.format("account/list/%d",  this.getCustomerId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	public static Account get(Integer customerId, Integer accountId, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new Account(customerId, accountId).get(connection,  userDefinedObjectForLogging);
	}
	
	public Account get(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		if (connection == null){
			connection = Connection.createFromConfig(null,  null,  null);
		}

		Envelope<Account> envelope = new Envelope<Account>();
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
		Envelope<Account> envelope = new Envelope<Account>();
		Type envelopeType = new TypeToken<Envelope<Account>>(){}.getType();
		return Requestor.performGet(String.format("account/getByTag/%d/%d",  this.getCustomerId(), this.getTag()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}
	
	public static AccountClose close(Integer customerId, Integer accountId, Integer closeToAccountId, String transactionTag, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		return AccountClose.close(customerId, accountId, closeToAccountId, transactionTag, connection, userDefinedObjectForLogging);
	}

	public AccountClose close(Integer closeToAccountId, String transactionTag, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		return AccountClose.close(this.getCustomerId(), this.getAccountId(), closeToAccountId, transactionTag, connection, userDefinedObjectForLogging);
	}
	
	public static Integer create(Integer customerId, String name, String type, String tag,
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
		if (connection == null){
			connection = Connection.createFromConfig(null,  null,  null);
		}
		Envelope<AccountIdOnly> envelope = new Envelope<AccountIdOnly>();
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
		if (connection == null){
			connection = Connection.createFromConfig(null,  null,  null);
		}
		Envelope<Object> envelope = new Envelope<Object>();
		Type envelopeType = new TypeToken<Envelope<Object>>(){}.getType();
		Requestor.performPost("account/update", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		return true;
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

}
