public class Job {
    // --- Fields ---
    private int jobId;
    private String title;
    private String description;
    private String requirements;
    private String status;

    // --- Constructor ---
    public Job(int jobId, String title, String description, String requirements) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.status = "Open";
    }

    // --- Job Actions ---
    public void postJob() {
        System.out.println("Job posted: " + title);
    }

    // --- Overloaded Methods (Compile-time Polymorphism) ---
    public void updateJob(String newDescription) {
        this.description = newDescription;
        System.out.println("Job updated: " + description);
    }

    public void updateJob(String newDescription, String newRequirements) {
        this.description = newDescription;
        this.requirements = newRequirements;
        System.out.println("Job updated: " + description +
                           ", Requirements: " + requirements);
    }

    public void closeJob() {
        this.status = "Closed";
        System.out.println("Job closed: " + title);
    }

    // --- Getter ---
    public String getTitle() {
        return title;
    }
}
