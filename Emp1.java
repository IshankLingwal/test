import java.util.Scanner;

// Custom exceptions
class InvalidEmployeeNameException extends Exception {
    public InvalidEmployeeNameException(String message) {
        super(message);
    }
}

class InvalidEmployeeIdException extends Exception {
    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}

class InvalidDeptIdException extends Exception {
    public InvalidDeptIdException(String message) {
        super(message);
    }
}

public class Emp1 {

    public static void validateDetails(int empId, String name, int deptId)
            throws InvalidEmployeeIdException, InvalidEmployeeNameException, InvalidDeptIdException {

        if (empId < 2001 || empId > 5001) {
            throw new InvalidEmployeeIdException("Employee ID must be between 2001 and 5001.");
        }

        if (name == null || name.isEmpty() || !Character.isUpperCase(name.charAt(0))) {
            throw new InvalidEmployeeNameException("Employee name must start with a capital letter.");
        }

        if (deptId < 1 || deptId > 5) {
            throw new InvalidDeptIdException("Department ID must be between 1 and 5.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Accept inputs using nextInt()
            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department ID: ");
            int deptId = sc.nextInt();

            // Validate inputs
            validateDetails(empId, name, deptId);

            // Print details if valid
            System.out.println("\nEmployee Details:");
            System.out.println("ID      : " + empId);
            System.out.println("Name    : " + name);
            System.out.println("Dept ID : " + deptId);

        } catch (InvalidEmployeeIdException | InvalidEmployeeNameException | InvalidDeptIdException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
