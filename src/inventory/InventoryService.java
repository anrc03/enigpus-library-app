package inventory;

import model.Magazine;
import model.Novel;

public interface InventoryService {
    void addBook(Novel novel);
    void addBook(Magazine magazine);
    void searchBookByTitle(String title, int choice);
    void searchBookById(int id, int choice);
    void deleteBook(String title, int choice);
    void getAllBook(int choice);
}
