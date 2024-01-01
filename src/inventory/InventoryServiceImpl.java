package inventory;

import model.Magazine;
import model.Novel;
import java.util.ArrayList;

public class InventoryServiceImpl implements InventoryService{
    private ArrayList<Novel> novelList = new ArrayList<>();
    private ArrayList<Magazine> magazinesList = new ArrayList<>();

    @Override
    public void addBook(Novel novel) {
        novelList.add(novel);
    }

    @Override
    public void addBook(Magazine magazine) {
        magazinesList.add(magazine);
    }

    @Override
    public void searchBookByTitle(String title, int choice) {
        boolean found = false;
        if (choice == 1){
            for (Novel i : novelList){
                if (i.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    found = true;
                    System.out.println(i);
                }
            }
        }
        if (choice == 2){
            for (Magazine i : magazinesList){
                if (i.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    found = true;
                    System.out.println(i);
                };
            }
        }

        if (choice == 3) {
            found = true;
            System.out.println("You didn't enter anything");
        }

        if (!found) System.out.printf("%s does not exist in our inventory!\n", title);
    }

    @Override
    public void searchBookById(int id, int choice) {
        boolean found = false;
        if (choice == 1){
            for (Novel i : novelList){
                if (i.getId().split("-")[2].equals(String.valueOf(id))) {
                    found = true;
                    System.out.println(i);
                }
            }
        }
        if (choice == 2){
            for (Magazine i : magazinesList){
                if (i.getId().split("-")[2].equals(String.valueOf(id))) {
                    found = true;
                    System.out.println(i);
                }
            }
        }

        if (!found) System.out.println("ID not found!");
    }

    @Override
    public void deleteBook(String title, int choice) {
        if (choice == 1) {
            Novel found = null;
            for (Novel i : novelList){
                if (i.getTitle().equalsIgnoreCase(title)) found = i;
            }
            if (found != null) {
                novelList.remove(found);
                System.out.println("Novel has been successfully removed");
            } else System.out.println("There's no such novel in our inventory!");
        }
        if (choice == 2) {
            Magazine found = null;
            for (Magazine i : magazinesList){
                if (i.getTitle().equalsIgnoreCase(title)) found = i;
            }
            if (found != null) {
                magazinesList.remove(found);
                System.out.println("Magazine has been successfully removed");
            } else System.out.println("There's no such magazine in our inventory!");
        }
    }

    @Override
    public void getAllBook(int choice) {
        if (choice == 1) for (Novel i : novelList) System.out.println(i);
        else if (choice == 2) for (Magazine i : magazinesList) System.out.println(i);
        else System.out.println("Invalid Choice");
    }

    public Novel getRecentlyAddedNovel() {
        return novelList.get(novelList.size() - 1);
    }

    public Magazine getRecentlyAddedMagazine() {
        return magazinesList.get(magazinesList.size() - 1);
    }

    public ArrayList<Novel> getNovelList() {
        return novelList;
    }

    public ArrayList<Magazine> getMagazinesList() {
        return magazinesList;
    }

}
