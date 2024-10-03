/*
 * Created on 2024-10-03
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;

public class App {

    private static Scanner myScanner = new Scanner(System.in);
    private static boolean readDataFromFile = true;

    public static void main(String[] args) {
        // Check the argument's length to make sure there is a command-line argument
        if (args.length > 0) {
            Cat[] cats = readCatsFromFile(args[0]);

            if (cats != null) {
                adoptionTable = generateAdoptionTable(cats);
                printAdoptionTable(adoptionTable);
                sortAdoptions(adoptionTable);
                printAdoptionTable(adoptionTable);
            }
        }
        myScanner.close();
    }

    public static /* TODO: return type */ generateAdoptionTable(Cat[] cats) {
        // TODO: LAB06 - Task 1
        // Hint: for the adoption year, generate a random number, e.g., between 2000-2024
        
        return null;
    }

    public static void printAdoptionTable(adoptionTable) {
        System.out.println("\nAdoption Table:");
        System.out.println("# | Cat\t\t | Owner\t | Year");
        System.out.println("----------------------------------------");
        
        // TODO: LAB06 - Task 1
    }

    public static void sortAdoptions(/* TODO: type*/ adoptionTable) {
        // TODO: LAB06 - Task 2 - sort the adoptions by "most recent"
    }

    /*
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * ! NO NEED TO TOUCH THE LINES BELOW !
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */

    // Note: Print statements are commented out.
    // Feel free to comment them back in to understand how the file reading works.

    public static Cat[] readCatsFromFile(String fileName) {
        // A FileNotFoundException could occur when reading a file
        // The try-catch block ould also be around the method invocation in main!
        try {
            readDataFromFile = true;
            File file = new File(fileName);
            myScanner = new Scanner(file);

            // Count all lines in the file
            int lineCount = 0;
            while (myScanner.hasNextLine()) {
                myScanner.nextLine();
                lineCount++;
            }
            // The txt file allocates 6 lines to one cat
            int numberOfCats = lineCount / 6;

            // Reinitialize scanner
            myScanner = new Scanner(file);

            Cat[] cats = new Cat[numberOfCats];
            for (int i = 0; i < cats.length && myScanner.hasNextLine(); i++) {
                Cat cat = readCatFromInput();
                cats[i] = cat;
            }
            System.out.printf("Read %d cats%n", cats.length);

            return cats;

        } catch (FileNotFoundException e) {
            System.out.println("Could not find file; " + e);

            return null;
        }
    }

    // Read cat object from user input
    public static Cat readCatFromInput() {
        // System.out.println("\n------Reading a new cat------");

        Owner owner = promptForOwner();
        Cat cat = promptForCat();

        if (cat != null) {
            cat.setOwner(owner);
            if (promptForStory()) {
                String story = promptForStoryDetails();
                cat.setFunnyStory(story);
            }
        }
        // System.out.println("-----------------------------");

        return cat;
    }

    public static void printCatInfo(Cat cat) {
        System.out.println();
        if (cat != null && cat.getOwner() != null) {
            System.out.print(cat.getOwner().getName() + " has adopted " + cat.getName());
            if (cat.getAge() != 404) {
                System.out.print(" (" + cat.getAge() + ")");
            }
            if (cat.getFunnyStory() != "" && !(cat.getFunnyStory().equals("n/a"))) {
                System.out.println(" and shared this story: ");
                System.out.println(cat.getFunnyStory().toString());
            } else {
                System.out.println(".");
            }
        }
    }

    // Helper methods to prompt the user for input
    private static Owner promptForOwner() {
        String ownerName = myScanner.nextLine();
        // System.out.println("Owner:\t\t" + ownerName);
        return new Owner(ownerName);
    }

    private static Cat promptForCat() {
        String name = myScanner.nextLine();
        // System.out.println("Cat name:\t" + name);

        String catSound = myScanner.nextLine();
        // System.out.println("Cat sound:\t" + catSound);

        boolean isValidNumber = false;
        int age = 404; // Error code
        while (!isValidNumber) {
            try {
                age = myScanner.nextInt();
                isValidNumber = true;
            } catch (InputMismatchException e) {
                if (!readDataFromFile) {
                    System.out.println("Invalid input. Please enter a number.");
                } else {
                    isValidNumber = true;
                }
            }
            myScanner.nextLine();
        }
        // System.out.println("Cat age:\t" + age);
        return new Cat(name, age, catSound);
    }

    private static String promptForStoryDetails() {
        // System.out.print("Story title:\t");
        String storyTitle = myScanner.nextLine();
        // System.out.println(storyTitle);
        // System.out.print("Story:\t\t");
        String storyDescription = myScanner.nextLine();
        // System.out.println(storyDescription);

        if (!storyTitle.isEmpty()) {
            storyTitle = storyTitle.concat(" - ");
        }
        return storyTitle.concat(storyDescription);
    }

    private static boolean promptForStory() {
        if (readDataFromFile) {
            return true;
        }
        System.out.println("Do you want to share a funny story about your cat? (yes/no)");
        String response = myScanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }
}
