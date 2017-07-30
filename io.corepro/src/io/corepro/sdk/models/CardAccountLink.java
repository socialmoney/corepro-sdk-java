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
import io.corepro.sdk.Card;
import io.corepro.sdk.Connection;
import io.corepro.sdk.CoreProApiException;
import io.corepro.sdk.utils.Requestor;

import java.lang.reflect.Type;

public class CardAccountLink extends ModelBase {
    private Integer customerId;
    private Integer cardId;
    private Integer accountId;
    private Integer priority;

    public Card add(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/addAccount", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card remove(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/removeAccount", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

    public Card reprioritize(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
        Envelope<Card> envelope = new Envelope<Card>();
        Type envelopeType = new TypeToken<Envelope<Card>>(){}.getType();
        return Requestor.performPost("card/reprioritizeAccount", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
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

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
