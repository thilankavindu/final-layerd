package lk.ijse.finalProject.entity;

public class Vendor {

    private String  vendor_code;

    private String vendor_name;

    private String vendor_contact;

    public Vendor(){

    }

    public Vendor(String vendor_code, String vendor_name, String vendor_contact) {
        this.vendor_code = vendor_code;
        this.vendor_name = vendor_name;
        this.vendor_contact = vendor_contact;
    }

    public String getVendor_code() {
        return vendor_code;
    }

    public void setVendor_code(String vendor_code) {
        this.vendor_code = vendor_code;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getVendor_contact() {
        return vendor_contact;
    }

    public void setVendor_contact(String vendor_contact) {
        this.vendor_contact = vendor_contact;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendor_code='" + vendor_code + '\'' +
                ", vendor_name='" + vendor_name + '\'' +
                ", vendor_contact='" + vendor_contact + '\'' +
                '}';
    }
}
