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
import java.util.HashMap;
import java.util.Map;

public class ProgramECode {
    private String category;
    private String type;
    private Integer programECodeId;
    private String productCode;
    private BigDecimal minimumAmount;
    private BigDecimal maximumAmount;
    private Map<String, String> name;
    private Map<String, String> imageUrl;
    private Boolean isReissueSupported;

    public ProgramECode() {
        super();
        imageUrl = new HashMap<String, String>();
        name = new HashMap<String, String>();
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

    public Integer getProgramECodeId() {
        return programECodeId;
    }

    public void setProgramECodeId(Integer programECodeId) {
        this.programECodeId = programECodeId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public Map<String, String> getName() {
        return name;
    }

    public void setName(Map<String, String> name) {
        this.name = name;
    }

    public Map<String, String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Map<String, String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsReissueSupported() {
        return isReissueSupported;
    }

    public void setIsReissueSupported(Boolean isReissueSupported) {
        this.isReissueSupported = isReissueSupported;
    }
}