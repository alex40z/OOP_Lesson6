import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonToBook {

    public static Book convert(JSONObject json) {
        Book book;
        String className = null;

        try {
            className = json.getString("class");
            Class<?> bookClass = Class.forName(className);
            Constructor<?> bookConstructor = bookClass.getConstructor();
            book = (Book)bookConstructor.newInstance();
            for (String keyStr : json.keySet()) {
                if (keyStr.equals("class")) {
                    continue;
                }
                Method method;
                Object keyValue = json.get(keyStr);
                if (keyValue instanceof String) {
                    method = getMethod(bookClass, "set" + keyStr.substring(0, 1).toUpperCase()
                        + keyStr.substring(1), String.class);
                } else if (keyValue instanceof Integer) {
                    method = getMethod(bookClass, "set" + keyStr.substring(0, 1).toUpperCase()
                        + keyStr.substring(1), int.class);
                } else {
                    throw new Exception("Неизвестный тип значения для параметра " + keyStr);
                }
                method.invoke(book, keyValue);  
            }
            return book;
        } catch (JSONException e) {
            System.out.println("Не найден параметр: class");
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс: " + className);
        } catch (NoSuchMethodException e) {
            System.out.println("Не найден метод: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Method getMethod(Class<?> objectClass, String name, Class<?> paramClass) throws NoSuchMethodException {
        Method method;
        try {
            method = objectClass.getDeclaredMethod(name, paramClass);
        } catch (NoSuchMethodException e) {
            if (objectClass == Object.class) {
                throw e;
            }
            method = getMethod(objectClass.getSuperclass(), name, paramClass);
        }
        return method;
    }
}
