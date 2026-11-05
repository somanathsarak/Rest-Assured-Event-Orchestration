package cal_JointAuction_POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaleEventData {
    private String saleEventId;
    public String getSaleEventId() {
		return saleEventId;
	}
	public void setSaleEventId(String saleEventId) {
		this.saleEventId = saleEventId;
	}
	public String getBaseCurrencyTypeId() {
		return baseCurrencyTypeId;
	}
	public void setBaseCurrencyTypeId(String baseCurrencyTypeId) {
		this.baseCurrencyTypeId = baseCurrencyTypeId;
	}
	public String getToCurrencyTypeId() {
		return toCurrencyTypeId;
	}
	public void setToCurrencyTypeId(String toCurrencyTypeId) {
		this.toCurrencyTypeId = toCurrencyTypeId;
	}
	public String getFxRate() {
		return fxRate;
	}
	public void setFxRate(String fxRate) {
		this.fxRate = fxRate;
	}
	public String getJurisdictionId() {
		return jurisdictionId;
	}
	public void setJurisdictionId(String jurisdictionId) {
		this.jurisdictionId = jurisdictionId;
	}
	@JsonProperty("isSecondSubmission")
	public boolean isSecondSubmission() {
		return secondSubmission;
	}
	public void setSecondSubmission(boolean secondSubmission) {
		this.secondSubmission = secondSubmission;
	}
	public ResultData getResultData() {
		return resultData;
	}
	public void setResultData(ResultData resultData) {
		this.resultData = resultData;
	}
	private String baseCurrencyTypeId;
    private String toCurrencyTypeId;
    private String fxRate;
    private String jurisdictionId;
    private boolean secondSubmission;
    private ResultData resultData;

}
