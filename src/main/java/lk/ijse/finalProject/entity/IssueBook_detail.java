package lk.ijse.finalProject.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IssueBook_detail{
    private String issue_id;

    private String book_id;

    public IssueBook_detail(){

    }

    public IssueBook_detail(String issue_id, String book_id) {
        this.issue_id = issue_id;
        this.book_id = book_id;
    }

    @Override
    public String
    toString() {
        return "IssueBook_detail{" +
                "issue_id='" + issue_id + '\'' +
                ", book_id='" + book_id + '\'' +
                '}';
    }
}