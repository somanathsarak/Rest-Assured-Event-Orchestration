package cal_SingleAuction_POJO;

import java.util.List;

public class DateTime {
    public String getEventBiddingPeriodOpen() {
		return eventBiddingPeriodOpen;
	}
	public void setEventBiddingPeriodOpen(String eventBiddingPeriodOpen) {
		this.eventBiddingPeriodOpen = eventBiddingPeriodOpen;
	}
	public String getEventBiddingPeriodClose() {
		return eventBiddingPeriodClose;
	}
	public void setEventBiddingPeriodClose(String eventBiddingPeriodClose) {
		this.eventBiddingPeriodClose = eventBiddingPeriodClose;
	}
	public String getEventApplicationOpen() {
		return eventApplicationOpen;
	}
	public void setEventApplicationOpen(String eventApplicationOpen) {
		this.eventApplicationOpen = eventApplicationOpen;
	}
	public String getEventApplicationClose() {
		return eventApplicationClose;
	}
	public void setEventApplicationClose(String eventApplicationClose) {
		this.eventApplicationClose = eventApplicationClose;
	}
	public String getBiddingGuaranteeSubmissionDeadline() {
		return biddingGuaranteeSubmissionDeadline;
	}
	public void setBiddingGuaranteeSubmissionDeadline(String biddingGuaranteeSubmissionDeadline) {
		this.biddingGuaranteeSubmissionDeadline = biddingGuaranteeSubmissionDeadline;
	}
	public String getResultsAvailable() {
		return resultsAvailable;
	}
	public void setResultsAvailable(String resultsAvailable) {
		this.resultsAvailable = resultsAvailable;
	}
	public String getEventClosure() {
		return eventClosure;
	}
	public void setEventClosure(String eventClosure) {
		this.eventClosure = eventClosure;
	}
	public String getFinancialSettlement() {
		return financialSettlement;
	}
	public void setFinancialSettlement(String financialSettlement) {
		this.financialSettlement = financialSettlement;
	}
	public List<BiddersConference> getBiddersConference() {
		return biddersConference;
	}
	public void setBiddersConference(List<BiddersConference> biddersConference) {
		this.biddersConference = biddersConference;
	}
	private String eventBiddingPeriodOpen;
    private String eventBiddingPeriodClose;
    private String eventApplicationOpen;
    private String eventApplicationClose;
    private String biddingGuaranteeSubmissionDeadline;
    private String resultsAvailable;
    private String eventClosure;
    private String financialSettlement;
    private List<BiddersConference> biddersConference;

    // Getters and Setters
}
