package cal_JointAuction_POJO;

public class VintagesData {
    private String vintages;
    public String getVintages() {
		return vintages;
	}
	public void setVintages(String vintages) {
		this.vintages = vintages;
	}
	public String getVintagesAllowancesAvailable() {
		return vintagesAllowancesAvailable;
	}
	public void setVintagesAllowancesAvailable(String vintagesAllowancesAvailable) {
		this.vintagesAllowancesAvailable = vintagesAllowancesAvailable;
	}
	public String getVintageType() {
		return vintageType;
	}
	public void setVintageType(String vintageType) {
		this.vintageType = vintageType;
	}
	public String getProcessingOrder() {
		return processingOrder;
	}
	public void setProcessingOrder(String processingOrder) {
		this.processingOrder = processingOrder;
	}
	private String vintagesAllowancesAvailable;
    private String vintageType;
    private String processingOrder;
}