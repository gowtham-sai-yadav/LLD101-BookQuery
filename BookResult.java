import java.util.ArrayList;

public class BookResult {
    private int count;
    private ArrayList<String> data;
    private String description;
    private boolean hasResults;
    
    public BookResult(int count, ArrayList<String> data, String description) {
        this.count = count;
        this.data = data;
        this.description = description;
        this.hasResults = count > 0;
    }
    
    public void displayResults() {
        System.out.println("\n=== " + description.toUpperCase() + " ===");
        
        if (!hasResults) {
            System.out.println("No results found.");
        } else {
            System.out.println("Found " + count + " result(s):");
            System.out.println("----------------------------------");
            
            for (int i = 0; i < data.size(); i++) {
                System.out.println((i + 1) + ". " + data.get(i));
            }
        }
        
        System.out.println("----------------------------------");
    }
    
    public int getCount() {
        return count;
    }
    
    public ArrayList<String> getData() {
        return data;
    }
    
    public String getDescription() {
        return description;
    }
    
    public boolean hasResults() {
        return hasResults;
    }
    
    public String getSummary() {
        return description + ": " + count + " result(s)";
    }
}
