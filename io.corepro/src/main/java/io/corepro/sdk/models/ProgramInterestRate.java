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

import java.math.BigDecimal;

public class ProgramInterestRate {
	private Integer tier;
	private BigDecimal apy;
	private BigDecimal apr;
	private BigDecimal minimumAmount;
	private BigDecimal maximumAmount;
	
	public String toString() {
		return "Tier:" + this.getTier() + ", Min:" + this.getMinimumAmount() + ", Max:" + this.getMaximumAmount() + ", Apr:" + this.getApr() + ", Apy:" + this.getApy();
	}

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

	public BigDecimal getApy() {
		return apy;
	}

	public void setApy(BigDecimal apy) {
		this.apy = apy;
	}

	public BigDecimal getApr() {
		return apr;
	}

	public void setApr(BigDecimal apr) {
		this.apr = apr;
	}

	public BigDecimal getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(BigDecimal minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public BigDecimal getMaximumAmount() {
		return maximumAmount;
	}

	public void setMaximumAmount(BigDecimal maximumAmount) {
		this.maximumAmount = maximumAmount;
	}
}
