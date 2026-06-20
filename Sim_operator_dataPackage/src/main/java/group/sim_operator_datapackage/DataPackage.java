package group.sim_operator_datapackage;

import java.time.LocalDate;

public class DataPackage {
    private String Package_name;
    private float Data_amount;
    private int Price;
    private String Validity;
    private String Price_Availability;
    private LocalDate Ofer_ends;

    public DataPackage(String package_name, float data_amount, int price, String validity, String price_Availability, LocalDate ofer_ends) {
        Package_name = package_name;
        Data_amount = data_amount;
        Price = price;
        Validity = validity;
        Price_Availability = price_Availability;
        Ofer_ends = ofer_ends;
    }

    public String getPackage_name() {
        return Package_name;
    }

    public void setPackage_name(String package_name) {
        Package_name = package_name;
    }

    public float getData_amount() {
        return Data_amount;
    }

    public void setData_amount(float data_amount) {
        Data_amount = data_amount;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getValidity() {
        return Validity;
    }

    public void setValidity(String validity) {
        Validity = validity;
    }

    public String getPrice_Availability() {
        return Price_Availability;
    }

    public void setPrice_Availability(String price_Availability) {
        Price_Availability = price_Availability;
    }

    public LocalDate getOfer_ends() {
        return Ofer_ends;
    }

    public void setOfer_ends(LocalDate ofer_ends) {
        Ofer_ends = ofer_ends;
    }

    @Override
    public String toString() {
        return "DataPackage{" +
                "Package_name='" + Package_name + '\'' +
                ", Data_amount=" + Data_amount +
                ", Price=" + Price +
                ", Validity='" + Validity + '\'' +
                ", Price_Availability='" + Price_Availability + '\'' +
                ", Ofer_ends='" + Ofer_ends + '\'' +
                '}';
    }
}
