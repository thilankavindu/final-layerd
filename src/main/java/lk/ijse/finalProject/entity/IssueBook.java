package lk.ijse.finalProject.entity;

import lk.ijse.finalProject.repository.IssueBookRepo;

import java.sql.Date;

public class IssueBook extends IssueBookRepo {
    private String issue_id;
    private Date issue_date;
    private String member_id;

    public IssueBook() {

    }

    public IssueBook(String issue_id, Date issue_date, String member_id) {
        this.issue_id = issue_id;
        this.issue_date = issue_date;
        this.member_id = member_id;
    }

    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    @Override
    public String
    toString() {
        return "IssueBook{" +
                "issue_id='" + issue_id + '\'' +
                ", issue_date=" + issue_date +
                ", member_id='" + member_id + '\'' +
                '}';
    }
}