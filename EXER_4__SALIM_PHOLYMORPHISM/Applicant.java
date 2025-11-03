public class Applicant extends User {
    // --- Fields ---
    private String resume;
    private String skills;

    // --- Constructor ---
    public Applicant(int userId, String name, String email, String password,
                     String resume, String skills) {
        super(userId, name, email, password, "Applicant");
        this.resume = resume;
        this.skills = skills;
    }

    // --- Overridden Method (Runtime Polymorphism) ---
    @Override
    public void login() {
        System.out.println("Applicant " + name + " logged in with resume: " + resume);
    }

    // --- Applicant-specific Methods ---
    public void register() {
        System.out.println(name + " registered as applicant.");
    }

    // --- Overloaded Methods (Compile-time Polymorphism) ---
    public void applyJob(Job job) {
        System.out.println(name + " applied for job: " + job.getTitle());
    }

    public void applyJob(Job job, String coverLetter) {
        System.out.println(name + " applied for job: " + job.getTitle() +
                           " with cover letter: " + coverLetter);
    }

    // --- Utility Method ---
    public void viewApplicationStatus(Application application) {
        System.out.println("Application status: " + application.getStatus());
    }
}
