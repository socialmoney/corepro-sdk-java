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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.models.ProgramLimit;
import io.corepro.sdk.utils.Requestor;
import io.corepro.sdk.models.ProgramChecking;
import io.corepro.sdk.models.ProgramECode;
import io.corepro.sdk.models.ProgramPrepaid;
import io.corepro.sdk.models.ProgramSavings;

public class Program extends ModelBase {
	
	private String name;
	private String verificationType;
	private ProgramLimit perUserDailyWithdrawLimit;
	private ProgramLimit perUserMonthlyWithdrawLimit;
	private ProgramLimit perProgramDailyWithdrawLimit;
	
	private ProgramLimit perUserDailyDepositLimit;
	private ProgramLimit perUserMonthlyDepositLimit;
	private ProgramLimit perProgramDailyDepositLimit;
	
	private String website;
	private Boolean isInternalToInternalTransferEnabled;
	private BigDecimal decimalCount;

	private Date filledDate;

    private Integer perUserExternalAccountCountMax;
    private Integer perUserAccountCountMax;
    private BigDecimal perUserTotalAccountBalanceMax;

    private Map<String, ProgramChecking> checkingProducts;
    private Map<String, ProgramECode> eCodeProducts;
    private Map<String, ProgramPrepaid> prepaidProducts;
    private Map<String, ProgramSavings> savingsProducts;

	public Program() {
		super();
        checkingProducts = new HashMap<String, ProgramChecking>();
        eCodeProducts = new HashMap<String, ProgramECode>();
        prepaidProducts = new HashMap<String, ProgramPrepaid>();
        savingsProducts = new HashMap<String, ProgramSavings>();
	}
	
	public static Program get(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<Program> envelope = new Envelope<Program>();
		Type envelopeType = new TypeToken<Envelope<Program>>(){}.getType();
		return Requestor.performGet("program/get", connection, envelope, envelopeType, userDefinedObjectForLogging);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVerificationType() {
		return verificationType;
	}

	public void setVerificationType(String verificationType) {
		this.verificationType = verificationType;
	}

	public ProgramLimit getPerUserDailyWithdrawLimit() {
		return perUserDailyWithdrawLimit;
	}

	public void setPerUserDailyWithdrawLimit(ProgramLimit perUserDailyWithdrawLimit) {
		this.perUserDailyWithdrawLimit = perUserDailyWithdrawLimit;
	}

	public ProgramLimit getPerUserMonthlyWithdrawLimit() {
		return perUserMonthlyWithdrawLimit;
	}

	public void setPerUserMonthlyWithdrawLimit(
			ProgramLimit perUserMonthlyWithdrawLimit) {
		this.perUserMonthlyWithdrawLimit = perUserMonthlyWithdrawLimit;
	}

	public ProgramLimit getPerProgramDailyWithdrawLimit() {
		return perProgramDailyWithdrawLimit;
	}

	public void setPerProgramDailyWithdrawLimit(
			ProgramLimit perProgramDailyWithdrawLimit) {
		this.perProgramDailyWithdrawLimit = perProgramDailyWithdrawLimit;
	}

	public ProgramLimit getPerUserDailyDepositLimit() {
		return perUserDailyDepositLimit;
	}

	public void setPerUserDailyDepositLimit(ProgramLimit perUserDailyDepositLimit) {
		this.perUserDailyDepositLimit = perUserDailyDepositLimit;
	}

	public ProgramLimit getPerUserMonthlyDepositLimit() {
		return perUserMonthlyDepositLimit;
	}

	public void setPerUserMonthlyDepositLimit(ProgramLimit perUserMonthlyDepositLimit) {
		this.perUserMonthlyDepositLimit = perUserMonthlyDepositLimit;
	}

	public ProgramLimit getPerProgramDailyDepositLimit() {
		return perProgramDailyDepositLimit;
	}

	public void setPerProgramDailyDepositLimit(
			ProgramLimit perProgramDailyDepositLimit) {
		this.perProgramDailyDepositLimit = perProgramDailyDepositLimit;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Boolean getIsInternalToInternalTransferEnabled() {
		return isInternalToInternalTransferEnabled;
	}

	public void setIsInternalToInternalTransferEnabled(
			Boolean isInternalToInternalTransferEnabled) {
		this.isInternalToInternalTransferEnabled = isInternalToInternalTransferEnabled;
	}

	public BigDecimal getDecimalCount() {
		return decimalCount;
	}

	public void setDecimalCount(BigDecimal decimalCount) {
		this.decimalCount = decimalCount;
	}

	public Date getFilledDate() {
		return filledDate;
	}

	public void setFilledDate(Date filledDate) {
		this.filledDate = filledDate;
	}


    public Integer getPerUserExternalAccountCountMax() {
        return perUserExternalAccountCountMax;
    }

    public void setPerUserExternalAccountCountMax(Integer perUserExternalAccountCountMax) {
        this.perUserExternalAccountCountMax = perUserExternalAccountCountMax;
    }

    public Integer getPerUserAccountCountMax() {
        return perUserAccountCountMax;
    }

    public void setPerUserAccountCountMax(Integer perUserAccountCountMax) {
        this.perUserAccountCountMax = perUserAccountCountMax;
    }

    public BigDecimal getPerUserTotalAccountBalanceMax() {
        return perUserTotalAccountBalanceMax;
    }

    public void setPerUserTotalAccountBalanceMax(BigDecimal perUserTotalAccountBalanceMax) {
        this.perUserTotalAccountBalanceMax = perUserTotalAccountBalanceMax;
    }

    public Map<String, ProgramChecking> getCheckingProducts() {
        return checkingProducts;
    }

    public void setCheckingProducts(Map<String, ProgramChecking> checkingProducts) {
        this.checkingProducts = checkingProducts;
    }

    public Map<String, ProgramECode> getECodeProducts() {
        return eCodeProducts;
    }

    public void setECodeProducts(Map<String, ProgramECode> eCodeProducts) {
        this.eCodeProducts = eCodeProducts;
    }

    public Map<String, ProgramPrepaid> getPrepaidProducts() {
        return prepaidProducts;
    }

    public void setPrepaidProducts(Map<String, ProgramPrepaid> prepaidProducts) {
        this.prepaidProducts = prepaidProducts;
    }

    public Map<String, ProgramSavings> getSavingsProducts() {
        return savingsProducts;
    }

    public void setSavingsProducts(Map<String, ProgramSavings> savingsProducts) {
        this.savingsProducts = savingsProducts;
    }
}
