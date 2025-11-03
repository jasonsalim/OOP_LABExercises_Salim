public class ProjectTester {
    public static void main(String[] args) {

        // --- Runtime Polymorphism Example ---
        User user1 = new Applicant(
            2, "Jason", "jasonsalim2006@mail.gwapo22", "secret",
            "Resume.pdf", "Script, SQL"
        );
        User user2 = new Admin(
            1, "Cyril", "Cyril@jobportal.com", "123456"
        );

        user1.login();  // Calls Applicant's login() method
        user2.login();  // Calls Admin's login() method


        // --- Compile-time Polymorphism (Method Overloading) ---
        Applicant applicant = new Applicant(
            3, "Antonio", "antonio@mail.com", "123456",
            "Resume.docx", "Python"
        );
        Job job = new Job(
            101, "Software Developer",
            "Develop Java apps", "Java, OOP"
        );

        // Overloaded applyJob() methods
        applicant.applyJob(job);  
        applicant.applyJob(job, "Here is my cover letter.");


        // --- Application Example with Overloaded Methods ---
        Application app1 = new Application(1001);
        app1.submit();                // No parameter
        app1.submit("Charlie");       // With applicant name


        // --- Job Update Example with Overloaded Methods ---
        job.updateJob("Develop Java and Spring Boot apps");
        job.updateJob("Full-stack development", "Java, React");
    }
}
