package org.yourcompany.yourproject;

import java.util.List;
import java.util.Scanner;

import org.yourcompany.library.models.Book;
import org.yourcompany.library.services.LibraryService;

public class App {
    static int choice = 0;
    static String author;
    static String title;
    static List<Book> matchList;
    static int counter = 1;
    static Book trueBook;

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Welcome to Libary");
            LibraryService libraryService = new LibraryService();
            while (choice != 4) {
                System.out.println("1. Add book");
                System.out.println("2. Find book");
                System.out.println("3. View collection");
                System.out.println("4. Exit");
                System.out.print("Choose (1/2/3/4): ");

                try {
                    choice = Integer.parseInt(s.nextLine());
                } catch (NumberFormatException e) {
                    choice = 0;
                }
                switch (choice) {
                    case 1 -> {
                        System.out.println("you chose option 1");
                        System.out.print("Enter book title: ");
                        title = s.nextLine();

                        System.out.print("Enter book author: ");
                        author = s.nextLine();

                        libraryService.addBook(title, author);
                    }
                    case 2 -> {
                        System.out.println("you chose option 2");
                        System.out.print("Enter book title: ");
                        title = s.nextLine();

                        matchList = libraryService.findBook(title);
                        for (Book book : matchList) {
                            System.out.println(counter+" "+book.getTitle());
                            counter++;
                        }
                        counter = 1;

                        System.out.println("\n");
                        System.out.print("choose which book (1/2/...): ");
                        try {
                            choice = Integer.parseInt(s.nextLine());
                            trueBook = matchList.get(choice-1);

                            System.out.print("Would you like to checkout "+trueBook.getTitle()+"? (Y/N) ");
                            String selection = s.nextLine();

                            switch (selection) {
                                case "Y" -> {
                                    trueBook.checkOut();
                                    System.out.println(trueBook.getTitle()+" is now checked out");
                                }
                                case "N" -> {
                                    System.out.println("Back to main menu...");
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Not a valid input, starting over...");
                            choice = 0;
                        }
                    }
                    case 3 -> {
                        libraryService.viewCollection();
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