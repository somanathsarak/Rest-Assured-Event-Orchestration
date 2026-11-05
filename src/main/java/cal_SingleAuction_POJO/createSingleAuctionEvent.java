package cal_SingleAuction_POJO;

public class createSingleAuctionEvent {

	private BasicInfo basicInfo;
    public BasicInfo getBasicInfo() {
		return basicInfo;
	}
	public void setBasicInfo(BasicInfo basicInfo) {
		this.basicInfo = basicInfo;
	}
	public Detail getDetail() {
		return detail;
	}
	public void setDetail(Detail detail) {
		this.detail = detail;
	}
	public DateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	public AdditionalSettings getAdditionalSettings() {
		return additionalSettings;
	}
	public void setAdditionalSettings(AdditionalSettings additionalSettings) {
		this.additionalSettings = additionalSettings;
	}
	private Detail detail;
    private DateTime dateTime;
    private AdditionalSettings additionalSettings;
}