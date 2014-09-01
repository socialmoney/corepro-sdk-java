package io.corepro.sdk;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.CustomerAddress;
import io.corepro.sdk.models.CustomerIdOnly;
import io.corepro.sdk.models.CustomerPhone;
import io.corepro.sdk.models.CustomerResponse;
import io.corepro.sdk.models.CustomerVerifyRequest;
import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class Customer extends ModelBase {
	
	private Integer customerCount;
	private Integer customerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date birthDate;
	private String gender;
	private String culture;
	private String tag;
	private String status;
	private Date createdDate;
	private String taxId;
	private String driversLicenseNumber;
	private String driversLicenseState;
	private Date driversLicenseExpirationDate;
	private String passportNumber;
	private String passportCountry;
	private String emailAddress;
	private Boolean isActive;
	private Boolean isLocked;
	private Date lockedDate;
	private String lockedReason;
	private Boolean isSubjectToBackupWithholding;
	private Boolean isOptedInToBankCommunication;
	private Boolean isDocumentsAccepted;
	private ArrayList<CustomerPhone> phones;
	private ArrayList<CustomerAddress> addresses;
	private Date deceasedDate;
	private ArrayList<Account> accounts;
	private ArrayList<ExternalAccount> externalAccounts;
	
	public Customer() {
		super();
	}
	
	public Customer(Integer customerId){
		this();
		this.setCustomerId(customerId);
	}

	public Customer(Integer customerId, String tag){
		this(customerId);
		this.setTag(tag);
	}

	public Integer getCustomerCount() {
		return customerCount;
	}
	
	
	public static ArrayList<Customer> listAll(Integer pageNumber, Integer pageSize, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		return new Customer(0).list(pageNumber, pageSize, connection, userDefinedObjectForLogging);
	}
	
	public ArrayList<Customer> list(Integer pageNumber, Integer pageSize, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<ArrayList<Customer>> envelope = new Envelope<ArrayList<Customer>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<Customer>>>(){}.getType();
		
		return Requestor.performGet(String.format("customer/list?pageNumber=%d&pageSize=%d",  pageNumber, pageSize), connection, envelope, envelopeType, userDefinedObjectForLogging);

	}
	
	
	
	public static Customer get(Integer customerId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		return new Customer(customerId).get(connection,  userDefinedObjectForLogging);
	}
	
	public Customer get(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<Customer> envelope = new Envelope<Customer>();
		Type envelopeType = new TypeToken<Envelope<Customer>>(){}.getType();
		return Requestor.performGet(String.format("customer/get/%d",  this.getCustomerId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	public static Customer getByTag(Integer customerId, String tag, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		return new Customer(customerId, tag).getByTag(connection,  userDefinedObjectForLogging);
	}
	
	public Customer getByTag(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<Customer> envelope = new Envelope<Customer>();
		Type envelopeType = new TypeToken<Envelope<Customer>>(){}.getType();
		return Requestor.performGet(String.format("customer/getByTag/%d/%d",  this.getCustomerId(), this.getTag()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static CustomerResponse initiate(String firstName, String middleName, String lastName, Date birthDate, String gender, String culture,
			String tag, String taxId, String driversLicenseNumber, String driversLicenseState, Date driversLicenseExpirationDate,
			String passportNumber, String passportCountry, String emailAddress, Boolean isSubjectToBackupWithholding, Boolean isOptedInToBankCommunication,
			Boolean isDocumentsAccepted, ArrayList<CustomerAddress> addresses, ArrayList<CustomerPhone> phones,
            Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		
		Customer c= new Customer();
		c.setFirstName(firstName);
		c.setMiddleName(middleName);
		c.setLastName(lastName);
		c.setBirthDate(birthDate);
		c.setGender(gender);
		c.setCulture(culture);
		c.setTag(tag);
		c.setTaxId(taxId);
		c.setDriversLicenseNumber(driversLicenseNumber);
		c.setDriversLicenseState(driversLicenseState);
		c.setDriversLicenseExpirationDate(driversLicenseExpirationDate);
		c.setPassportNumber(passportNumber);
		c.setPassportCountry(passportCountry);
		c.setEmailAddress(emailAddress);
		c.setIsSubjectToBackupWithholding(isSubjectToBackupWithholding);
		c.setIsOptedInToBankCommunication(isOptedInToBankCommunication);
		c.setIsDocumentsAccepted(isDocumentsAccepted);
		c.setAddresses(addresses);
		c.setPhones(phones);
		
		return c.initiate(connection, userDefinedObjectForLogging);

	}
	
	public CustomerResponse initiate(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerResponse> envelope = new Envelope<CustomerResponse>();
		Type envelopeType = new TypeToken<Envelope<CustomerResponse>>(){}.getType();
		return Requestor.performPost("customer/initiate", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
	}
	
	
	public static CustomerResponse verify(Integer customerId, CustomerVerifyRequest request, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Customer c = new Customer(customerId);
		return c.verify(request, connection, userDefinedObjectForLogging);
	}
	
	public CustomerResponse verify(CustomerVerifyRequest request, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerResponse> envelope = new Envelope<CustomerResponse>();
		Type envelopeType = new TypeToken<Envelope<CustomerResponse>>(){}.getType();
		
		return Requestor.performPost("customer/verify", connection, request, envelope, envelopeType, userDefinedObjectForLogging);
		
	}

	
	public static Customer create(String firstName, String middleName, String lastName, Date birthDate, String gender, String culture,
			String tag, String taxId, String driversLicenseNumber, String driversLicenseState, Date driversLicenseExpirationDate,
			String passportNumber, String passportCountry, String emailAddress, Boolean isSubjectToBackupWithholding, Boolean isOptedInToBankCommunication,
			Boolean isDocumentsAccepted, ArrayList<CustomerAddress> addresses, ArrayList<CustomerPhone> phones,
            Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{

		Customer c= new Customer();
		c.setFirstName(firstName);
		c.setMiddleName(middleName);
		c.setLastName(lastName);
		c.setBirthDate(birthDate);
		c.setGender(gender);
		c.setCulture(culture);
		c.setTag(tag);
		c.setTaxId(taxId);
		c.setDriversLicenseNumber(driversLicenseNumber);
		c.setDriversLicenseState(driversLicenseState);
		c.setDriversLicenseExpirationDate(driversLicenseExpirationDate);
		c.setPassportNumber(passportNumber);
		c.setPassportCountry(passportCountry);
		c.setEmailAddress(emailAddress);
		c.setIsSubjectToBackupWithholding(isSubjectToBackupWithholding);
		c.setIsOptedInToBankCommunication(isOptedInToBankCommunication);
		c.setIsDocumentsAccepted(isDocumentsAccepted);
		c.setAddresses(addresses);
		c.setPhones(phones);
		
		return c.create(connection, userDefinedObjectForLogging);
	}
	
	public Customer create(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerIdOnly> envelope = new Envelope<CustomerIdOnly>();
		Type envelopeType = new TypeToken<Envelope<CustomerIdOnly>>(){}.getType();
		CustomerIdOnly idOnly = Requestor.performPost("externalaccount/create", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		
		return Customer.get(idOnly.getCustomerId(), connection, userDefinedObjectForLogging);
		
	}
	
	public static CustomerIdOnly update(String firstName, String middleName, String lastName, Date birthDate, String gender, String culture,
			String tag, String taxId, String driversLicenseNumber, String driversLicenseState, Date driversLicenseExpirationDate,
			String passportNumber, String passportCountry, String emailAddress, Boolean isSubjectToBackupWithholding, Boolean isOptedInToBankCommunication,
			ArrayList<CustomerAddress> addresses, ArrayList<CustomerPhone> phones,
            Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{

		Customer c= new Customer();
		c.setFirstName(firstName);
		c.setMiddleName(middleName);
		c.setLastName(lastName);
		c.setBirthDate(birthDate);
		c.setGender(gender);
		c.setCulture(culture);
		c.setTag(tag);
		c.setTaxId(taxId);
		c.setDriversLicenseNumber(driversLicenseNumber);
		c.setDriversLicenseState(driversLicenseState);
		c.setDriversLicenseExpirationDate(driversLicenseExpirationDate);
		c.setPassportNumber(passportNumber);
		c.setPassportCountry(passportCountry);
		c.setEmailAddress(emailAddress);
		c.setIsSubjectToBackupWithholding(isSubjectToBackupWithholding);
		c.setIsOptedInToBankCommunication(isOptedInToBankCommunication);
		c.setAddresses(addresses);
		c.setPhones(phones);
		
		return c.update(connection, userDefinedObjectForLogging);
	}
	
	public CustomerIdOnly update(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerIdOnly> envelope = new Envelope<CustomerIdOnly>();
		Type envelopeType = new TypeToken<Envelope<CustomerIdOnly>>(){}.getType();
		return Requestor.performPost("customer/update", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	
	
	public static CustomerIdOnly deactivate(Integer customerId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		
		Customer c = new Customer(customerId);
		return c.deactivate(connection, userDefinedObjectForLogging);
	}
	
	public CustomerIdOnly deactivate(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerIdOnly> envelope = new Envelope<CustomerIdOnly>();
		Type envelopeType = new TypeToken<Envelope<CustomerIdOnly>>(){}.getType();
		return Requestor.performPost("customer/deactivate", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	
	public static ArrayList<Customer> search(String tag, String taxId, String passportNumber, String driversLicenseNumber, Date birthDate, String emailAddress,
			String lastName, String firstName, Integer pageNumber, Integer pageSize,
			Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		
		Customer c= new Customer();
		c.setTag(tag);
		c.setTaxId(taxId);
		c.setPassportNumber(passportNumber);
		c.setDriversLicenseNumber(driversLicenseNumber);
		c.setBirthDate(birthDate);
		c.setEmailAddress(emailAddress);
		c.setLastName(lastName);
		c.setFirstName(firstName);
		
		return c.search(pageNumber, pageSize, connection, userDefinedObjectForLogging);
		
	}
	
	public ArrayList<Customer> search(Integer pageNumber, Integer pageSize, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<ArrayList<Customer>> envelope = new Envelope<ArrayList<Customer>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<Customer>>>(){}.getType();
		return Requestor.performPost(String.format("customer/search?pageNumber=%d&pageSize=%d", pageNumber, pageSize), connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		
	}
	
	
	

	public void setCustomerCount(Integer customerCount) {
		this.customerCount = customerCount;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCulture() {
		return culture;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getDriversLicenseNumber() {
		return driversLicenseNumber;
	}

	public void setDriversLicenseNumber(String driversLicenseNumber) {
		this.driversLicenseNumber = driversLicenseNumber;
	}

	public String getDriversLicenseState() {
		return driversLicenseState;
	}

	public void setDriversLicenseState(String driversLicenseState) {
		this.driversLicenseState = driversLicenseState;
	}

	public Date getDriversLicenseExpirationDate() {
		return driversLicenseExpirationDate;
	}

	public void setDriversLicenseExpirationDate(
			Date driversLicenseExpirationDate) {
		this.driversLicenseExpirationDate = driversLicenseExpirationDate;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportCountry() {
		return passportCountry;
	}

	public void setPassportCountry(String passportCountry) {
		this.passportCountry = passportCountry;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Date getLockedDate() {
		return lockedDate;
	}

	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	public String getLockedReason() {
		return lockedReason;
	}

	public void setLockedReason(String lockedReason) {
		this.lockedReason = lockedReason;
	}

	public Boolean getIsSubjectToBackupWithholding() {
		return isSubjectToBackupWithholding;
	}

	public void setIsSubjectToBackupWithholding(
			Boolean isSubjectToBackupWithholding) {
		this.isSubjectToBackupWithholding = isSubjectToBackupWithholding;
	}

	public Boolean getIsOptedInToBankCommunication() {
		return isOptedInToBankCommunication;
	}

	public void setIsOptedInToBankCommunication(
			Boolean isOptedInToBankCommunication) {
		this.isOptedInToBankCommunication = isOptedInToBankCommunication;
	}

	public Boolean getIsDocumentsAccepted() {
		return isDocumentsAccepted;
	}

	public void setIsDocumentsAccepted(Boolean isDocumentsAccepted) {
		this.isDocumentsAccepted = isDocumentsAccepted;
	}

	public ArrayList<CustomerPhone> getPhones() {
		return phones;
	}

	public void setPhones(ArrayList<CustomerPhone> phones) {
		this.phones = phones;
	}

	public ArrayList<CustomerAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<CustomerAddress> addresses) {
		this.addresses = addresses;
	}

	public Date getDeceasedDate() {
		return deceasedDate;
	}

	public void setDeceasedDate(Date deceasedDate) {
		this.deceasedDate = deceasedDate;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public ArrayList<ExternalAccount> getExternalAccounts() {
		return externalAccounts;
	}

	public void setExternalAccounts(ArrayList<ExternalAccount> externalAccounts) {
		this.externalAccounts = externalAccounts;
	}
}
