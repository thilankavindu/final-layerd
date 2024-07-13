package lk.ijse.finalProject.entity;

import lk.ijse.finalProject.view.tdm.MemberTm;

public class Member extends MemberTm {
    private String member_id;
    private String member_name;
    private String member_address;
    private String member_contact;

    public Member() {
    }

    public Member(String member_id, String member_name, String member_address, String member_contact) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.member_address = member_address;
        this.member_contact = member_contact;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_address() {
        return member_address;
    }

    public void setMember_address(String member_address) {
        this.member_address = member_address;
    }

    public String getMember_contact() {
        return member_contact;
    }

    public void setMember_contact(String member_contact) {
        this.member_contact = member_contact;
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_id='" + member_id + '\'' +
                ", member_name='" + member_name + '\'' +
                ", member_address='" + member_address + '\'' +
                ", member_contact='" + member_contact + '\'' +
                '}';
    }
}
