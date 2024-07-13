import java.util.HashMap;
import java.util.Scanner;

public class Exam {
    HashMap<String, String> d = new HashMap<>();
    Scanner input = new Scanner(System.in);
    /*
    Developed by ankit kumar - Oasis InfoByte Java Programming Internship
    */

    public void login() {
        System.out.println("\n\n");
        System.out.println("Enter Your User-ID (even if you have not registered before): ");
        String userID = input.nextLine();
        String password;

        if (!d.containsKey(userID)) {
            System.out.println("New User Registration Detected! Registering....");
            System.out.println("Create Password: ");
            password = input.nextLine();
            d.put(userID, password);
            System.out.println("Registration Successfully Completed!");
            main();
        } else {
            System.out.println("Enter Your Password: ");
            password = input.nextLine();
            if (d.containsKey(userID) && d.get(userID).equals(password)) {
                System.out.println("Log-In Successful!");
                main();
            } else {
                System.out.println("Invalid Password. Please Try Again....");
                login();
            }
        }
    }

    public void main() {
        System.out.println("\n1.Update Your Profile \n2.Start the  Exam\n3.Logout");
        System.out.println("Enter your choice: ");
        int op = input.nextInt();
        switch (op) {
            case 1:
                d = update();
                main();
                break;
            case 2:
                solve();
                main();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice! Select any one option from 1-3...");
                main();
                break;
        }
    }

    public HashMap<String, String> update() {
        System.out.println("\n----- Update Your Profile -----");
        System.out.println("Enter Your Username: ");
        String id = input.next();

        if (d.containsKey(id)) {
            System.out.println("Enter New Password: ");
            String newpd = input.next();
            d.replace(id, newpd);
            System.out.println("Profile Update Success!");
        } else {
            System.out.println("User does not exist...");
            System.out.println("Profile Update Failed!");
        }
        return d;
    }

    public void solve() {
        long start = System.currentTimeMillis();
        long terminate = start + 90 * 1000; // 90 seconds (1.5 minutes) for the test
        int score = 0;
        int c = 0, w = 0;
        char ans;
        System.out.println("\n\n***** Starting The Exam *****");
        System.out.println("You have 90 seconds to answer each question[Timer will automatically calculated]. Select the options wisely... ");
        System.out.println("Each question gives +2 marks for a correct answer and -1 mark for a wrong answer.");
        System.out.println("All the Best!! Do Well");

        for (int i = 1; i <= 4; i++) {
            switch (i) {
                case 1:
                    System.out.println("\nQ" + i + ". Who is the Father of Java?");
                    System.out.println("a. Bill Joy\nb. Dennis Ritche\nc. James Gosling\nd. Roy Jason");
                    break;
                case 2:
                    System.out.println("\nQ" + i + ". Which of the following option leads to the portability and security of Java?");
                    System.out.println("a. Use of exception handling\nb. Dynamic binding between objects\nc. Bytecode is executed by JVM\nd. The applet makes the Java code secure and portable");
                    break;
                case 3:
                    System.out.println("\nQ" + i + ". Which of the following is not a Java features?");
                    System.out.println("a. Dynamic.\nb. Architecture Neutral.\nc. Use of pointers.\nd. Object-oriented.");
                    break;
                case 4:
                    System.out.println("\nQ" + i + ". The \\u0021 article referred to as a?");
                    System.out.println("a. Octal escape\nb. Hexadecimal\nc. Unicode escape sequence\nd. Line feed");
                    break;
            }
            System.out.println("Your Answer is (Give the option):");
            ans = input.next().charAt(0);
            if (ans == 'c') {
                c += 1;
            } else {
                w -= 1;
            }
        }

        System.out.println("Hey Buddyy....! Congratulations! Exam Completed Successfully!");
        score = ((c * 2) + w);
        System.out.println("Total Number of correct answers: " + c);
        System.out.println("Yayyy!! Your Toatl score is " + score + ".Keep Working Hard! ");
    }

    public static void main(String args[]) {
        Exam e = new Exam();
        e.login();
    }
}
