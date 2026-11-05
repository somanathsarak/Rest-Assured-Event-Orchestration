package cal_JointAuction_POJO;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Detail {

    private List<Jurisdiction> jurisdictions;
    private List<CurrencyAccepted> currencyAccepted;
    private List<VintagesData> vintagesData;

    private boolean priceLabelChangeEnabled;

    public List<Jurisdiction> getJurisdictions() {
        return jurisdictions;
    }

    public void setJurisdictions(List<Jurisdiction> jurisdictions) {
        this.jurisdictions = jurisdictions;
    }

    public List<CurrencyAccepted> getCurrencyAccepted() {
        return currencyAccepted;
    }

    public void setCurrencyAccepted(List<CurrencyAccepted> currencyAccepted) {
        this.currencyAccepted = currencyAccepted;
    }

    public List<VintagesData> getVintagesData() {
        return vintagesData;
    }

    public void setVintagesData(List<VintagesData> vintagesData) {
        this.vintagesData = vintagesData;
    }

    @JsonProperty("isPriceLabelChangeEnabled")
    public boolean isPriceLabelChangeEnabled() {
        return priceLabelChangeEnabled;
    }

    public void setPriceLabelChangeEnabled(boolean priceLabelChangeEnabled) {
        this.priceLabelChangeEnabled = priceLabelChangeEnabled;
    }
}
