package altertrade.model;

public class Supplier {

    private Integer growersID;
    private String name;
    private String street;
    private String barangay;
    private String city;
    private String color;
    private String containment;
    private String price_description;
    private Double price_value;
    private String date_created;
    private String date_deleted;
    private String status;

    public Supplier(
            String number,
            String name,
            String street,
            String barangay,
            String city,
            String color,
            String containment,
            String price_description,
            String price_value,
            String date_created,
            String status
    ) {

        this.growersID = Integer.parseInt(number);
        this.name = name;
        this.street = street;
        this.barangay = barangay;
        this.city = city;
        this.color = color;
        this.containment = containment;
        this.price_description = price_description;
        this.price_value = Double.parseDouble(price_value);
        this.date_created = date_created;
        this.status = status;

    }

    //--------------------------
    // M U T A T O R S
    //--------------------------
    public void setGrowersID(Integer number) {
        this.growersID = number;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setContainment(String containment) {
        this.containment = containment;
    }

    public void setPriceDescription(String price_description) {
        this.price_description = price_description;
    }

    public void setPriceValue(Double price_value) {
        this.price_value = price_value;
    }

    public void setDateCreated(String date_created) {
        this.date_created = date_created;
    }

    public void setDateDeleted(String date_deleted) {
        this.date_deleted = date_deleted;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //---------------------------
    // A C C E S S O R S
    //---------------------------
    public Integer getGrowersID() { 
        return this.growersID;
    }

    public String getName() {
        return this.name;
    }

    public String getStreet() {
        return this.street;
    }

    public String getBarangay() {
        return this.barangay;
    }

    public String getCity() {
        return this.city;
    }

    public String getColor() {
        return this.color;
    }

    public String getContainment() {
        return this.containment;
    }

    public String getPriceDescription() {
        return this.price_description;
    }

    public Double getPriceValue() {
        return this.price_value;
    }

    public String getDateCreated() {
        return this.date_created;
    }

    public String getDateDeleted() {
        return this.date_deleted;
    }

    public String getStatus() {
        return this.status;
    }

}
