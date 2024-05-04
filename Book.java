import org.json.JSONObject;

public interface Book {

    public void setName(String name);
    public String getName();
    public void setAuthor(String author);
    public String getAuthor();
    public void setPublicationYear(int publicationYear);
    public int getPublicationYear();
    public String toString();
    public JSONObject toJson();
}
