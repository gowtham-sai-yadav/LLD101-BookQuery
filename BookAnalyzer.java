import java.util.ArrayList;
import java.util.List;

public class BookAnalyzer {
    
    // TASK 1: Count total number of books by an author
    public static int countBooksByAuthor(List<Book> books, String authorName) {
        int count = 0;
        
        // Go through each book and check if author matches
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                count++;
            }
        }
        
        return count;
    }
    
    // TASK 2: Print all authors in the dataset
    public static void printAllAuthors(List<Book> books) {
        System.out.println("\n=== ALL AUTHORS ===");
        
        List<String> uniqueAuthors = new ArrayList<>();
        
        // Find unique authors
        for (Book book : books) {
            String author = book.getAuthor();
            // Add author only if not already in the list
            if (!uniqueAuthors.contains(author)) {
                uniqueAuthors.add(author);
            }
        }
        
        // Print all unique authors
        for (int i = 0; i < uniqueAuthors.size(); i++) {
            System.out.println((i + 1) + ". " + uniqueAuthors.get(i));
        }
        
        System.out.println("Total unique authors: " + uniqueAuthors.size());
        System.out.println("===================");
    }
    
    // TASK 3: Print all book names by a specific author
    public static void printBooksByAuthor(List<Book> books, String authorName) {
        System.out.println("\n=== BOOKS BY " + authorName + " ===");
        
        List<String> bookTitles = new ArrayList<>();
        
        // Find all books by this author
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                bookTitles.add(book.getTitle());
            }
        }
        
        // Print the books
        if (bookTitles.size() == 0) {
            System.out.println("No books found by " + authorName);
        } else {
            for (int i = 0; i < bookTitles.size(); i++) {
                System.out.println((i + 1) + ". " + bookTitles.get(i));
            }
            System.out.println("Total books: " + bookTitles.size());
        }
        
        System.out.println("========================");
    }
    
    // TASK 4: Print all books with a specific rating
    public static void printBooksByRating(List<Book> books, double rating) {
        System.out.println("\n=== BOOKS WITH RATING " + rating + " ===");
        
        List<Book> matchingBooks = new ArrayList<>();
        
        // Find all books with this rating
        for (Book book : books) {
            if (book.getUserRating() == rating) {
                matchingBooks.add(book);
            }
        }
        
        // Print the books
        if (matchingBooks.size() == 0) {
            System.out.println("No books found with rating " + rating);
        } else {
            for (int i = 0; i < matchingBooks.size(); i++) {
                Book book = matchingBooks.get(i);
                System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor());
            }
            System.out.println("Total books: " + matchingBooks.size());
        }
        
        System.out.println("========================");
    }
    
    // TASK 5: Print book names and prices by a specific author
    public static void printBookPricesByAuthor(List<Book> books, String authorName) {
        System.out.println("\n=== BOOKS AND PRICES BY " + authorName + " ===");
        
        List<Book> authorBooks = new ArrayList<>();
        
        // Find all books by this author
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                authorBooks.add(book);
            }
        }
        
        // Print the books with prices
        if (authorBooks.size() == 0) {
            System.out.println("No books found by " + authorName);
        } else {
            for (int i = 0; i < authorBooks.size(); i++) {
                Book book = authorBooks.get(i);
                System.out.println((i + 1) + ". " + book.getTitle() + " - $" + book.getPrice());
            }
            System.out.println("Total books: " + authorBooks.size());
        }
        
        System.out.println("=============================");
    }
    
    // BONUS: Print basic information about the dataset
    public static void printDatasetInfo(List<Book> books) {
        System.out.println("\n=== DATASET INFORMATION ===");
        System.out.println("Total books in dataset: " + books.size());
        
        // Count fiction vs non-fiction
        int fictionCount = 0;
        int nonFictionCount = 0;
        
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase("Fiction")) {
                fictionCount++;
            } else {
                nonFictionCount++;
            }
        }
        
        System.out.println("Fiction books: " + fictionCount);
        System.out.println("Non-fiction books: " + nonFictionCount);
        System.out.println("===========================");
    }
}