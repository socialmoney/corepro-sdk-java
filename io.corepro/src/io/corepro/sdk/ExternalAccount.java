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
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ExternalAccountIdOnly;
import io.corepro.sdk.models.ExternalAccountVerify;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class ExternalAccount extends ModelBase {

	private Integer customerId;
	private Integer externalAccountId;
	private String name;
	private String tag;
	private String nickName;
	private String firstName;
	private String lastName;
	private String type;
	private String status;
	private Date statusDate;
	private String routingNumber;
	private String routingNumberMasked;
	private String accountNumber;
	private String accountNumberMasked;
	private String nocCode;
	private Boolean isActive;
	private Date lockedDate;
	private String lockedReason;
	
	
	
	public ExternalAccount() {
		super();
	}
	
	public ExternalAccount(Integer customerId){
		this();
		this.setCustomerId(customerId);
	}
	
	public ExternalAccount(Integer customerId, Integer externalAccountId){
		this(customerId);
		this.setExternalAccountId(externalAccountId);
	}
	
	public ExternalAccount(Integer customerId, String tag){
		this(customerId);
		this.setTag(tag);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<ExternalAccount> list(Integer customerId, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new ExternalAccount(customerId).list(connection,  userDefinedObjectForLogging);
	}
	
	public ArrayList<ExternalAccount> list(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		Envelope<ArrayList<ExternalAccount>> envelope = new Envelope<ArrayList<ExternalAccount>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<ExternalAccount>>>(){}.getType();
		
		return Requestor.performGet(String.format("externalaccount/list/%d",  this.getCustomerId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	public static ExternalAccount get(Integer customerId, Integer externalAccountId, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new ExternalAccount(customerId, externalAccountId).get(connection,  userDefinedObjectForLogging);
	}
	
	public ExternalAccount get(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		Envelope<ExternalAccount> envelope = new Envelope<ExternalAccount>();
		Type envelopeType = new TypeToken<Envelope<ExternalAccount>>(){}.getType();
		return Requestor.performGet(String.format("externalaccount/get/%d/%d",  this.getCustomerId(), this.getExternalAccountId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	public static ExternalAccount getByTag(Integer customerId, String tag, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new ExternalAccount(customerId, tag).getByTag(connection,  userDefinedObjectForLogging);
	}
	
	public ExternalAccount getByTag(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		Envelope<ExternalAccount> envelope = new Envelope<ExternalAccount>();
		Type envelopeType = new TypeToken<Envelope<ExternalAccount>>(){}.getType();
		return Requestor.performGet(String.format("externalaccount/getByTag/%d/%s",  this.getCustomerId(), this.getTag()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}
	

	public static Integer initiate(Integer customerId, String name, String firstName, String lastName, String type, 
            String routingNumber, String accountNumber, String nickName, String tag,
            Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{

		ExternalAccount ea = new ExternalAccount(customerId);
		
		ea.setName(name);
		ea.setFirstName(firstName);
		ea.setLastName(lastName);
		ea.setType(type);
		ea.setRoutingNumber(routingNumber);
		ea.setAccountNumber(accountNumber);
		ea.setNickName(nickName);
		ea.setTag(tag);
		
		return ea.create(connection, userDefinedObjectForLogging);
	}
	
	public Integer initiate(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<ExternalAccountIdOnly> envelope = new Envelope<ExternalAccountIdOnly>();
		Type envelopeType = new TypeToken<Envelope<ExternalAccountIdOnly>>(){}.getType();
		ExternalAccountIdOnly accountIdOnly = Requestor.performPost("externalaccount/initiate", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		return accountIdOnly.getExternalAccountId();
	}
	
	public static Boolean verify(Integer customerId, Integer externalAccountId, BigDecimal amount1, BigDecimal amount2, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		ExternalAccount ea = new ExternalAccount(customerId, externalAccountId);
		return ea.verify(amount1, amount2, connection, userDefinedObjectForLogging);
	}
	
	public Boolean verify(BigDecimal amount1, BigDecimal amount2, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<Object> envelope = new Envelope<Object>();
		Type envelopeType = new TypeToken<Envelope<Object>>(){}.getType();
		
		ExternalAccountVerify eav = new ExternalAccountVerify(this.getCustomerId(), this.getExternalAccountId(), amount1, amount2);
		
		Requestor.performPost("externalaccount/verify", connection, eav, envelope, envelopeType, userDefinedObjectForLogging);
		return true;
		
	}

	
	public static Integer create(Integer customerId, String name, String firstName, String lastName, String type,
            String routingNumber, String accountNumber, String nickName, String tag,
            Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{

		ExternalAccount ea = new ExternalAccount(customerId);
		
		ea.setName(name);
		ea.setFirstName(firstName);
		ea.setLastName(lastName);
		ea.setType(type);
		ea.setRoutingNumber(routingNumber);
		ea.setAccountNumber(accountNumber);
		ea.setNickName(nickName);
		ea.setTag(tag);
		
		return ea.create(connection, userDefinedObjectForLogging);
	}
	
	public Integer create(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<ExternalAccountIdOnly> envelope = new Envelope<ExternalAccountIdOnly>();
		Type envelopeType = new TypeToken<Envelope<ExternalAccountIdOnly>>(){}.getType();
		ExternalAccountIdOnly accountIdOnly = Requestor.performPost("externalaccount/create", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		return accountIdOnly.getExternalAccountId();
	}
	
	public static Boolean update(Integer customerId, Integer externalAccountId, String nickName, String tag,
            Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		
		ExternalAccount ea = new ExternalAccount(customerId, externalAccountId);
		ea.setNickName(nickName);
		ea.setTag(tag);
		
		return ea.update(connection, userDefinedObjectForLogging);
	}
	
	public Boolean update(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<ExternalAccountIdOnly> envelope = new Envelope<ExternalAccountIdOnly>();
		Type envelopeType = new TypeToken<Envelope<ExternalAccountIdOnly>>(){}.getType();
		Requestor.performPost("externalaccount/update", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		return true;
	}

	
	
	
	public static Boolean deactivate(Integer customerId, Integer externalAccountId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		
		ExternalAccount ea = new ExternalAccount(customerId, externalAccountId);
		return ea.deactivate(connection, userDefinedObjectForLogging);
	}
	
	public Boolean deactivate(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<Object> envelope = new Envelope<Object>();
		Type envelopeType = new TypeToken<Envelope<Object>>(){}.getType();
		Requestor.performPost("externalaccount/deactivate", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getExternalAccountId() {
		return externalAccountId;
	}

	public void setExternalAccountId(Integer externalAccountId) {
		this.externalAccountId = externalAccountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getRoutingNumberMasked() {
		return routingNumberMasked;
	}

	public void setRoutingNumberMasked(String routingNumberMasked) {
		this.routingNumberMasked = routingNumberMasked;
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

	public String getNocCode() {
		return nocCode;
	}

	public void setNocCode(String nocCode) {
		this.nocCode = nocCode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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
	
	
}
