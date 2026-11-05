package cal_SingleAuction_POJO;

import java.util.List;

public class BasicInfo {
    private String eventId;
    public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(String eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public String getEventTypeName() {
		return eventTypeName;
	}
	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}
	public List<String> getParticipatingJurisdictions() {
		return participatingJurisdictions;
	}
	public void setParticipatingJurisdictions(List<String> participatingJurisdictions) {
		this.participatingJurisdictions = participatingJurisdictions;
	}
	public List<String> getParticipatingJurisdictionsNames() {
		return participatingJurisdictionsNames;
	}
	public void setParticipatingJurisdictionsNames(List<String> participatingJurisdictionsNames) {
		this.participatingJurisdictionsNames = participatingJurisdictionsNames;
	}
	public List<EventName> getEventName() {
		return eventName;
	}
	public void setEventName(List<EventName> eventName) {
		this.eventName = eventName;
	}
	private String eventTypeId;
    private String eventTypeName;
    private List<String> participatingJurisdictions;
    private List<String> participatingJurisdictionsNames;
    private List<EventName> eventName;

    // Getters and Setters
}
