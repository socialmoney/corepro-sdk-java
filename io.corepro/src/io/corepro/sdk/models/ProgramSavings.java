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

import java.util.ArrayList;
import java.util.List;

public class ProgramSavings {
    private String category;
    private String type;
    private ProgramLimit balanceLimit;
    private List<ProgramInterestRate> interestRates;
    private Boolean isExternalWithdrawEnabled;
    private Boolean isInterestEnabled;
    private Boolean isRecurringContributionEnabled;
    private ProgramLimit perTransactionDepositLimit;
    private ProgramLimit perTransactionWithdrawLimit;

    public ProgramSavings() {
        super();
        balanceLimit = new ProgramLimit();
        interestRates = new ArrayList<>();
        perTransactionDepositLimit = new ProgramLimit();
        perTransactionWithdrawLimit  = new ProgramLimit();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProgramLimit getBalanceLimit() {
        return balanceLimit;
    }

    public void setBalanceLimit(ProgramLimit balanceLimit) {
        this.balanceLimit = balanceLimit;
    }

    public List<ProgramInterestRate> getInterestRates() {
        return interestRates;
    }

    public void setInterestRates(List<ProgramInterestRate> interestRates) {
        this.interestRates = interestRates;
    }

    public Boolean getIsExternalWithdrawEnabled() {
        return isExternalWithdrawEnabled;
    }

    public void setIsExternalWithdrawEnabled(Boolean isExternalWithdrawEnabled) {
        this.isExternalWithdrawEnabled = isExternalWithdrawEnabled;
    }

    public Boolean getIsInterestEnabled() {
        return isInterestEnabled;
    }

    public void setIsInterestEnabled(Boolean isInterestEnabled) {
        this.isInterestEnabled = isInterestEnabled;
    }

    public Boolean getIsRecurringContributionEnabled() {
        return isRecurringContributionEnabled;
    }

    public void setIsRecurringContributionEnabled(Boolean isRecurringContributionEnabled) {
        this.isRecurringContributionEnabled = isRecurringContributionEnabled;
    }

    public ProgramLimit getPerTransactionDepositLimit() {
        return perTransactionDepositLimit;
    }

    public void setPerTransactionDepositLimit(ProgramLimit perTransactionDepositLimit) {
        this.perTransactionDepositLimit = perTransactionDepositLimit;
    }

    public ProgramLimit getPerTransactionWithdrawLimit() {
        return perTransactionWithdrawLimit;
    }

    public void setPerTransactionWithdrawLimit(ProgramLimit perTransactionWithdrawLimit) {
        this.perTransactionWithdrawLimit = perTransactionWithdrawLimit;
    }
}