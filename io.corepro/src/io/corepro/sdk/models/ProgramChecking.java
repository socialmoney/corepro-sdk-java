package io.corepro.sdk.models;

import java.util.ArrayList;

public class ProgramChecking {
    private String category;
    private String type;
    private ProgramLimit balanceLimit;
    private ArrayList<ProgramInterestRate> interestRates;
    private Boolean isExternalWithdrawEnabled;
    private Boolean isInterestEnabled;
    private Boolean isRecurringContributionEnabled;
    private ProgramLimit perTransactionDepositLimit;
    private ProgramLimit perTransactionWithdrawLimit;

    public ProgramChecking() {
        super();
        balanceLimit = new ProgramLimit();
        interestRates = new ArrayList<ProgramInterestRate>();
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

    public ArrayList<ProgramInterestRate> getInterestRates() {
        return interestRates;
    }

    public void setInterestRates(ArrayList<ProgramInterestRate> interestRates) {
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