package org.yourcompany.yourproject;

import java.util.Scanner;

import org.yourcompany.library.services.LibraryService;;

public class App {
    static int selection = 0;
    static String author;
    static String title;
    static String[] matchList;
    static int counter = 1;

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Welcome to Libary");

            while (selection != 4) {
                System.out.println("1. Add book");
                System.out.println("2. Find book");
                System.out.println("3. View collection");
                System.out.println("4. Exit");
                System.out.print("Choose (1/2/3/4): ");

                String choice = s.nextLine();
                selection = Integer.parseInt(choice);

                switch (selection) {
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
