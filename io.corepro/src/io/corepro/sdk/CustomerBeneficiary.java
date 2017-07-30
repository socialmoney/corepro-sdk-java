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
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class CustomerBeneficiary extends ModelBase {
	
	private Integer customerId;
	private Integer customerBeneficiaryId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date birthDate;
	private String taxId;
	private String taxIdMasked;
	private Boolean isActive;

	public CustomerBeneficiary() {
		super();
	}
	
	public CustomerBeneficiary(Integer customerId) {
		super();
		this.setCustomerId(customerId);
	}

	public CustomerBeneficiary(Integer customerId, Integer customerBeneficiaryId){
		this(customerId);
		this.setCustomerBeneficiaryId(customerBeneficiaryId);
	}
	
	public static ArrayList<CustomerBeneficiary> list(Integer customerId, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new CustomerBeneficiary(customerId).list(connection,  userDefinedObjectForLogging);
	}
	
	public ArrayList<CustomerBeneficiary> list(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		Envelope<ArrayList<CustomerBeneficiary>> envelope = new Envelope<ArrayList<CustomerBeneficiary>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<CustomerBeneficiary>>>(){}.getType();
		
		return Requestor.performGet(String.format("customerbeneficiary/list/%d",  this.getCustomerId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	public static CustomerBeneficiary get(Integer customerId, Integer customerBeneficiaryId, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new CustomerBeneficiary(customerId, customerBeneficiaryId).get(connection,  userDefinedObjectForLogging);
	}
	
	public CustomerBeneficiary get(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		Envelope<CustomerBeneficiary> envelope = new Envelope<CustomerBeneficiary>();
		Type envelopeType = new TypeToken<Envelope<CustomerBeneficiary>>(){}.getType();
		return Requestor.performGet(String.format("customerbeneficiary/get/%d/%d",  this.getCustomerId(), this.getCustomerBeneficiaryId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	public static CustomerBeneficiary create(Integer customerId, String firstName, String middleName, String lastName,
            String taxId, Date birthDate,
            Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		
		CustomerBeneficiary cb = new CustomerBeneficiary(customerId);
		cb.setFirstName(firstName);
		cb.setMiddleName(middleName);
		cb.setLastName(lastName);
		cb.setTaxId(taxId);
		cb.setBirthDate(birthDate);
		return cb.create(connection, userDefinedObjectForLogging);
	}
	
	public CustomerBeneficiary create(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerBeneficiary> envelope = new Envelope<CustomerBeneficiary>();
		Type envelopeType = new TypeToken<Envelope<CustomerBeneficiary>>(){}.getType();
		return Requestor.performPost("customerbeneficiary/create", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
	}
	
	
	
	public static CustomerBeneficiary update(Integer customerId, Integer customerBeneficiaryId, String firstName, String middleName, String lastName,
            String taxId, Date birthDate,
            Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		
		CustomerBeneficiary cb = new CustomerBeneficiary(customerId, customerBeneficiaryId);
		cb.setFirstName(firstName);
		cb.setMiddleName(middleName);
		cb.setLastName(lastName);
		cb.setTaxId(taxId);
		cb.setBirthDate(birthDate);
		return cb.update(connection, userDefinedObjectForLogging);
	}
	
	public CustomerBeneficiary update(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerBeneficiary> envelope = new Envelope<CustomerBeneficiary>();
		Type envelopeType = new TypeToken<Envelope<CustomerBeneficiary>>(){}.getType();
		return Requestor.performPost("customerbeneficiary/update", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
	}
	
	
	public static Boolean deactivate(Integer customerId, Integer customerBeneficiaryId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		
		CustomerBeneficiary cb = new CustomerBeneficiary(customerId, customerBeneficiaryId);
		return cb.deactivate(connection, userDefinedObjectForLogging);
	}
	
	public Boolean deactivate(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<Object> envelope = new Envelope<Object>();
		Type envelopeType = new TypeToken<Envelope<Object>>(){}.getType();
		Requestor.performPost("customerbeneficiary/deactivate", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		return true;
	}

	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getCustomerBeneficiaryId() {
		return customerBeneficiaryId;
	}

	public void setCustomerBeneficiaryId(Integer customerBeneficiaryId) {
		this.customerBeneficiaryId = customerBeneficiaryId;
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

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getTaxIdMasked() {
		return taxIdMasked;
	}

	public void setTaxIdMasked(String taxIdMasked) {
		this.taxIdMasked = taxIdMasked;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
}
