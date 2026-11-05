package ReserveSale_and_SBMA_POJO;

public class AdditionalSettings {
    private int allowancesPerBidLot;
    private Integer limitMaximumBidsAllowed;  // Changed from int to Integer
    private boolean setMaximumBidPrice;
    private boolean rollDownProcedure;
    private boolean priceCeiling;

    public int getAllowancesPerBidLot() {
        return allowancesPerBidLot;
    }

    public void setAllowancesPerBidLot(int allowancesPerBidLot) {
        this.allowancesPerBidLot = allowancesPerBidLot;
    }

    public Integer getLimitMaximumBidsAllowed() {
        return limitMaximumBidsAllowed;
    }

    public void setLimitMaximumBidsAllowed(Integer limitMaximumBidsAllowed) {
        this.limitMaximumBidsAllowed = limitMaximumBidsAllowed;
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
