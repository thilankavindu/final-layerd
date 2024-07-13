package lk.ijse.finalProject.dto;

import java.sql.Date;

public class CustomDTO {
    private String Book_id;
    private String Book_name;
    private String ISBN;
    private String Author;
    private String Publisher;
    private String Book_Type;
    private double Book_price;
    private int Book_qty;

    private String Member_id;
    private String Member_name;
    private String Member_address;
    private String Member_contact;

    private static String issue_id;
    private static Date issue_date;
    private static Date return_date;
    private static String member_id;

    public CustomDTO(){

    }

    public CustomDTO(String book_id, String book_name, String ISBN, String author, String publisher, String book_Type, double book_price, int book_qty, String member_id, String member_name, String member_address, String member_contact) {
        Book_id = book_id;
        Book_name = book_name;
        this.ISBN = ISBN;
        Author = author;
        Publisher = publisher;
        Book_Type = book_Type;
        Book_price = book_price;
        Book_qty = book_qty;
        Member_id = member_id;
        Member_name = member_name;
        Member_address = member_address;
        Member_contact = member_contact;
    }

    public String getBook_id() {
        return Book_id;
    }

    public void setBook_id(String book_id) {
        Book_id = book_id;
    }

    public String getBook_name() {
        return Book_name;
    }

    public void setBook_name(String book_name) {
        Book_name = book_name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getBook_Type() {
        return Book_Type;
    }

    public void setBook_Type(String book_Type) {
        Book_Type = book_Type;
    }

    public double getBook_price() {
        return Book_price;
    }

    public void setBook_price(double book_price) {
        Book_price = book_price;
    }

    public int getBook_qty() {
        return Book_qty;
    }

    public void setBook_qty(int book_qty) {
        Book_qty = book_qty;
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

    public static String getIssue_id() {
        return issue_id;
    }

    public static void setIssue_id(String issue_id) {
        CustomDTO.issue_id = issue_id;
    }

    public static Date getIssue_date() {
        return issue_date;
    }

    public static void setIssue_date(Date issue_date) {
        CustomDTO.issue_date = issue_date;
    }

    public static Date getReturn_date() {
        return return_date;
    }

    public static void setReturn_date(Date return_date) {
        CustomDTO.return_date = return_date;
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "Book_id='" + Book_id + '\'' +
                ", Book_name='" + Book_name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Author='" + Author + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", Book_Type='" + Book_Type + '\'' +
                ", Book_price=" + Book_price +
                ", Book_qty=" + Book_qty +
                ", Member_id='" + Member_id + '\'' +
                ", Member_name='" + Member_name + '\'' +
                ", Member_address='" + Member_address + '\'' +
                ", Member_contact='" + Member_contact + '\'' +
                '}';
    }
}
