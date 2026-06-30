package group.midterm_mock_4;

public class Apartment {
    private String aptNo;
    private String aptType;
    private String address;
    private float sqFeet;
    private boolean isForOffice;
    private float maintenanceFee;
    private float totalPrice;

    public Apartment(String aptNo, String aptType, String address, float sqFeet, boolean isForOffice, float maintenanceFee, float totalPrice) {
        this.aptNo = aptNo;
        this.aptType = aptType;
        this.address = address;
        this.sqFeet = sqFeet;
        this.isForOffice = isForOffice;
        this.maintenanceFee = maintenanceFee;
        this.totalPrice = totalPrice;
    }

    public String getAptNo() {
        return aptNo;
    }

    public String getAptType() {
        return aptType;
    }

    public String getAddress() {
        return address;
    }

    public float getSqFeet() {
        return sqFeet;
    }

    public boolean isForOffice() {
        return isForOffice;
    }

    public float getMaintenanceFee() {
        return maintenanceFee;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setForOffice(boolean forOffice) {
        isForOffice = forOffice;
    }

    public void setMaintenanceFee(float maintenanceFee) {
        this.maintenanceFee = maintenanceFee;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "aptNo='" + aptNo + '\'' +
                ", aptType='" + aptType + '\'' +
                ", address='" + address + '\'' +
                ", sqFeet=" + sqFeet +
                ", isForOffice=" + isForOffice +
                ", maintenanceFee=" + maintenanceFee +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public float returnTotalPayableToSociaty(){

        return 0f;
    }
}
