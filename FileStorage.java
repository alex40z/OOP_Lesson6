import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class FileStorage implements Storage {
    
    public void saveData(String dataName, ArrayList<Book> data) {
        JSONArray json = new JSONArray();

        for (Book book : data) {
            json.put(book.toJson());
        }

        try (FileWriter writer = new FileWriter(dataName + ".txt", false)) {
            writer.write(json.toString());
            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }

    public ArrayList<Book> loadData(String dataName) {
        ArrayList<Book> data = new ArrayList<>();
        String text = "";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(dataName + ".txt"))) {
            while ((line = reader.readLine()) != null) {
                text = text + "\n" + line;
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        JSONArray json = new JSONArray(text);
        for (Object object : json) {
            if (object instanceof JSONObject) {
                Book book = JsonToBook.convert((JSONObject)object);
                if (book != null) {
                    data.add(book);
                }
            }
        }
        return data;
    }
}
