package inventory;

import model.Magazine;
import model.Novel;
import utility.PublishPeriod;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

    Scanner scanner = new Scanner(System.in);
    InventoryServiceImpl inventory = new InventoryServiceImpl();


    public void startApp() {
        while (true) {
            System.out.println("============= ENIGPUS =============");
            System.out.println("Welcome to ENIGPUS Library!\nWhat would you like to do today?");
            System.out.println("1. Manage Novel");
            System.out.println("2. Manage Magazine");
            System.out.println("3. Get a List of All Available Novels and Magazine");
            System.out.println("4. Exit");
            System.out.println("====================================");
            System.out.print("Enter your choice here: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) novelMenu();
                else if (choice == 2) magazineMenu();
                else if (choice == 3)  {
                    System.out.println("List of Available Novel:");
                    inventory.getAllBook(1);
                    System.out.println();
                    System.out.println("List of All Available Magazine:");
                    inventory.getAllBook(2);
                    System.out.println();
                } else if (choice == 4) {
                    scanner.close(); break;
                }
                else System.out.println("That's not a valid option\n");
            }
            catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Wrong type of input! Try again!\n");
                System.out.println();
            }
        }
    }

    public void novelMenu() {
        while (true) {
            System.out.println();
            System.out.println("============== NOVEL ==============");
            System.out.println("1. Add New Novel");
            System.out.println("2. Search Novel by Title");
            System.out.println("3. Search Novel by ID");
            System.out.println("4. Remove Existing Novel");
            System.out.println("5. Get a List of All Available Novel");
            System.out.println("6. Back");
            System.out.println("====================================");
            System.out.print("Enter your choice here: ");
            try{
                int choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                if (choice == 1) addNovel();
                else if (choice == 2) {
                    System.out.print("Enter title name: ");
                    String title = scanner.nextLine();
                    if (title.isEmpty()) inventory.searchBookByTitle(title, 3);
                    else inventory.searchBookByTitle(title, 1);

                }
                else if (choice == 3) {
                    System.out.print("Enter novel ID: ");
                    int id = scanner.nextInt();
                    inventory.searchBookById(id, 1);
                    scanner.nextLine();
                }
                else if (choice == 4) {
                    System.out.print("Enter the title of the novel you'd like to remove: ");
                    String title = scanner.nextLine();
                    inventory.deleteBook(title, 1);
                }
                else if (choice == 5) inventory.getAllBook(1);
                else if (choice == 6) break;
                else System.out.println("That's not a valid option");
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Wrong type of input! Try again!");
                System.out.println();
            }
        }
    }
    public void magazineMenu() {
        while (true) {
            System.out.println();
            System.out.println("============= MAGAZINE =============");
            System.out.println("1. Add New Magazine");
            System.out.println("2. Search Magazine by Title");
            System.out.println("3. Search Magazine by ID");
            System.out.println("4. Remove Existing Magazine");
            System.out.println("5. Get a List of All Available Magazine");
            System.out.println("6. Back");
            System.out.println("====================================");
            System.out.print("Enter your choice here: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                if (choice == 1) addMagazine();
                else if (choice == 2) {
                    System.out.print("Enter title name: ");
                    String title = scanner.nextLine();
                    if (title.isEmpty()) inventory.searchBookByTitle(title, 3);
                    else inventory.searchBookByTitle(title, 2);
                }
                else if (choice == 3) {
                    System.out.print("Enter magazine ID: ");
                    int id = scanner.nextInt();
                    inventory.searchBookById(id, 2);
                    scanner.nextLine();
                }
                else if (choice == 4) {
                    System.out.print("Enter the title of the magazine you'd like to remove: ");
                    String title = scanner.nextLine();
                    inventory.deleteBook(title, 2);
                }
                else if (choice == 5) inventory.getAllBook(2);
                else if (choice == 6) break;
                else System.out.println("That's not a valid option");
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Wrong type of input! Try again!");
                System.out.println();
            }
        }
    }

    public void addNovel() {
        while (true) {
            System.out.println("=========== ADD NEW NOVEL ===========");
            System.out.print("Enter novel's title: ");
            try {
                String title = scanner.nextLine();
                System.out.print("Enter novel's publisher: ");
                String publisher = scanner.nextLine();
                System.out.print("Enter the year the novel was published: ");
                int yearPublished = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter novel's author name: ");
                String author = scanner.nextLine();
                int id = inventory.getNovelList().size() + 1000;
                inventory.addBook(new Novel(id, title, publisher, yearPublished, author));
                System.out.println("New novel has been added!");
                System.out.println(inventory.getRecentlyAddedNovel());

                System.out.println("Do you want to add more novel? (Y/N)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("N")) break;
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Wrong type of input! Try again!");
                System.out.println();
            }
        }
    }

    public void addMagazine() {
        while (true) {
            System.out.println("========= ADD NEW MAGAZINE =========");
            System.out.print("Enter magazine's title: ");
            try {
                String title = scanner.nextLine();
                PublishPeriod publishPeriod = choosePublishPeriod();
                System.out.print("Enter the year the magazine was published: ");
                int yearPublished = scanner.nextInt();
                scanner.nextLine();
                int id = inventory.getMagazinesList().size() + 1000;
                inventory.addBook(new Magazine(id, title, publishPeriod, yearPublished));
                System.out.println("New magazine has been added!");
                System.out.println(inventory.getRecentlyAddedMagazine());

                System.out.println("Do you want to add more magazine? (Y/N)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("N")) break;
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Wrong type of input! Try again!");
                System.out.println();
            }

        }
    }

    public PublishPeriod choosePublishPeriod() {
        while (true) {
            System.out.println();
            System.out.println("= CHOOSE MAGAZINE'S PUBLISH PERIOD =");
            System.out.println("1. WEEKLY");
            System.out.println("2. MONTHLY");
            System.out.println("====================================");
            System.out.print("Enter your choice here: ");
            try {
                int publishedPeriod = scanner.nextInt();
                if (publishedPeriod == 1) return PublishPeriod.WEEKLY;
                if (publishedPeriod == 2) return PublishPeriod.MONTHLY;
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Wrong type of input! Try again!");
            }

        }
    }

}
