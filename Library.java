/*
 * Принцип единой ответственности - класс Library управляет списком книг, но сохранение
 * списков реализовано в отдельном классе Storage.
 * 
 * Принцип инверсии зависимостей - класс Library не зависит от реализации Storage.
 * Можно изменить способ хранения данных без изменения класса Library.
 */

import java.util.ArrayList;

public class Library {
    
    private ArrayList<Book> storageBooks;
    private ArrayList<Book> issuedBooks;

    public Library() {
        this.storageBooks = new ArrayList<>();
        this.issuedBooks = new ArrayList<>();
    }

    public void addBookToStorage(Book book) {
        storageBooks.add(book);
    }

    public Book searchBook(String bookName) {
        for (Book book : storageBooks) {
            if (book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public void issueBook(String bookName) {
        Book book = searchBook(bookName);
        if (book != null) {
            storageBooks.remove(book);
            issuedBooks.add(book);
        }
    }

    public void showStorageBooks() {
        for (Book book : storageBooks) {
            System.out.println(book.toString());
        }
    }

    public void showIssuedBooks() {
        for (Book book : issuedBooks) {
            System.out.println(book.toString());
        }
    }

    public void saveStorageBooks(Storage storage) {
        storage.saveData("storage", storageBooks);
    }

    public void loadStorageBooks(Storage storage) {
        storageBooks = storage.loadData("storage");
    }

    public void saveIssuedBooks(Storage storage) {
        storage.saveData("issued", issuedBooks);
    }

    public void loadIssuedBooks(Storage storage) {
        issuedBooks = storage.loadData("issued");
    }
}
