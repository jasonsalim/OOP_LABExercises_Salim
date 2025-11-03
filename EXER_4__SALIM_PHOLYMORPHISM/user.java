public class User {
    // --- Fields ---
    protected int userId;
    protected String name;
    protected String email;
    protected String password;
    protected String role;

    // --- Constructor ---
    public User(int userId, String name, String email, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // --- Methods ---
    public void login() {
        System.out.println(name + " logged in as " + role);
    }

    public void logout() {
        System.out.println(name + " logged out.");
    }

    // --- Method Overloading (Compile-time Polymorphism) ---
    public void updateProfile(String newEmail) {
        this.email = newEmail;
        System.out.println("Profile updated with email: " + email);
    }

    public void updateProfile(String newEmail, String newPassword) {
        this.email = newEmail;
        this.password = newPassword;
        System.out.println("Profile updated with email and password.");
    }
}
