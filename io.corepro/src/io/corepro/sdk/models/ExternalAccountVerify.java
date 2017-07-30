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
