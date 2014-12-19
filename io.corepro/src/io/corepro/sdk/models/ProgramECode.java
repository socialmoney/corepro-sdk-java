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