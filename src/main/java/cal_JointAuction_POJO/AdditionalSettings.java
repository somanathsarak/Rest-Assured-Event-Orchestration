package cal_JointAuction_POJO;

public class AdditionalSettings {
    private int allowancesPerBidLot;
    public int getAllowancesPerBidLot() {
		return allowancesPerBidLot;
	}
	public void setAllowancesPerBidLot(int allowancesPerBidLot) {
		this.allowancesPerBidLot = allowancesPerBidLot;
	}
	public int getLimitMaximumBidsAllowed() {
		return limitMaximumBidsAllowed;
	}
	public void setLimitMaximumBidsAllowed(int limitMaximumBidsAllowed) {
		this.limitMaximumBidsAllowed = limitMaximumBidsAllowed;
	}
	public boolean isSetMaximumBidPrice() {
		return setMaximumBidPrice;
	}
	public void setSetMaximumBidPrice(boolean setMaximumBidPrice) {
		this.setMaximumBidPrice = setMaximumBidPrice;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	private int limitMaximumBidsAllowed;
    private boolean setMaximumBidPrice;
    private String algorithm;

}