import java.util.Scanner;
        
        
public class RegistrationLoginApp{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Registration ===");
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        
        Login loginSystem = new Login(firstName, lastName);
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter cell phone number (e.g., +27838968976): ");
        String cellNumber = scanner.nextLine();
        
        String registrationMessage = loginSystem.registerUser(username, password, cellNumber);
        System.out.println("\n--- Registration Output ---");
        System.out.println(registrationMessage);
        
        if (registrationMessage.contains("successfully")) {
            System.out.println("\n=== Login ===");
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();
            
            boolean isLoggedIn = loginSystem.loginUser(loginUsername, loginPassword);
            String loginStatus = loginSystem.returnLoginStatus(isLoggedIn);
            
            System.out.println("\n--- Login Output ---");
            System.out.println(loginStatus);
        }
        
        scanner.close();
    }
}