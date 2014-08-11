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
