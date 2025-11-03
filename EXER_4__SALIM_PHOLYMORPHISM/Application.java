import java.util.Date;

public class Application {
    // --- Fields ---
    private int applicationId;
    private String status;
    private Date dateApplied;

    // --- Constructor ---
    public Application(int applicationId) {
        this.applicationId = applicationId;
        this.status = "Pending";
        this.dateApplied = new Date();
    }

    // --- Application Actions ---
    public void submit() {
        System.out.println("Application " + applicationId +
                           " submitted on " + dateApplied);
    }

    // Overloaded method (Compile-time Polymorphism)
    public void submit(String applicantName) {
        System.out.println("Application " + applicationId +
                           " submitted by " + applicantName +
                           " on " + dateApplied);
    }

    public void withdraw() {
        this.status = "Withdrawn";
        System.out.println("Application " + applicationId + " withdrawn.");
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Application " + applicationId +
                           " status updated to " + newStatus);
    }

    // --- Getters ---
    public String getStatus() {
        return status;
    }

    public int getApplicationId() {
        return applicationId;
    }
}
