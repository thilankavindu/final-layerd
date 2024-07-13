package lk.ijse.finalProject.entity;

public class Author_Book {

    private String author_code;

    private String book_id;

    public Author_Book(){
    }

    public Author_Book(String author_code, String book_id) {
        this.author_code = author_code;
        this.book_id = book_id;
    }

    public String getAuthor_code() {
        return author_code;
    }

    public void setAuthor_code(String author_code) {
        this.author_code = author_code;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    @Override
    public String toString() {
        return "Author_Book{" +
                "author_code='" + author_code + '\'' +
                ", book_id='" + book_id + '\'' +
                '}';
    }
}
