package lk.ijse.finalProject.model;

public class MemberDTO {
    private String Member_id;
    private String Member_name;
    private String Member_address;
    private String Member_contact;

    public MemberDTO(){

    }

    public MemberDTO(String member_id, String member_name, String member_address, String member_contact) {
        Member_id = member_id;
        Member_name = member_name;
        Member_address = member_address;
        Member_contact = member_contact;
    }

    public String getMember_id() {
        return Member_id;
    }

    public void setMember_id(String member_id) {
        Member_id = member_id;
    }

    public String getMember_name() {
        return Member_name;
    }

    public void setMember_name(String member_name) {
        Member_name = member_name;
    }

    public String getMember_address() {
        return Member_address;
    }

    public void setMember_address(String member_address) {
        Member_address = member_address;
    }

    public String getMember_contact() {
        return Member_contact;
    }

    public void setMember_contact(String member_contact) {
        Member_contact = member_contact;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "Member_id='" + Member_id + '\'' +
                ", Member_name='" + Member_name + '\'' +
                ", Member_address='" + Member_address + '\'' +
                ", Member_contact='" + Member_contact + '\'' +
                '}';
    }
}
