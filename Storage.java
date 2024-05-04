import java.util.ArrayList;

public interface Storage {

    public void saveData(String dataName, ArrayList<Book> data);
    public ArrayList<Book> loadData(String dataName);
}
