package com.pluralsight;

import java.util.Scanner;

public class BookInventory {

    static Scanner scanner = new Scanner(System.in);

    // Create the array that holds 20 books.
    static Book[] bookInventory = new Book[20];

    // Create the variables.
    static int userChoice;
    static String ifCheckOut;
    static String ifCheckIn;
    static int checkOutBook;
    static int checkInBook;

    public static void main(String[] args) {
        // Call the preloadBooks method.
        preloadBooks();

        // Call the userChoice method.
        userChoice();
    }

    // Create the preloadBooks method.
    public static void preloadBooks() {
        // Preload books into the array.
        bookInventory[0] = new Book(1, "9781603095020", "Animal Stories", true, "");
        bookInventory[1] = new Book(2, "9781603095174", "Ashes", true, "");
        bookInventory[2] = new Book(3, "9780321910417", "Chemistry: The Central Science", false, "");
        bookInventory[3] = new Book(4, "9780307387899", "The Road", false, "");
        bookInventory[4] = new Book(5, "1603093834", "March: Book One", false, "");
        bookInventory[5] = new Book(6, "0345534832", "The Hobbit", false, "");
        bookInventory[6] = new Book(7, "0143123165", "Pride and Prejudice", false, "");
        bookInventory[7] = new Book(8, "9780141196909", "A Tale of Two Cities", false, "");
        bookInventory[8] = new Book(9, "0143107631", "Crime and Punishment", false, "");
        bookInventory[9] = new Book(10, "037571457X", "Persepolis: The Story of a Childhood", false, "");
        bookInventory[10] = new Book(11, "067001690X", "The Grapes of Wrath", false, "");
        bookInventory[11] = new Book(12, "014312854X", "Hamlet", false, "");
        bookInventory[12] = new Book(13, "1101907878", "Rebecca", false, "");
        bookInventory[13] = new Book(14, "0452284236", "1984", false, "");
        bookInventory[14] = new Book(15, "0142437255", "On the Road", false, "");
        bookInventory[15] = new Book(16, "0307264882", "Beloved", false, "");
        bookInventory[16] = new Book(17, "0143124323", "The Secret Life of Bees", false, "");
        bookInventory[17] = new Book(18, "0307474518", "This Side of Paradise", false, "");
        bookInventory[18] = new Book(19, "0452298032", "The Man in the Rockefeller Suit", false, "");
        bookInventory[19] = new Book(20, "0593311892", "The Big Sleep", false, "");
    }

    // Create the userInputs method.
    public static void userChoice() {
        // Ask the user that they want to do.
        System.out.println("What would you like to do?:");
        System.out.println("1 - Show Available Books");
        System.out.println("2 - Show Checked Out Books");
        System.out.println("3 - Exit");
        userChoice = scanner.nextInt();
        scanner.nextLine();

        // Read the user input and execute the appropiate method.
        switch (userChoice) {
            case 1:
                showAvailableBooks();
                break;
            case 2:
                showCheckedOutBooks();
                break;
            case 3:
                return;
        }
    }

    // Create showAvailableBooks method.
    public static void showAvailableBooks() {
        System.out.println("Available Books:");

        // Read the array for all the books that are not checked out and print them.
        for (Book book : bookInventory) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println("Title: " + book.getTitle() + " - " + "ID: " + book.getId() + " - " + "ISBN: " + book.getIsbn());
            }
        }

        // Ask user if they want to check out a book.
        System.out.println("\nDo you want to check out a book? (Yes/No): ");
        ifCheckOut = scanner.nextLine();

        // If user wants to check out a book.
        if (ifCheckOut.equalsIgnoreCase("yes")) {
            checkOutBook();
            // If user doesn't wantot check out a book.
        } else if (ifCheckOut.equalsIgnoreCase("no")) {
            userChoice();
        }
    }

    // Create showCheckedOutBooks method.
    public static void showCheckedOutBooks() {
        System.out.println("Currently Checked Out Books:");

        // Read the array for all the books that are checked out and print them.
        for (Book book: bookInventory) {
            if (book != null && book.isCheckedOut()) {
                System.out.println("Title: " + book.getTitle() + " - " + "ID: " + book.getId() + " - " + "ISBN: " + book.getIsbn() + " - " + "Checked out to: " + book.getCheckedOutTo());
            }
        }

        // Ask the user what would they like to do.
        System.out.println("What would you like to do?");
        System.out.println("C - Check In A Book.");
        System.out.println("X - Go Back to Home Screen.");
        ifCheckIn = scanner.nextLine();

        // Read the user input and execute the appropiate method.
        switch (ifCheckIn) {
            case "C":
                checkInBook();
                break;
            case "X":
                userChoice();
                break;
        }
    }

    // Create checkOutBook method.
    public static void checkOutBook() {
        // Ask the user for the ID of the book they want to check out.
        System.out.print("Please enter the ID of the book you want to check out: ");
        checkOutBook = scanner.nextInt();
        scanner.nextLine();

        // Create the variable.
        boolean found = false;

        // Look for the book in the array using the entered ID.
        for (Book book : bookInventory) {
            if (book != null && book.getId() == checkOutBook && !book.isCheckedOut()) {
                System.out.print("Please enter your name: ");
                String name = scanner.nextLine();

                book.checkOut(name);
                found = true;
                break;
            }
        }
    }

    // Create checkInBook method.
    public static void checkInBook() {
        // Ask the user for the ID of the book they want to check in.
        System.out.print("Please enter the ID of the book you want to check in: ");
        checkInBook = scanner.nextInt();

        // Create the variable.
        boolean found = false;

        // Look for the book in the array using the entered ID.
        for (Book book : bookInventory) {
            if (book != null && book.getId() == checkInBook && book.isCheckedOut()) {
                book.checkIn();
                found = true;
                break;
            }
        }
    }

    }

