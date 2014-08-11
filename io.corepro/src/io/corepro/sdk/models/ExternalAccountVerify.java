package io.corepro.sdk.models;

import java.math.BigDecimal;

public class ExternalAccountVerify extends ModelBase {
	private Integer customerId;
	private Integer externalAccountId;
	private BigDecimal amount1;
	private BigDecimal amount2;
	
	public ExternalAccountVerify() {
		super();
	}
	
	public ExternalAccountVerify(Integer customerId, Integer externalAccountId, BigDecimal amount1, BigDecimal amount2){
		this();
		this.setCustomerId(customerId);
		this.setExternalAccountId(externalAccountId);
		this.setAmount1(amount1);
		this.setAmount2(amount2);
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getExternalAccountId() {
		return externalAccountId;
	}

	public void setExternalAccountId(Integer externalAccountId) {
		this.externalAccountId = externalAccountId;
	}

	public BigDecimal getAmount1() {
		return amount1;
	}

	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}

	public BigDecimal getAmount2() {
		return amount2;
	}

	public void setAmount2(BigDecimal amount2) {
		this.amount2 = amount2;
	}
}
