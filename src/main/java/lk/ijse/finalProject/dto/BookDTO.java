package lk.ijse.finalProject.dto;

public class BookDTO {
    private String Book_id;
    private String Book_name;
    private String ISBN;
    private String Author;
    private String Publisher;
    private String Book_Type;
    private double Book_price;
    private int Book_qty;

    public BookDTO(){
    }

    public BookDTO(String book_id, String book_name, String ISBN, String author, String publisher, String book_Type, double book_price, int book_qty) {
        Book_id = book_id;
        Book_name = book_name;
        this.ISBN = ISBN;
        Author = author;
        Publisher = publisher;
        Book_Type = book_Type;
        Book_price = book_price;
        Book_qty = book_qty;
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

    @Override
    public String toString() {
        return "BookDTO{" +
                "Book_id='" + Book_id + '\'' +
                ", Book_name='" + Book_name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Author='" + Author + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", Book_Type='" + Book_Type + '\'' +
                ", Book_price=" + Book_price +
                ", Book_qty=" + Book_qty +
                '}';
    }
}
