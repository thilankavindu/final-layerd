package lk.ijse.finalProject.entity;

public class Payment {

    private String payment_code;

    private String payment_method;

    private String payment_date;

    public Payment(){

    }

    public Payment(String payment_code, String payment_method, String payment_date) {
        this.payment_code = payment_code;
        this.payment_method = payment_method;
        this.payment_date = payment_date;
    }

    public String getPayment_code() {
        return payment_code;
    }

    public void setPayment_code(String payment_code) {
        this.payment_code = payment_code;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_code='" + payment_code + '\'' +
                ", payment_method='" + payment_method + '\'' +
                ", payment_date='" + payment_date + '\'' +
                '}';
    }
}
