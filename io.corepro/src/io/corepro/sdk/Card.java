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
import io.corepro.sdk.models.AccountIdOnly;
import io.corepro.sdk.models.CardAccountLink;
import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class Card extends ModelBase {

    private Integer customerId;
    private Integer cardId;
    private Integer cardHolderCustomerId;
    private String typeCode;
    private String vendorTypeCode;
    private String status;
    private String tag;
    private String cardNumberMasked;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private Integer expireMonth;
    private Integer expireYear;
    private Integer primaryAccountId;
    private String lockTypeCode;
    private String lockReasonTypeCode;
    private Date birthDate;
    private Date createdDate;
    private Date requestedDate;
    private Date verifiedDate;
    private Date reissuedDate;
    private Date deniedDate;
    private Date expiredDate;
    private Date archivedDate;
    private String newPin;
    private ArrayList<Account> accounts;
    private Date lastModifiedDate;
    private String reissueReasonTypeCode;

    public ArrayList<Card> list(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        Envelope<ArrayList<Card>> envelope = new Envelope<ArrayList<Card>>();
        Type envelopeType = new TypeToken<Envelope<ArrayList<Card>>>(){}.getType();
        return Requestor.performGet(String.format("card/list/%d",  this.customerId), connection, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card get(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performGet(String.format("card/get/%d/%d",  this.customerId, this.cardId), connection, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card getByTag(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        String urlEncodedTag = this.getTag();
        try {
            urlEncodedTag = java.net.URLEncoder.encode(urlEncodedTag, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Requestor.performGet(String.format("card/getbytag/%d/%s",  this.customerId, urlEncodedTag), connection, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card initiate(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/initiate", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card verify(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/verify", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card update(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/update", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card resetPin(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/resetpin", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card reissue(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/reissue", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card lock(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/lock", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card unlock(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/unlock", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card hotlist(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/hotlist", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card archive(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/archive", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card addAccount(Integer accountId, Integer priority, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        CardAccountLink cal = new CardAccountLink();
        cal.setCustomerId(this.customerId);
        cal.setAccountId(accountId);
        cal.setPriority(priority);
        cal.setCardId(this.cardId);
        return cal.add(connection, userDefinedObjectForLogging);
    }

    public Card removeAccount(Integer accountId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        CardAccountLink cal = new CardAccountLink();
        cal.setCustomerId(this.customerId);
        cal.setAccountId(accountId);
        cal.setCardId(this.cardId);
        return cal.remove(connection, userDefinedObjectForLogging);
    }

    public Card reprioritizeAccount(Integer accountId, Integer priority, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        CardAccountLink cal = new CardAccountLink();
        cal.setCustomerId(this.customerId);
        cal.setAccountId(accountId);
        cal.setPriority(priority);
        cal.setCardId(this.cardId);
        return cal.reprioritize(connection, userDefinedObjectForLogging);
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getCardHolderCustomerId() {
        return cardHolderCustomerId;
    }

    public void setCardHolderCustomerId(Integer cardHolderCustomerId) {
        this.cardHolderCustomerId = cardHolderCustomerId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getVendorTypeCode() {
        return vendorTypeCode;
    }

    public void setVendorTypeCode(String vendorTypeCode) {
        this.vendorTypeCode = vendorTypeCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCardNumberMasked() {
        return cardNumberMasked;
    }

    public void setCardNumberMasked(String cardNumberMasked) {
        this.cardNumberMasked = cardNumberMasked;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(Integer expireMonth) {
        this.expireMonth = expireMonth;
    }

    public Integer getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(Integer expireYear) {
        this.expireYear = expireYear;
    }

    public Integer getPrimaryAccountId() {
        return primaryAccountId;
    }

    public void setPrimaryAccountId(Integer primaryAccountId) {
        this.primaryAccountId = primaryAccountId;
    }

    public String getLockTypeCode() {
        return lockTypeCode;
    }

    public void setLockTypeCode(String lockTypeCode) {
        this.lockTypeCode = lockTypeCode;
    }

    public String getLockReasonTypeCode() {
        return lockReasonTypeCode;
    }

    public void setLockReasonTypeCode(String lockReasonTypeCode) {
        this.lockReasonTypeCode = lockReasonTypeCode;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public Date getReissuedDate() {
        return reissuedDate;
    }

    public void setReissuedDate(Date reissuedDate) {
        this.reissuedDate = reissuedDate;
    }

    public Date getDeniedDate() {
        return deniedDate;
    }

    public void setDeniedDate(Date deniedDate) {
        this.deniedDate = deniedDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getArchivedDate() {
        return archivedDate;
    }

    public void setArchivedDate(Date archivedDate) {
        this.archivedDate = archivedDate;
    }

    public String getNewPin() {
        return newPin;
    }

    public void setNewPin(String newPin) {
        this.newPin = newPin;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getReissueReasonTypeCode() {
        return reissueReasonTypeCode;
    }

    public void setReissueReasonTypeCode(String reissueReasonTypeCode) {
        this.reissueReasonTypeCode = reissueReasonTypeCode;
    }
}
