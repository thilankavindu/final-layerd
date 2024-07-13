package lk.ijse.finalProject.view.tdm;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
public class ReturnTm {
        private final StringProperty issueId;
        private final StringProperty issueDate;
        private final StringProperty memberId;



        public ReturnTm(String issueId, String issueDate, String memberId) {
            this.issueId = new SimpleStringProperty(issueId);
            this.issueDate = new SimpleStringProperty(issueDate);
            this.memberId = new SimpleStringProperty(memberId);
        }

        public String getIssueId() {
            return issueId.get();
        }

        public StringProperty issueIdProperty() {
            return issueId;
        }

        public String getIssueDate() {
            return issueDate.get();
        }

        public StringProperty issueDateProperty() {
            return issueDate;
        }

        public String getMemberId() {
            return memberId.get();
        }


    public ObservableValue<String> memberIdProperty() {

        return null;
    }
}
