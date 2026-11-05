package ReserveSale_and_SBMA_POJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Detail {

    private List<Jurisdiction> jurisdictions;
    private List<CurrencyAccepted> currencyAccepted;
    private List<TiersData> tiersData;

    @JsonProperty("isPriceLabelChangeEnabled")
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

    public List<TiersData> getTiersData() {
        return tiersData;
    }

    public void setTiersData(List<TiersData> tiersData) {
        this.tiersData = tiersData;
    }

    public boolean isPriceLabelChangeEnabled() {
        return priceLabelChangeEnabled;
    }

    public void setPriceLabelChangeEnabled(boolean priceLabelChangeEnabled) {
        this.priceLabelChangeEnabled = priceLabelChangeEnabled;
    }
}
