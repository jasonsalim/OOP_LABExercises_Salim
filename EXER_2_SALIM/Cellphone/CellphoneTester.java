public class CellphoneTester {
    public static void main(String[] args) {
        // Create a Cellphone object using the no-argument constructor
        Cellphone phone1 = new Cellphone();

        // Create a Cellphone object using the parameterized constructor
        Cellphone phone2 = new Cellphone("Samsung", "Galaxy S24 Ultra", "Black",
                                         6.8, 256, "Android", 1199.99, 2024);

        // Display information for both cellphones
        System.out.println("Cellphone 1 Information:");
        phone1.displayInfo();
        
        System.out.println("Cellphone 2 Information:");
        phone2.displayInfo();
    }
}
