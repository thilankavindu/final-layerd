package lk.ijse.finalProject.view.tdm;

public class CartTm {
    private String Book_id;
    private String Book_name;
    private String ISBN;
    private String Author;
    private String Publisher;
    private String Book_type;

    public CartTm(){

    }

    public CartTm(String book_id, String book_name, String ISBN, String author, String publisher, String book_type) {
        Book_id = book_id;
        Book_name = book_name;
        this.ISBN = ISBN;
        Author = author;
        Publisher = publisher;
        Book_type = book_type;
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

    public String getBook_type() {
        return Book_type;
    }

    public void setBook_type(String book_type) {
        Book_type = book_type;
    }

    @Override
    public String toString() {
        return "CartTm{" +
                "Book_id='" + Book_id + '\'' +
                ", Book_name='" + Book_name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Author='" + Author + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", Book_type='" + Book_type + '\'' +
                '}';
    }
}
