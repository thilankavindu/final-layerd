package lk.ijse.finalProject.entity;


import java.sql.Date;

public class ReturnBook {
    private static String issue_id;
    private static Date issue_date;
    private static Date return_date;
    private static String member_id;

    public ReturnBook(){

    }

    public ReturnBook(String issue_id, Date issue_date, Date return_date, String member_id) {
        this.issue_id = issue_id;
        this.issue_date = issue_date;
        this.return_date = return_date;
        this.member_id = member_id;
    }

    public ReturnBook(String issueId, Date issueDate, Date returnDate) {

    }

    public static String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }

    public static Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public static Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public static String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    @Override
    public String toString() {
        return "ReturnBook{" +
                "issue_id='" + issue_id + '\'' +
                ", issue_date=" + issue_date +
                ", return_date=" + return_date +
                ", member_id='" + member_id + '\'' +
                '}';
    }
}
