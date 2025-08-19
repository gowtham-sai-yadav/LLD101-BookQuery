import java.util.ArrayList;

public class BookDriver {
    
    public static void main(String[] args) {
        BookDriver app = new BookDriver();
        app.runApplication();
    }
    
    public void runApplication() {
        ArrayList<Book> bookData = loadBookData();
        
        if (bookData.size() == 0) {
            System.out.println("❌ No books could be loaded. Exiting application.");
            return;
        }
        
        BookService bookService = new BookService(bookData);
        MenuManager menuManager = new MenuManager(bookService);
        startApplication(menuManager);
    }
    
    private ArrayList<Book> loadBookData() {
        System.out.println("🔄 Loading book collection...");
        
        ArrayList<Book> books = DatasetReader.readBooksFromCSV("data.csv");
        
        if (books.size() > 0) {
            System.out.println("✅ Successfully loaded " + books.size() + " books!");
        } else {
            System.out.println("⚠️  No books found or file could not be read.");
        }
        
        return books;
    }
    
    private void startApplication(MenuManager menuManager) {
        try {
            menuManager.showWelcome();
            menuManager.startMenu();
        } catch (Exception e) {
            System.out.println("❌ An error occurred: " + e.getMessage());
        } finally {
            System.out.println("🔚 Application terminated.");
        }
    }
}