package ReserveSale_and_SBMA_POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdditionalSettings1 {

    private int allowancesPerBidLot;

    private String limitMaximumBidsAllowed;

    @JsonProperty("isLimitMaximumBidsAllowed")
    private boolean limitMaximumBidsAllowedEnabled;

    private boolean setMaximumBidPrice;
    private boolean rollDownProcedure;
    private boolean priceCeiling;

    public int getAllowancesPerBidLot() {
        return allowancesPerBidLot;
    }

    public void setAllowancesPerBidLot(int allowancesPerBidLot) {
        this.allowancesPerBidLot = allowancesPerBidLot;
    }

    public String getLimitMaximumBidsAllowed() {
        return limitMaximumBidsAllowed;
    }

    public void setLimitMaximumBidsAllowed(String limitMaximumBidsAllowed) {
        this.limitMaximumBidsAllowed = limitMaximumBidsAllowed;
    }

    public boolean isLimitMaximumBidsAllowedEnabled() {
        return limitMaximumBidsAllowedEnabled;
    }

    public void setLimitMaximumBidsAllowedEnabled(boolean limitMaximumBidsAllowedEnabled) {
        this.limitMaximumBidsAllowedEnabled = limitMaximumBidsAllowedEnabled;
    }

    public boolean isSetMaximumBidPrice() {
        return setMaximumBidPrice;
    }

    public void setSetMaximumBidPrice(boolean setMaximumBidPrice) {
        this.setMaximumBidPrice = setMaximumBidPrice;
    }

    public boolean isRollDownProcedure() {
        return rollDownProcedure;
    }

    public void setRollDownProcedure(boolean rollDownProcedure) {
        this.rollDownProcedure = rollDownProcedure;
    }

    public boolean isPriceCeiling() {
        return priceCeiling;
    }

    public void setPriceCeiling(boolean priceCeiling) {
        this.priceCeiling = priceCeiling;
    }
}
