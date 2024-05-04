import org.json.JSONObject;

public class AudioBook extends PaperBook implements Audio {
    
    private MediaType mediaType;

    public AudioBook() {}

    public AudioBook(String name, String author, int publicationYear, MediaType mediaType) {
        super(name, author, publicationYear);
        this.mediaType = mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public void setMediaType(String mediaType) {
        try {
            this.mediaType = MediaType.valueOf(mediaType);
        } catch (Exception e) {
            System.out.println("Не найден тип носителя: " + mediaType);
        }
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + ", формат: %s", mediaType.name());
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("class", getClass().getCanonicalName());
        json.put("name", getName());
        json.put("author", getAuthor());
        json.put("publicationYear", getPublicationYear());
        json.put("mediaType", mediaType);
        return json;
    }
}
