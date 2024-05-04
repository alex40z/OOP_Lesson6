/*
 * Принцип открытости/закрытости - для добавления к классу PaperBook нового поля
 * класс был расширен без изменения исходного класса PaperBook.
 * 
 * Принцип подстановки Барбары Лисков - класс PaperBookEx может быть использован
 * с тем же набором параметров в конструкторе, что и класс PaperBook,
 * т.е. ожидаемое поведение переопределенных методов не меняется.
 */

import org.json.JSONObject;

public class PaperBookEx extends PaperBook {

    private int volumesNumber;

    public PaperBookEx() {}
  
    public PaperBookEx(String name, String author, int publicationYear, int volumesNumber) {
        super(name, author, publicationYear);
        this.volumesNumber = volumesNumber;
    }

    public PaperBookEx(String name, String author, int publicationYear) {
        super(name, author, publicationYear);
        this.volumesNumber = 1;
    }
   
    public void setVolumesNumber(int volumesNumber) {
        this.volumesNumber = volumesNumber;
    }
    
    public int getVolumesNumber() {
        return volumesNumber;
    }
 
    @Override
    public String toString() {
        return String.format(super.toString() + ", кол-во томов: %d", volumesNumber);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("class", getClass().getCanonicalName());
        json.put("name", super.getName());
        json.put("author", super.getAuthor());
        json.put("publicationYear", super.getPublicationYear());
        json.put("volumesNumber", volumesNumber);
        return json;
    }
}
