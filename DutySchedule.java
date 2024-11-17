import java.util.*;

public class DutySchedule {
    static class Duty {
        String employeeName;
        String date;

        public Duty(String employeeName, String date) {
            this.employeeName = employeeName;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Date: " + date + ", Employee: " + employeeName;
        }
    }

    private static List<String> employees = new ArrayList<>();
    private static List<Duty> duties = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nDuty Schedule Allotment System");
            System.out.println("1. Add Employee");
            System.out.println("2. Assign Duty");
            System.out.println("3. View Schedule");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    assignDuty(scanner);
                    break;
                case 3:
                    viewSchedule();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        employees.add(name);
        System.out.println("Employee added successfully.");
    }

    private static void assignDuty(Scanner scanner) {
        if (employees.isEmpty()) {
            System.out.println("No employees available. Please add employees first.");
            return;
        }

        System.out.println("Available Employees:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i));
        }

        System.out.print("Choose employee number: ");
        int employeeIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (employeeIndex < 0 || employeeIndex >= employees.size()) {
            System.out.println("Invalid employee selection.");
            return;
        }

        System.out.print("Enter date for duty : ");
        String date = scanner.nextLine();

        duties.add(new Duty(employees.get(employeeIndex), date));
        System.out.println("Duty assigned successfully.");
    }

    private static void viewSchedule() {
        if (duties.isEmpty()) {
            System.out.println("No duties assigned yet.");
            return;
        }

        System.out.println("\nDuty Schedule:");
        for (Duty duty : duties) {
            System.out.println(duty);
        }
    }
}
