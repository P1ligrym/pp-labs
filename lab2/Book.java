package com.company;

class Book {

    private int id;
    private String name;
    private String author;
    private String edition;
    private int releaseYear;
    private int pages;
    private int price;

    Book(int id, String name, String author, String edition, int releaseYear, int pages, int price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.releaseYear = releaseYear;
        this.pages = pages;
        this.price = price;

    }
    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setname(String name){
        this.name = name;
    }

    public String getname(){
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getpages() {
        return pages;
    }

    public void setpages(int pages) {
        this.pages = pages;
    }

    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book {" +
                "\n  id=" + id +
                "\n  name=" + name +
                "\n  author=" + author +
                "\n  edition=" + edition +
                "\n  releaseYear=" + releaseYear +
                "\n  pages=" + pages +
                "\n  price=" + price +
                "\n}";
    }

}