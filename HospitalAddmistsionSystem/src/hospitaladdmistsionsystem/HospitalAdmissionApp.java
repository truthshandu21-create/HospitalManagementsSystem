package hospitaladdmistsionsystem;

import java.util.Scanner;

public class HospitalAdmissionApp {
    private final HospitalManagementSystem system;
    private final Scanner scanner;

    public HospitalAdmissionApp() {
        this.system = new HospitalManagementSystem();
        this.scanner = new Scanner(System.in);
    }

    public void runApp() {
        int choice;
        do {
            System.out.println("\n=== Hospital Admission System ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Display All Patients");
            System.out.println("6. Bed Management");
            System.out.println("7. Reports");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = getIntInput();

            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> searchPatient();
                case 3 -> updatePatient();
                case 4 -> deletePatient();
                case 5 -> system.displayAllPatients();
                case 6 -> bedMenu();
                case 7 -> reportMenu();
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private int getIntInput() {
        try { return Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { return -1; }
    }

    // --- Patient methods (register, search, update, delete) ---
    // --- Bed menu (auto allocate, release, ward layout) ---
    // --- Reports menu (patients, beds, statistics) ---

    public static void main(String[] args) {
        new HospitalAdmissionApp().runApp();
    }

    private void registerPatient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void searchPatient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void updatePatient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void deletePatient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void bedMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void reportMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}