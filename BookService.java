import java.util.ArrayList;

public class BookService {
    private ArrayList<Book> bookCollection;
    
    public BookService(ArrayList<Book> books) {
        this.bookCollection = books;
    }
    
    public BookResult countAuthorBooks(String authorName) {
        int count = 0;
        ArrayList<String> foundTitles = new ArrayList<>();
        
        for (Book book : bookCollection) {
            if (isAuthorMatch(book.getAuthor(), authorName)) {
                count++;
                foundTitles.add(book.getTitle());
            }
        }
        
        return new BookResult(count, foundTitles, "Author book count for: " + authorName);
    }
    
    public BookResult getAllUniqueAuthors() {
        ArrayList<String> uniqueAuthors = new ArrayList<>();
        
        for (Book book : bookCollection) {
            String author = book.getAuthor();
            if (!containsAuthor(uniqueAuthors, author)) {
                uniqueAuthors.add(author);
            }
        }
        
        return new BookResult(uniqueAuthors.size(), uniqueAuthors, "All unique authors");
    }
    
    public BookResult findBooksByAuthor(String authorName) {
        ArrayList<String> bookTitles = new ArrayList<>();
        
        for (Book book : bookCollection) {
            if (isAuthorMatch(book.getAuthor(), authorName)) {
                bookTitles.add(book.getTitle());
            }
        }
        
        return new BookResult(bookTitles.size(), bookTitles, "Books by " + authorName);
    }
    
    public BookResult filterByRating(double targetRating) {
        ArrayList<String> matchingBooks = new ArrayList<>();
        
        for (Book book : bookCollection) {
            if (isRatingMatch(book.getUserRating(), targetRating)) {
                String bookInfo = book.getTitle() + " by " + book.getAuthor();
                matchingBooks.add(bookInfo);
            }
        }
        
        return new BookResult(matchingBooks.size(), matchingBooks, "Books with rating " + targetRating);
    }
    
    public BookResult getBookPricesByAuthor(String authorName) {
        ArrayList<String> bookPrices = new ArrayList<>();
        double totalValue = 0.0;
        
        for (Book book : bookCollection) {
            if (isAuthorMatch(book.getAuthor(), authorName)) {
                String priceInfo = book.getTitle() + " - $" + book.getPrice();
                bookPrices.add(priceInfo);
                totalValue += book.getPrice();
            }
        }
        
        String summary = "Books and prices by " + authorName + 
                        (bookPrices.size() > 0 ? " (Total value: $" + totalValue + ")" : "");
        
        return new BookResult(bookPrices.size(), bookPrices, summary);
    }
    
    private boolean isAuthorMatch(String bookAuthor, String searchAuthor) {
        return bookAuthor.toLowerCase().trim().equals(searchAuthor.toLowerCase().trim());
    }
    
    private boolean isRatingMatch(double bookRating, double targetRating) {
        return Math.abs(bookRating - targetRating) < 0.001;
    }
    
    private boolean containsAuthor(ArrayList<String> authors, String author) {
        for (String existingAuthor : authors) {
            if (isAuthorMatch(existingAuthor, author)) {
                return true;
            }
        }
        return false;
    }
    
    public int getTotalBooks() {
        return bookCollection.size();
    }
    
    public String getCollectionStats() {
        int fictionCount = 0;
        int nonFictionCount = 0;
        
        for (Book book : bookCollection) {
            if (book.getGenre().equalsIgnoreCase("Fiction")) {
                fictionCount++;
            } else {
                nonFictionCount++;
            }
        }
        
        return "Total: " + bookCollection.size() + " books | Fiction: " + 
               fictionCount + " | Non-Fiction: " + nonFictionCount;
    }
}
