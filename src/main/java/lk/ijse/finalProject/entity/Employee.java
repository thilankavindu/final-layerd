package lk.ijse.finalProject.entity;

public class Employee {
    private String employee_id;

    private String employee_name;

    private String employee_contact;
    public Employee() {
    }

    public Employee(String employee_id, String employee_name, String employee_contact) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_contact = employee_contact;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_contact() {
        return employee_contact;
    }

    public void setEmployee_contact(String employee_contact) {
        this.employee_contact = employee_contact;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id='" + employee_id + '\'' +
                ", employee_name='" + employee_name + '\'' +
                ", employee_contact='" + employee_contact + '\'' +
                '}';
    }
}
