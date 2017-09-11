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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private Boolean isLocked;
	private Date lockedDate;
	private String lockedReason;
	private String customField1;
	private String customField2;
	private String customField3;
	private String customField4;
	private String customField5;

	private Date lastVerifySentDate;
	private Date lastVerifyExpiredDate;
	private Date lastModifiedDate;
	
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
	
	

	public static List<ExternalAccount> list(Integer customerId, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new ExternalAccount(customerId).list(connection,  userDefinedObjectForLogging);
	}
	
	public List<ExternalAccount> list(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		Envelope<List<ExternalAccount>> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<List<ExternalAccount>>>(){}.getType();
		
		return Requestor.performGet(String.format("externalaccount/list/%d",  this.getCustomerId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	
	public static ExternalAccount get(Integer customerId, Integer externalAccountId, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new ExternalAccount(customerId, externalAccountId).get(connection,  userDefinedObjectForLogging);
	}
	
	public ExternalAccount get(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		Envelope<ExternalAccount> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<ExternalAccount>>(){}.getType();
		return Requestor.performGet(String.format("externalaccount/get/%d/%d",  this.getCustomerId(), this.getExternalAccountId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	public static ExternalAccount getByTag(Integer customerId, String tag, Connection connection, Object userDefinedObjectForLogging) throws Exception{
		return new ExternalAccount(customerId, tag).getByTag(connection,  userDefinedObjectForLogging);
	}
	
	public ExternalAccount getByTag(Connection connection, Object userDefinedObjectForLogging) throws Exception {
		Envelope<ExternalAccount> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<ExternalAccount>>(){}.getType();
		String urlEncodedTag = this.getTag();
		try {
			urlEncodedTag = java.net.URLEncoder.encode(urlEncodedTag, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return Requestor.performGet(String.format("externalaccount/getByTag/%d/%s",  this.getCustomerId(), urlEncodedTag), connection, envelope, envelopeType, userDefinedObjectForLogging);
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
		Envelope<ExternalAccountIdOnly> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<ExternalAccountIdOnly>>(){}.getType();
		ExternalAccountIdOnly accountIdOnly = Requestor.performPost("externalaccount/initiate", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		return accountIdOnly.getExternalAccountId();
	}
	
	public static Boolean verify(Integer customerId, Integer externalAccountId, BigDecimal amount1, BigDecimal amount2, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		ExternalAccount ea = new ExternalAccount(customerId, externalAccountId);
		return ea.verify(amount1, amount2, connection, userDefinedObjectForLogging);
	}
	
	public Boolean verify(BigDecimal amount1, BigDecimal amount2, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<ExternalAccount> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<ExternalAccount>>(){}.getType();
		
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
		Envelope<ExternalAccountIdOnly> envelope = new Envelope<>();
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
		Envelope<ExternalAccountIdOnly> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<ExternalAccountIdOnly>>(){}.getType();
		Requestor.performPost("externalaccount/update", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		return true;
	}

	
	
	
	public static Boolean archive(Integer customerId, Integer externalAccountId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		
		ExternalAccount ea = new ExternalAccount(customerId, externalAccountId);
		return ea.archive(connection, userDefinedObjectForLogging);
	}
	
	public Boolean archive(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<ExternalAccount> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<ExternalAccount>>(){}.getType();
		Requestor.performPost("externalaccount/archive", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
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


	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean locked) {
		isLocked = locked;
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

	public Date getLastVerifySentDate() {
		return lastVerifySentDate;
	}

	public void setLastVerifySentDate(Date lastVerifySentDate) {
		this.lastVerifySentDate = lastVerifySentDate;
	}

	public Date getLastVerifyExpiredDate() {
		return lastVerifyExpiredDate;
	}

	public void setLastVerifyExpiredDate(Date lastVerifyExpiredDate) {
		this.lastVerifyExpiredDate = lastVerifyExpiredDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
