package cal_JointAuction_POJO;

public class Jurisdictions {
    private String jurisdictionName;
    public String getJurisdictionName() {
		return jurisdictionName;
	}
	public void setJurisdictionName(String jurisdictionName) {
		this.jurisdictionName = jurisdictionName;
	}
	public Object getAnnualReservePrice() {
		return annualReservePrice;
	}
	public void setAnnualReservePrice(Object annualReservePrice) {
		this.annualReservePrice = annualReservePrice;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Object getFxRate() {
		return fxRate;
	}
	public void setFxRate(Object fxRate) {
		this.fxRate = fxRate;
	}
	public String getApproverName() {
		return approverName;
	}
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	public boolean isJuridictionSubmited() {
		return isJuridictionSubmited;
	}
	public void setJuridictionSubmited(boolean isJuridictionSubmited) {
		this.isJuridictionSubmited = isJuridictionSubmited;
	}
	public Object getApprovedReservePriceCurrent() {
		return approvedReservePriceCurrent;
	}
	public void setApprovedReservePriceCurrent(Object approvedReservePriceCurrent) {
		this.approvedReservePriceCurrent = approvedReservePriceCurrent;
	}
	public Object getApprovedReservePriceFuture() {
		return approvedReservePriceFuture;
	}
	public void setApprovedReservePriceFuture(Object approvedReservePriceFuture) {
		this.approvedReservePriceFuture = approvedReservePriceFuture;
	}
	public String getJurisdictionId() {
		return jurisdictionId;
	}
	public void setJurisdictionId(String jurisdictionId) {
		this.jurisdictionId = jurisdictionId;
	}
	private Object annualReservePrice;
    private String currencyId;
    private String currency;
    private Object fxRate; // Handles both String and Number
    private String approverName;
    private boolean isJuridictionSubmited;
    private Object approvedReservePriceCurrent;
    private Object approvedReservePriceFuture;
    private String jurisdictionId;

}