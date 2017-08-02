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

package io.corepro.sdk.models;

import com.google.gson.reflect.TypeToken;
import io.corepro.sdk.AccountClose;
import io.corepro.sdk.Connection;
import io.corepro.sdk.CoreProApiException;
import io.corepro.sdk.utils.Requestor;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AccountAccess  extends ModelBase {

    private Integer targetCustomerId;
    private Integer customerId;
    private String customerTag;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String emailAddress;
    private Integer accountId;
    private String accountTag;
    private String routingNumberMasked;
    private String routingNumber;
    private String accountNumberMasked;
    private String accountNumber;
    private String accountName;
    private String accessTypeCode;
    private Integer primaryCustomerId;
    private Integer customerPriority;

    public AccountAccess addAccess(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        Envelope<AccountAccess> envelope = new Envelope<>();
        Type envelopeType = new TypeToken<Envelope<AccountAccess>>(){}.getType();
        return Requestor.performPost("account/addAccess", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public AccountAccess editAccess(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<AccountAccess> envelope = new Envelope<>();
        Type envelopeType = new TypeToken<Envelope<AccountAccess>>(){}.getType();
        return Requestor.performPost("account/editAccess", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public AccountAccess removeAccess(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<AccountAccess> envelope = new Envelope<>();
        Type envelopeType = new TypeToken<Envelope<AccountAccess>>(){}.getType();
        return Requestor.performPost("account/removeAccess", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public List<AccountAccess> listAccess(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<List<AccountAccess>> envelope = new Envelope<>();
        Type envelopeType = new TypeToken<Envelope<List<AccountAccess>>>(){}.getType();
        return Requestor.performPost("account/listAccess", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Integer getTargetCustomerId() {
        return targetCustomerId;
    }

    public void setTargetCustomerId(Integer targetCustomerId) {
        this.targetCustomerId = targetCustomerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerTag() {
        return customerTag;
    }

    public void setCustomerTag(String customerTag) {
        this.customerTag = customerTag;
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

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountTag() {
        return accountTag;
    }

    public void setAccountTag(String accountTag) {
        this.accountTag = accountTag;
    }

    public String getRoutingNumberMasked() {
        return routingNumberMasked;
    }

    public void setRoutingNumberMasked(String routingNumberMasked) {
        this.routingNumberMasked = routingNumberMasked;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getAccountNumberMasked() {
        return accountNumberMasked;
    }

    public void setAccountNumberMasked(String accountNumberMasked) {
        this.accountNumberMasked = accountNumberMasked;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccessTypeCode() {
        return accessTypeCode;
    }

    public void setAccessTypeCode(String accessTypeCode) {
        this.accessTypeCode = accessTypeCode;
    }

    public Integer getPrimaryCustomerId() {
        return primaryCustomerId;
    }

    public void setPrimaryCustomerId(Integer primaryCustomerId) {
        this.primaryCustomerId = primaryCustomerId;
    }

    public Integer getCustomerPriority() {
        return customerPriority;
    }

    public void setCustomerPriority(Integer customerPriority) {
        this.customerPriority = customerPriority;
    }
}
