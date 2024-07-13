package lk.ijse.finalProject.entity;

import lk.ijse.finalProject.view.tdm.BookTm;

public class Books extends BookTm {

    private String book_id;

    private String book_name;

    private  String ISBN;

    private String  author;

    private String publisher;

    private  String book_Type;

    private int book_qty;

    private double book_price;

    public Books(){

    }

    public Books(String book_id, String book_name, String ISBN, String author, String publisher, String book_Type, int book_qty, double book_price) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
        this.book_Type = book_Type;
        this.book_qty = book_qty;
        this.book_price = book_price;
    }

    @Override
    public String getBook_id() {
        return book_id;
    }

    @Override
    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    @Override
    public String getBook_name() {
        return book_name;
    }

    @Override
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    @Override
    public String getISBN() {
        return ISBN;
    }

    @Override
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getPublisher() {
        return publisher;
    }

    @Override
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String getBook_Type() {
        return book_Type;
    }

    @Override
    public void setBook_Type(String book_Type) {
        this.book_Type = book_Type;
    }

    @Override
    public int getBook_qty() {
        return book_qty;
    }

    @Override
    public void setBook_qty(int book_qty) {
        this.book_qty = book_qty;
    }

    @Override
    public double getBook_price() {
        return book_price;
    }

    @Override
    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id='" + book_id + '\'' +
                ", book_name='" + book_name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", book_Type='" + book_Type + '\'' +
                ", book_qty=" + book_qty +
                ", book_price=" + book_price +
                '}';
    }
}

