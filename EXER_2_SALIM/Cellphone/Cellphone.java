        public class Cellphone {
    private String brand;
    private String model;
    private String color;
    private double screenSize;   // e.g., 6.5 inches
    private int storage;         // e.g., 128 GB
    private String os;           // e.g., Android, iOS
    private double price;
    private int year;

    // No-argument constructor
    public Cellphone() {
        this.brand = "No Brand";
        this.model = "No Model";
        this.color = "No Color";
        this.screenSize = 0.0;
        this.storage = 0;
        this.os = "No OS";
        this.price = 0.0;
        this.year = 0;
    }

    // Parameterized constructor
    public Cellphone(String brand, String model, String color, double screenSize,
                     int storage, String os, double price, int year) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.screenSize = screenSize;
        this.storage = storage;
        this.os = os;
        this.price = price;
        this.year = (year > 0 && year <= java.time.Year.now().getValue()) ? year : 0; // Validate year
    }

    // Method to display cellphone information
    public String displayInfo() {
        String info = "";
        info += "Cellphone Brand: " + brand + "\n";
        info += "Cellphone Model: " + model + "\n";
        info += "Cellphone Color: " + color + "\n";
        info += "Cellphone Screen Size: " + screenSize + " inches\n";
        info += "Cellphone Storage: " + storage + " GB\n";
        info += "Cellphone OS: " + os + "\n";
        info += "Cellphone Price: $" + price + "\n";
        info += "Cellphone Year: " + year + "\n";
        System.out.println(info);
        return info;
    }
}
