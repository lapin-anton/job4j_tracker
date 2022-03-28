package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book harryPotter = new Book("Harry Potter", 550);
        Book thinkingJava = new Book("Thinking on Java", 600);
        Book cleanCode = new Book("Clean Code", 1200);
        Book lordOfTheRings = new Book("Lord of the Rings", 100500);
        Book[] books = new Book[]{harryPotter, thinkingJava, cleanCode, lordOfTheRings};
        printBooks(books);
        swapBooks(books, 0, 3);
        printBooks(books);
        printByNameOnly(books, "Clean Code");
    }

    private static void printByNameOnly(Book[] books, String name) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals(name)) {
                System.out.printf("%s - %d %n", books[i].getName(), books[i].getPages());
            }
        }
        System.out.println();
    }

    private static void printBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.printf("%s - %d %n", books[i].getName(), books[i].getPages());
        }
        System.out.println();
    }

    private static void swapBooks(Book[] books, int src, int target) {
        Book temp = books[target];
        books[target] = books[src];
        books[src] = temp;
    }
}
