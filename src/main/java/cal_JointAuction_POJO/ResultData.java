package cal_JointAuction_POJO;

import java.util.List;

public class ResultData {
    private String saleEventName;
    public String getSaleEventName() {
		return saleEventName;
	}
	public void setSaleEventName(String saleEventName) {
		this.saleEventName = saleEventName;
	}
	public String getSaleEventId() {
		return saleEventId;
	}
	public void setSaleEventId(String saleEventId) {
		this.saleEventId = saleEventId;
	}
	public boolean isEventFXRateStatus() {
		return eventFXRateStatus;
	}
	public void setEventFXRateStatus(boolean eventFXRateStatus) {
		this.eventFXRateStatus = eventFXRateStatus;
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
	public List<Jurisdictions> getJurisdictions() {
		return jurisdictions;
	}
	public void setJurisdictions(List<Jurisdictions> jurisdictions) {
		this.jurisdictions = jurisdictions;
	}
	public int getIsAllowedToResetFxRate() {
		return isAllowedToResetFxRate;
	}
	public void setIsAllowedToResetFxRate(int isAllowedToResetFxRate) {
		this.isAllowedToResetFxRate = isAllowedToResetFxRate;
	}
	public boolean isBiddingOpen() {
		return isBiddingOpen;
	}
	public void setBiddingOpen(boolean isBiddingOpen) {
		this.isBiddingOpen = isBiddingOpen;
	}
	private String saleEventId;
    private boolean eventFXRateStatus;
    private String baseCurrencyTypeId;
    private String toCurrencyTypeId;
    private List<Jurisdictions> jurisdictions;
    private int isAllowedToResetFxRate;
    private boolean isBiddingOpen;

}