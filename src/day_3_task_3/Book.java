package day_3_task_3;

public class Book {

    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean status) {
        this.isAvailable = status;
    }

    @Override
    public String toString() {
        return id +". " +title+ " by "+ author + " ["+ (isAvailable ? "Available" : "Issued") + "]";
    }
}
