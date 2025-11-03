public class Admin extends User {
    // --- Constructor ---
    public Admin(int userId, String name, String email, String password) {
        super(userId, name, email, password, "Admin");
    }

    // --- Overridden Method (Runtime Polymorphism) ---
    @Override
    public void login() {
        System.out.println("Admin " + name + " logged in with full privileges.");
    }

    // --- Admin-specific Actions ---
    public void manageJobs() {
        System.out.println(name + " is managing jobs.");
    }

    public void viewApplications() {
        System.out.println(name + " is viewing applications.");
    }

    public void approveApplication(Application app) {
        app.updateStatus("Approved");
        System.out.println("Application " + app.getApplicationId() + " approved.");
    }

    public void rejectApplication(Application app) {
        app.updateStatus("Rejected");
        System.out.println("Application " + app.getApplicationId() + " rejected.");
    }
}
