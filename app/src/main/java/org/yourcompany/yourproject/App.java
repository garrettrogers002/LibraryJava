package org.yourcompany.yourproject;

import java.util.Scanner;

import org.yourcompany.library.models.Book;
import org.yourcompany.library.services.LibraryService;;

public class App {
    static int choice = 0;
    static String author;
    static String title;
    static String[] matchList;
    static int counter = 1;
    static String trueBookTitle;
    static Book daBook;

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Welcome to Libary");

            while (choice != 4) {
                System.out.println("1. Add book");
                System.out.println("2. Find book");
                System.out.println("3. View collection");
                System.out.println("4. Exit");
                System.out.print("Choose (1/2/3/4): ");

                choice = Integer.parseInt(s.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.println("you chose option 1");
                        System.out.print("Enter book title: ");
                        title = s.nextLine();

                        System.out.print("Enter book author: ");
                        author = s.nextLine();

                        LibraryService.addBook(title, author);
                    }
                    case 2 -> {
                        System.out.println("you chose option 2");
                        System.out.print("Enter book title (CASE SENSITIVE): ");
                        title = s.nextLine();

                        matchList = LibraryService.findBook(title);
                        for (String name : matchList) {
                            System.out.println(counter+" "+name);
                            counter++;
                        }
                        counter = 1;

                        System.out.println("\n\n");
                        System.out.print("choose which book: ");
                        choice = Integer.parseInt(s.nextLine());
                        trueBookTitle = matchList[choice-1];

                        daBook = LibraryService.selectBook(trueBookTitle); // need to see if it's checked out
                        // then create a switch statement based on result
                        System.out.print("Would you like to checkout "+daBook.getTitle()+"? (Y/N) ");
                        String selection = s.nextLine();

                        switch (selection) {
                            case "Y" -> {
                                daBook.checkOut();
                                System.out.println(daBook.getTitle()+" is now checked out");
                            }
                            case "N" -> {
                                System.out.println("Back to main menu...");
                            }
                        }
                    }
                    case 3 -> {
                        LibraryService.viewCollection();
                    }
                    case 4 -> {
                        System.out.println("exiting now...");
                    }
                    default -> System.out.println("not a valid choice, please try again");
                }
            }
            System.out.println("program closed.");
        }

    }
}
/*
todo
-----------------
finish checking out book functionality
add return book functionality ?
*/