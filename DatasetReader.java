import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DatasetReader {
    
    public static ArrayList<Book> readBooksFromCSV(String fileName) {
        ArrayList<Book> books = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            boolean isFirstLine = true;
            
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                
                String[] data = line.split(",");
                
                if (data.length >= 7) {
                    try {
                        String title = data[0].trim();
                        String author = data[1].trim();
                        double userRating = Double.parseDouble(data[2].trim());
                        int reviews = Integer.parseInt(data[3].trim());
                        double price = Double.parseDouble(data[4].trim());
                        int year = Integer.parseInt(data[5].trim());
                        String genre = data[6].trim();
                        
                        Book book = new Book(title, author, userRating, reviews, price, year, genre);
                        books.add(book);
                        
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + line);
                    }
                }
            }
            
            reader.close();
            System.out.println("Successfully loaded " + books.size() + " books from " + fileName);
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            System.out.println("Creating sample data instead...");
        }
        
        return books;
    }
}