package group.sms;

import java.time.LocalDate;

public class advertisement {
    private int advId,clientId;
    String advType;
    private float billAmount,vatPercentage;;
    private boolean isForCharity;
    private LocalDate deliveryDate;



    public advertisement() {
    }



    public advertisement(int advId, int clientId, String advType, float billAmount, float vatPercentage, boolean isForCharity, LocalDate deliveryDate) {
        this.advId = advId;
        this.clientId = clientId;
        this.advType = advType;
        this.billAmount = billAmount;
        this.vatPercentage = vatPercentage;
        this.isForCharity = isForCharity;
        this.deliveryDate = deliveryDate;
    }

    public int getAdvId() {
        return advId;
    }

    public int getClientId() {
        return clientId;
    }

    public String getAdvType() {
        return advType;
    }

    public float getBillAmount() {
        return billAmount;
    }

    public float getVatPercentage() {
        return vatPercentage;
    }

    public boolean isForCharity() {
        return isForCharity;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setAdvId(int advId) {
        this.advId = advId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setAdvType(String advType) {
        this.advType = advType;
    }

    public void setBillAmount(float billAmount) {
        this.billAmount = billAmount;
    }

    public void setVatPercentage(float vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    public void setForCharity(boolean forCharity) {
        isForCharity = forCharity;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void showTotalAmountInAlert(){
        System.out.println(advId);
    }


    @Override
    public String toString() {
        return "advertisement{" +
                "advId=" + advId +
                ", clientId=" + clientId +
                ", advType='" + advType + '\'' +
                ", billAmount=" + billAmount +
                ", vatPercentage=" + vatPercentage +
                ", isForCharity=" + isForCharity +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}