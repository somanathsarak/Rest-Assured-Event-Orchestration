package ReserveSale_and_SBMA_POJO;

public class TiersData {
    private String tiers;
    private String tiersPrices;
    private String totalAllowancesAvailablePerTier;
    private int processingOrder;
    private boolean limitTotalMaximumBidAllowances;
    private int maximumBidAllowances;

    public String getTiers() {
        return tiers;
    }

    public void setTiers(String tiers) {
        this.tiers = tiers;
    }

    public String getTiersPrices() {
        return tiersPrices;
    }

    public void setTiersPrices(String tiersPrices) {
        this.tiersPrices = tiersPrices;
    }

    public String getTotalAllowancesAvailablePerTier() {
        return totalAllowancesAvailablePerTier;
    }

    public void setTotalAllowancesAvailablePerTier(String totalAllowancesAvailablePerTier) {
        this.totalAllowancesAvailablePerTier = totalAllowancesAvailablePerTier;
    }

    public int getProcessingOrder() {
        return processingOrder;
    }

    public void setProcessingOrder(int processingOrder) {
        this.processingOrder = processingOrder;
    }

    public boolean isLimitTotalMaximumBidAllowances() {
        return limitTotalMaximumBidAllowances;
    }

    public void setLimitTotalMaximumBidAllowances(boolean limitTotalMaximumBidAllowances) {
        this.limitTotalMaximumBidAllowances = limitTotalMaximumBidAllowances;
    }

    public int getMaximumBidAllowances() {
        return maximumBidAllowances;
    }

    public void setMaximumBidAllowances(int maximumBidAllowances) {
        this.maximumBidAllowances = maximumBidAllowances;
    }
}
