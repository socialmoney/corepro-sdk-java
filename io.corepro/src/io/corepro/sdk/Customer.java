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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private String suffix;
	private Date birthDate;
	private String gender;
	private String culture;
	private String tag;
	private String status;
	private Date createdDate;
	private String taxId;
	private String taxIdMasked;
	private String driversLicenseNumber;
	private String driversLicenseNumberMasked;
	private String driversLicenseState;
	private Date driversLicenseExpireDate;
	private Date driversLicenseIssueDate;
	private String passportNumber;
	private String passportNumberMasked;
	private String passportCountry;
	private Date passportExpireDate;
	private Date passportIssueDate;
	private String emailAddress;
	private Boolean isActive;
	private Boolean isLocked;
	private Date lockedDate;
	private String lockedReason;
	private Boolean isSubjectToBackupWithholding;
	private Boolean isOptedInToBankCommunication;
	private Boolean isDocumentsAccepted;
	private List<CustomerPhone> phones;
	private List<CustomerAddress> addresses;
	private Date deceasedDate;
	private List<Account> accounts;
	private List<ExternalAccount> externalAccounts;
	private String customField1;
	private String customField2;
	private String customField3;
	private String customField4;
	private String customField5;
	private Date lastActivityDate;
	private Date documentsAcceptedDate;
	private Date expiredDate;
	private Date manualReviewDate;
	private Date lastModifiedDate;
	private List<Card> cards;
	
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
	
	
	public static List<Customer> listAll(Integer pageNumber, Integer pageSize, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		return new Customer(0).list(pageNumber, pageSize, connection, userDefinedObjectForLogging);
	}
	
	public List<Customer> list(Integer pageNumber, Integer pageSize, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<List<Customer>> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<List<Customer>>>(){}.getType();
		
		return Requestor.performGet(String.format("customer/list?pageNumber=%d&pageSize=%d",  pageNumber, pageSize), connection, envelope, envelopeType, userDefinedObjectForLogging);

	}
	
	
	
	public static Customer get(Integer customerId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		return new Customer(customerId).get(connection,  userDefinedObjectForLogging);
	}
	
	public Customer get(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<Customer> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<Customer>>(){}.getType();
		return Requestor.performGet(String.format("customer/get/%d",  this.getCustomerId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	public static Customer getByTag(Integer customerId, String tag, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		return new Customer(customerId, tag).getByTag(connection,  userDefinedObjectForLogging);
	}
	
	public Customer getByTag(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<Customer> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<Customer>>(){}.getType();
        String urlEncodedTag = this.getTag();
        try {
            urlEncodedTag = java.net.URLEncoder.encode(urlEncodedTag, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Requestor.performGet(String.format("customer/getByTag/%d/%s",  this.getCustomerId(), urlEncodedTag), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}


	public static Customer getByEmail(Integer customerId, String emailAddress, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Customer c = new Customer(customerId);
		c.setEmailAddress(emailAddress);
		return c.getByEmail(connection, userDefinedObjectForLogging);
	}

	public Customer getByEmail(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<Customer> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<Customer>>(){}.getType();
        String urlEncodedEmailAddress = this.getEmailAddress();
        try {
            urlEncodedEmailAddress = java.net.URLEncoder.encode(urlEncodedEmailAddress, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Requestor.performGet(String.format("customer/getByEmail/%d/%s",  this.getCustomerId(), urlEncodedEmailAddress), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	
	
	
	
	
	
	
	
	
	
	public static CustomerResponse initiate(String firstName, String middleName, String lastName, Date birthDate, String gender, String culture,
			String tag, String taxId, String driversLicenseNumber, String driversLicenseState, Date driversLicenseExpireDate,
			String passportNumber, String passportCountry, String emailAddress, Boolean isSubjectToBackupWithholding, Boolean isOptedInToBankCommunication,
			Boolean isDocumentsAccepted, List<CustomerAddress> addresses, List<CustomerPhone> phones,
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
		c.setDriversLicenseExpireDate(driversLicenseExpireDate);
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
		Envelope<CustomerResponse> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<CustomerResponse>>(){}.getType();
		return Requestor.performPost("customer/initiate", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
	}
	
	
	public static CustomerResponse verify(Integer customerId, CustomerVerifyRequest request, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Customer c = new Customer(customerId);
		return c.verify(request, connection, userDefinedObjectForLogging);
	}
	
	public CustomerResponse verify(CustomerVerifyRequest request, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerResponse> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<CustomerResponse>>(){}.getType();
		
		return Requestor.performPost("customer/verify", connection, request, envelope, envelopeType, userDefinedObjectForLogging);
		
	}

	
	public static Customer create(String firstName, String middleName, String lastName, Date birthDate, String gender, String culture,
			String tag, String taxId, String driversLicenseNumber, String driversLicenseState, Date driversLicenseExpireDate,
			String passportNumber, String passportCountry, String emailAddress, Boolean isSubjectToBackupWithholding, Boolean isOptedInToBankCommunication,
			Boolean isDocumentsAccepted, List<CustomerAddress> addresses, List<CustomerPhone> phones,
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
		c.setDriversLicenseExpireDate(driversLicenseExpireDate);
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
		Envelope<CustomerIdOnly> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<CustomerIdOnly>>(){}.getType();
		CustomerIdOnly idOnly = Requestor.performPost("customer/create", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		
		return Customer.get(idOnly.getCustomerId(), connection, userDefinedObjectForLogging);
		
	}
	
	public static CustomerIdOnly update(String firstName, String middleName, String lastName, Date birthDate, String gender, String culture,
			String tag, String taxId, String driversLicenseNumber, String driversLicenseState, Date driversLicenseExpireDate,
			String passportNumber, String passportCountry, String emailAddress, Boolean isSubjectToBackupWithholding, Boolean isOptedInToBankCommunication,
			List<CustomerAddress> addresses, List<CustomerPhone> phones,
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
		c.setDriversLicenseExpireDate(driversLicenseExpireDate);
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
		Envelope<CustomerIdOnly> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<CustomerIdOnly>>(){}.getType();
		return Requestor.performPost("customer/update", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
	}


	public static CustomerIdOnly archive(Integer customerId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{

		Customer c = new Customer(customerId);
		return c.archive(connection, userDefinedObjectForLogging);
	}

	public CustomerIdOnly archive(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerIdOnly> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<CustomerIdOnly>>(){}.getType();
		return Requestor.performPost("customer/archive", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	public static CustomerIdOnly deactivate(Integer customerId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		
		Customer c = new Customer(customerId);
		return c.deactivate(connection, userDefinedObjectForLogging);
	}
	
	public CustomerIdOnly deactivate(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerIdOnly> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<CustomerIdOnly>>(){}.getType();
		return Requestor.performPost("customer/archive", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	
	public static List<Customer> search(String tag, String taxId, String passportNumber, String driversLicenseNumber, Date birthDate, String emailAddress,
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
	
	public List<Customer> search(Integer pageNumber, Integer pageSize, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<List<Customer>> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<List<Customer>>>(){}.getType();
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

	public List<CustomerPhone> getPhones() {
		return phones;
	}

	public void setPhones(List<CustomerPhone> phones) {
		this.phones = phones;
	}

	public List<CustomerAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<CustomerAddress> addresses) {
		this.addresses = addresses;
	}

	public Date getDeceasedDate() {
		return deceasedDate;
	}

	public void setDeceasedDate(Date deceasedDate) {
		this.deceasedDate = deceasedDate;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<ExternalAccount> getExternalAccounts() {
		return externalAccounts;
	}

	public void setExternalAccounts(List<ExternalAccount> externalAccounts) {
		this.externalAccounts = externalAccounts;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getTaxIdMasked() {
		return taxIdMasked;
	}

	public void setTaxIdMasked(String taxIdMasked) {
		this.taxIdMasked = taxIdMasked;
	}

	public String getDriversLicenseNumberMasked() {
		return driversLicenseNumberMasked;
	}

	public void setDriversLicenseNumberMasked(String driversLicenseNumberMasked) {
		this.driversLicenseNumberMasked = driversLicenseNumberMasked;
	}

	public Date getDriversLicenseExpireDate() {
		return driversLicenseExpireDate;
	}

	public void setDriversLicenseExpireDate(Date driversLicenseExpireDate) {
		this.driversLicenseExpireDate = driversLicenseExpireDate;
	}

	public Date getDriversLicenseIssueDate() {
		return driversLicenseIssueDate;
	}

	public void setDriversLicenseIssueDate(Date driversLicenseIssueDate) {
		this.driversLicenseIssueDate = driversLicenseIssueDate;
	}

	public String getPassportNumberMasked() {
		return passportNumberMasked;
	}

	public void setPassportNumberMasked(String passportNumberMasked) {
		this.passportNumberMasked = passportNumberMasked;
	}

	public Date getPassportExpireDate() {
		return passportExpireDate;
	}

	public void setPassportExpireDate(Date passportExpireDate) {
		this.passportExpireDate = passportExpireDate;
	}

	public Date getPassportIssueDate() {
		return passportIssueDate;
	}

	public void setPassportIssueDate(Date passportIssueDate) {
		this.passportIssueDate = passportIssueDate;
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

	public Date getLastActivityDate() {
		return lastActivityDate;
	}

	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	public Date getDocumentsAcceptedDate() {
		return documentsAcceptedDate;
	}

	public void setDocumentsAcceptedDate(Date documentsAcceptedDate) {
		this.documentsAcceptedDate = documentsAcceptedDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Date getManualReviewDate() {
		return manualReviewDate;
	}

	public void setManualReviewDate(Date manualReviewDate) {
		this.manualReviewDate = manualReviewDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
