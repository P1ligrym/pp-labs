package com.company;
import java.util.Arrays;
import java.util.ArrayList;



class Main {

    private Book books[];

    Main() {
        this.books = this.createObjects();
    }

    public static void main(String[] args) {
        Main main = new Main();

        System.out.println("--------All Books--------");
        System.out.println(Arrays.toString(main.books));

        System.out.println("--------Books by Author--------");
        ArrayList<Book> booksByAuthor = main.getBookByAuthor("James Joyce");
        System.out.println(Arrays.toString(booksByAuthor.toArray()));

        System.out.println("--------Books by Edition--------");
        ArrayList<Book> booksByEdition = main.getBookByEdition("Old Lion");
        System.out.println(Arrays.toString(booksByEdition.toArray()));

        System.out.println("--------Books by Year--------");
        ArrayList<Book> booksYoungerThan = main.getBookYoungerThan(2000);
        System.out.println(Arrays.toString(booksYoungerThan.toArray()));
    }

    Book[] createObjects() {
        String names[] = {"In Search of Lost Time", "The Great Gatsby", "Ulysses", "The Dead"};
        String authors[] = {"Marcel Proust", "F. Scott Fitzgerald", "James Joyce", "James Joyce"};
        String edition[] = {"Old Lion", "Old Lion", "Home reading", "Focus","Right Now"};
        int releaseYears[] = {1996, 2005, 2010, 1886, 2006};
        int pages[] = {226, 296, 184, 347};
        int prices[] = {225, 315, 185, 375};
        Book books[] = new Book[4];
        for(int i = 0; i < books.length; i++) {
            books[i] = new Book(i, names[i], authors[i], edition[i], releaseYears[i], pages[i], prices[i]);
        }
        return books;
    }

    public ArrayList<Book> getBookByAuthor(String name) {
        ArrayList<Book> books = new ArrayList();
        for(int i = 0; i < this.books.length; i++) {
            if (this.books[i].getAuthor().equals(name)) {
                books.add(this.books[i]);
            }
        }
        return books;
    }

    public ArrayList<Book> getBookByEdition(String edition) {
        ArrayList<Book> books = new ArrayList();
        for(int i = 0; i < this.books.length; i++) {
            if (this.books[i].getEdition().equals(edition)) {
                books.add(this.books[i]);
            }
        }
        return books;
    }

    public ArrayList<Book> getBookYoungerThan(int year) {
        ArrayList<Book> books = new ArrayList();
        for(int i = 0; i < this.books.length; i++) {
            if (this.books[i].getReleaseYear() > year) {
                books.add(this.books[i]);
            }
        }
        return books;
    }

}






