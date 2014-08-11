package io.corepro.sdk.models;

import java.math.BigDecimal;

public class ProgramLimit {
	private BigDecimal minimumAmount;
	private BigDecimal maximumAmount;
	
	public String toString() {
		return "Min:" + this.getMinimumAmount() + ", Max:" + this.getMaximumAmount();
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
