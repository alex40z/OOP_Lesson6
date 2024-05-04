/*
 * Принцип разделения интерфейса - интерфейс Audio реализовывается только в том случае,
 * если класс будет его использовать.
 */
public interface Audio {

    public void setMediaType(MediaType mediaType);
    public MediaType getMediaType();
}
