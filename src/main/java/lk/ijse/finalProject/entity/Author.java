package lk.ijse.finalProject.entity;

public class Author {

    private String author_code;

    private String  author_name;

    private String  author_category;

    private String author_gender;

    public Author(){

    }
    public Author(String author_code, String author_name, String author_category, String author_gender) {
        this.author_code = author_code;
        this.author_name = author_name;
        this.author_category = author_category;
        this.author_gender = author_gender;
    }

    public String getAuthor_code() {
        return author_code;
    }

    public void setAuthor_code(String author_code) {
        this.author_code = author_code;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_category() {
        return author_category;
    }

    public void setAuthor_category(String author_category) {
        this.author_category = author_category;
    }

    public String getAuthor_gender() {
        return author_gender;
    }

    public void setAuthor_gender(String author_gender) {
        this.author_gender = author_gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_code='" + author_code + '\'' +
                ", author_name='" + author_name + '\'' +
                ", author_category='" + author_category + '\'' +
                ", author_gender='" + author_gender + '\'' +
                '}';
    }
}
