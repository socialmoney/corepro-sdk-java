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

import com.google.gson.reflect.TypeToken;
import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class AccountBeneficiary extends ModelBase {
    private Integer customerId;
    private Integer accountId;
    private Integer customerBeneficiaryId;
    private String accountNumber;
    private String accountNumberMasked;
    private String accountName;
    private String accountLegalName1;
    private String accountLegalName2;
    private String distributionDescription;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private String taxId;
    private String taxIdMasked;
    private Boolean isActive;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String city;
    private String state;
    private String postalCode;
    private String country;


    public ArrayList<AccountBeneficiary> list(Connection connection, Object userDefinedObjectForLogging) throws Exception {
        Envelope<ArrayList<AccountBeneficiary>> envelope = new Envelope<ArrayList<AccountBeneficiary>>();
        Type envelopeType = new TypeToken<Envelope<ArrayList<AccountBeneficiary>>>(){}.getType();
        return Requestor.performGet(String.format("accountBeneficiary/list/%d",  this.getCustomerId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public AccountBeneficiary get(Connection connection, Object userDefinedObjectForLogging) throws Exception {
        Envelope<AccountBeneficiary> envelope = new Envelope<AccountBeneficiary>();
        Type envelopeType = new TypeToken<Envelope<AccountBeneficiary>>(){}.getType();
        return Requestor.performGet(String.format("accountBeneficiary/get/%d/%d",  this.customerId, this.customerBeneficiaryId), connection, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public AccountBeneficiary add(Connection connection, Object userDefinedObjectForLogging) throws Exception {
        Envelope<AccountBeneficiary> envelope = new Envelope<AccountBeneficiary>();
        Type envelopeType = new TypeToken<Envelope<AccountBeneficiary>>(){}.getType();
        return Requestor.performPost("accountBeneficiary/add", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public AccountBeneficiary edit(Connection connection, Object userDefinedObjectForLogging) throws Exception {
        Envelope<AccountBeneficiary> envelope = new Envelope<AccountBeneficiary>();
        Type envelopeType = new TypeToken<Envelope<AccountBeneficiary>>(){}.getType();
        return Requestor.performPost("accountBeneficiary/edit", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Boolean remove(Connection connection, Object userDefinedObjectForLogging) throws Exception {
        Envelope<Boolean> envelope = new Envelope<Boolean>();
        Type envelopeType = new TypeToken<Envelope<Boolean>>(){}.getType();
        return Requestor.performPost("accountBeneficiary/remove", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
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

    public Integer getCustomerBeneficiaryId() {
        return customerBeneficiaryId;
    }

    public void setCustomerBeneficiaryId(Integer customerBeneficiaryId) {
        this.customerBeneficiaryId = customerBeneficiaryId;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountLegalName1() {
        return accountLegalName1;
    }

    public void setAccountLegalName1(String accountLegalName1) {
        this.accountLegalName1 = accountLegalName1;
    }

    public String getAccountLegalName2() {
        return accountLegalName2;
    }

    public void setAccountLegalName2(String accountLegalName2) {
        this.accountLegalName2 = accountLegalName2;
    }

    public String getDistributionDescription() {
        return distributionDescription;
    }

    public void setDistributionDescription(String distributionDescription) {
        this.distributionDescription = distributionDescription;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
