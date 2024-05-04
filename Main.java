public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        library.addBookToStorage(new PaperBook("Война и мир", "Толстой Л.Н.", 1869));
        library.addBookToStorage(new PaperBook("Бородино", "Лермонтов М.Ю.", 1873));
        library.addBookToStorage(new PaperBook("Преступление и наказание", "Достоевский Ф.М.", 1866));
        library.addBookToStorage(new PaperBook("Идиот", "Достоевский Ф.М.", 1868));
        library.addBookToStorage(new PaperBook("Отверженные", "Гюго В.", 1862));
        library.addBookToStorage(new AudioBook("Мастер и Маргарита", "Булгаков М.Ю.", 1940, MediaType.CD));
        library.addBookToStorage(new PaperBookEx("Собрание сочинений Ленина", "Ленин В.И.", 1920, 20));

        library.issueBook("Преступление и наказание");
        library.issueBook("Бородино");

        System.out.println("--- В библиотеке ---");
        library.showStorageBooks();
        System.out.println("--- Выдано ---");
        library.showIssuedBooks();

        library.saveStorageBooks(new FileStorage());
        library.saveIssuedBooks(new FileStorage());
 
        /* library.loadStorageBooks(new FileStorage());
        library.loadIssuedBooks(new FileStorage());

        System.out.println("--- В библиотеке ---");
        library.showStorageBooks();
        System.out.println("--- Выдано ---");
        library.showIssuedBooks(); */
    }
}
