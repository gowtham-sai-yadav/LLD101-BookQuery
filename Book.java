public class Book {
    private String title;
    private String author;
    private double userRating;
    private int reviews;
    private double price;
    private int year;
    private String genre;
    
    public Book(String title, String author, double userRating, int reviews, 
                double price, int year, String genre) {
        this.title = title;
        this.author = author;
        this.userRating = userRating;
        this.reviews = reviews;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public double getUserRating() {
        return userRating;
    }
    
    public int getReviews() {
        return reviews;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public String getName() {
        return title;
    }
    
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Rating: " + userRating + "/5.0");
        System.out.println("Reviews: " + reviews);
        System.out.println("Price: $" + price);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre);
        System.out.println("-------------------------");
    }
}