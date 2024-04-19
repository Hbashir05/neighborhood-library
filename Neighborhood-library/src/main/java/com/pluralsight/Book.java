package com.pluralsight;

import java.util.Scanner;

public class Book {
    private int id =0;
    private String isbn = "";
    private String title = "";
    private boolean isCheckedOut = false;
    private String checkedOutTo = "";

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }
    // Create the setter and getters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
    public void checkOut(String name) {
        // If user wants to checkout a book, set book's isCheckedOut to true and set checkedOutTo to user's name.
        if (!isCheckedOut) {
            isCheckedOut = true;
            checkedOutTo = name;
            System.out.println("Book is now checked out to " + name);
            // If the book is already checked out, print error.
        } else {
            System.out.println("Book is already checked out.");
        }
    }

    // Create the checkIn method.
    public void checkIn() {
        // If user wants to check in a book, set the book's isCheckedOut to false and clear checkedOutTo.
        if (isCheckedOut) {
            isCheckedOut = false;
            checkedOutTo = "";
            System.out.println("Book now checked in.");
            // If book has already been checked in, print error.
        } else {
            System.out.println("Book is already checked in.");
        }
    }
}

