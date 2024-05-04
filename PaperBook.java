import org.json.JSONObject;

public class PaperBook implements Book {

    private String name;
    private String author;
    private int publicationYear;

    public PaperBook() {}
  
    public PaperBook(String name, String author, int publicationYear) {
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
    }
   
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
   
    public String getAuthor() {
        return author;
    }
    
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    
    public int getPublicationYear() {
        return publicationYear;
    }
   
    public String toString() {
        return String.format("Книга: %s, автор: %s, год издания: %d", name, author, publicationYear);
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("class", getClass().getCanonicalName());
        json.put("name", name);
        json.put("author", author);
        json.put("publicationYear", publicationYear);
        return json;
    }
}
