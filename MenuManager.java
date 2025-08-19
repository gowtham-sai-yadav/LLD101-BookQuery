import java.util.Scanner;

public class MenuManager {
    private BookService bookService;
    private Scanner inputScanner;
    private boolean isRunning;
    
    public MenuManager(BookService service) {
        this.bookService = service;
        this.inputScanner = new Scanner(System.in);
        this.isRunning = true;
    }
    
    public void showWelcome() {
        System.out.println("==========================================");
        System.out.println("    📚 BOOK COLLECTION ANALYZER 📚");
        System.out.println("==========================================");
        System.out.println(bookService.getCollectionStats());
        System.out.println("==========================================");
    }
    
    public void startMenu() {
        while (isRunning) {
            displayMenuOptions();
            int choice = getUserChoice();
            processMenuChoice(choice);
            
            if (isRunning) {
                pauseForUser();
            }
        }
        
        cleanup();
    }
    
    private void displayMenuOptions() {
        System.out.println("\n┌─────────── MAIN MENU ───────────┐");
        System.out.println("│ 1. Count books by author        │");
        System.out.println("│ 2. List all authors             │");
        System.out.println("│ 3. Find books by author         │");
        System.out.println("│ 4. Search books by rating       │");
        System.out.println("│ 5. View book prices by author   │");
        System.out.println("│ 6. Collection statistics        │");
        System.out.println("│ 7. Exit program                 │");
        System.out.println("└──────────────────────────────────┘");
        System.out.print("Select an option (1-7): ");
    }
    
    private int getUserChoice() {
        try {
            int choice = Integer.parseInt(inputScanner.nextLine().trim());
            if (choice >= 1 && choice <= 7) {
                return choice;
            } else {
                System.out.println("⚠️  Please enter a number between 1 and 7.");
                return -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠️  Please enter a valid number.");
            return -1;
        }
    }
    
    private void processMenuChoice(int choice) {
        switch (choice) {
            case 1:
                handleAuthorBookCount();
                break;
            case 2:
                handleAllAuthors();
                break;
            case 3:
                handleBooksByAuthor();
                break;
            case 4:
                handleBooksByRating();
                break;
            case 5:
                handleBookPricesByAuthor();
                break;
            case 6:
                handleCollectionStats();
                break;
            case 7:
                handleExit();
                break;
            case -1:
                // Invalid input already handled
                break;
            default:
                System.out.println("⚠️  Invalid option. Please try again.");
        }
    }
    
    private void handleAuthorBookCount() {
        String author = getAuthorInput("Enter author name to count books");
        if (author != null) {
            BookResult result = bookService.countAuthorBooks(author);
            System.out.println("\n📊 Result: " + author + " has " + result.getCount() + " book(s)");
        }
    }
    
    private void handleAllAuthors() {
        BookResult result = bookService.getAllUniqueAuthors();
        result.displayResults();
    }
    
    private void handleBooksByAuthor() {
        String author = getAuthorInput("Enter author name to find books");
        if (author != null) {
            BookResult result = bookService.findBooksByAuthor(author);
            result.displayResults();
        }
    }
    
    private void handleBooksByRating() {
        Double rating = getRatingInput();
        if (rating != null) {
            BookResult result = bookService.filterByRating(rating);
            result.displayResults();
        }
    }
    
    private void handleBookPricesByAuthor() {
        String author = getAuthorInput("Enter author name to view book prices");
        if (author != null) {
            BookResult result = bookService.getBookPricesByAuthor(author);
            result.displayResults();
        }
    }
    
    private void handleCollectionStats() {
        System.out.println("\n📈 COLLECTION STATISTICS");
        System.out.println("════════════════════════");
        System.out.println(bookService.getCollectionStats());
        System.out.println("Total unique authors: " + bookService.getAllUniqueAuthors().getCount());
        System.out.println("════════════════════════");
    }
    
    private void handleExit() {
        System.out.println("\n👋 Thank you for using Book Collection Analyzer!");
        System.out.println("📚 Happy reading! 📚");
        isRunning = false;
    }
    
    private String getAuthorInput(String prompt) {
        System.out.print("\n✏️  " + prompt + ": ");
        String input = inputScanner.nextLine().trim();
        
        if (input.isEmpty()) {
            System.out.println("⚠️  Author name cannot be empty.");
            return null;
        }
        
        return input;
    }
    
    private Double getRatingInput() {
        System.out.print("\n⭐ Enter rating (e.g., 4.5): ");
        try {
            double rating = Double.parseDouble(inputScanner.nextLine().trim());
            
            if (rating < 0 || rating > 5) {
                System.out.println("⚠️  Rating must be between 0 and 5.");
                return null;
            }
            
            return rating;
        } catch (NumberFormatException e) {
            System.out.println("⚠️  Please enter a valid decimal number.");
            return null;
        }
    }
    
    private void pauseForUser() {
        System.out.println("\n⏸️  Press Enter to continue...");
        inputScanner.nextLine();
    }
    
    private void cleanup() {
        inputScanner.close();
    }
}
