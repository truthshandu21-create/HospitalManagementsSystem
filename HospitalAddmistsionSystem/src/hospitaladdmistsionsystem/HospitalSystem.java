package hospitaladdmistsionsystem;

import hospitaladdmistsionsystem.Inpatient;
import hospitaladdmistsionsystem.Patient;
import hospitaladdmistsionsystem.PatientCategory;
import java.util.Scanner;

public class HospitalAdmissionApp {
    private HospitalManagementSystem system;
    private Scanner scanner;

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

    // Utility method for safe integer input
    private int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // invalid input
        }
    }

    private void registerPatient() {
        System.out.println("\n--- Register New Patient ---");
        System.out.print("Enter Patient ID: ");
        String patientID = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = getIntInput();

        System.out.print("Enter Gender (M/F/Other): ");
        String gender = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String medicalCondition = scanner.nextLine();

        System.out.println("Select Patient Category:");
        System.out.println("1. Inpatient");
        System.out.println("2. Outpatient");
        System.out.println("3. Emergency");
        int categoryChoice = getIntInput();

        PatientCategory category = switch (categoryChoice) {
            case 1 -> PatientCategory.INPATIENT;
            case 2 -> PatientCategory.OUTPATIENT;
            case 3 -> PatientCategory.EMERGENCY;
            default -> PatientCategory.OUTPATIENT;
        };

        system.registerPatient(patientID, firstName, lastName, age, gender, medicalCondition, category);
    }

    private void searchPatient() {
        System.out.print("\nEnter Patient ID to search: ");
        String patientID = scanner.nextLine();
        Patient patient = system.searchPatient(patientID);

        if (patient != null) {
            System.out.println("\n--- Patient Found ---");
            patient.displayDetails();
        } else {
            System.out.println("Patient not found.");
        }
    }

    private void updatePatient() {
        System.out.print("\nEnter Patient ID to update: ");
        String patientID = scanner.nextLine();

        Patient patient = system.searchPatient(patientID);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter new First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter new Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter new Age: ");
        int age = getIntInput();

        System.out.print("Enter new Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter new Medical Condition: ");
        String medicalCondition = scanner.nextLine();

        system.updatePatientDetails(patientID, firstName, lastName, age, gender, medicalCondition);
    }

    private void deletePatient() {
        System.out.print("\nEnter Patient ID to delete: ");
        String patientID = scanner.nextLine();
        system.deletePatient(patientID);
    }

    // Bed Management Menu
    private void bedMenu() {
        int choice;
        do {
            System.out.println("\n--- Bed Management ---");
            System.out.println("1. Auto Allocate Bed to Inpatient");
            System.out.println("2. Release Bed");
            System.out.println("3. Display Ward Layout");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = getIntInput();

            switch (choice) {
                case 1 -> autoAllocateBed();
                case 2 -> releaseBed();
                case 3 -> system.getWard().displayWardLayout();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void autoAllocateBed() {
        System.out.print("\nEnter Patient ID: ");
        String patientID = scanner.nextLine();
        Patient patient = system.searchPatient(patientID);

        if (patient instanceof Inpatient inpatient) {
            if (system.getWard().getAvailableBeds().size() > 0) {
                String bed = system.getWard().getAvailableBeds().iterator().next();
                system.allocateBedToInpatient(patientID, bed);
                System.out.println("Auto-assigned bed: " + bed);
            } else {
                System.out.println("No beds available.");
            }
        } else {
            System.out.println("Only inpatients can be allocated beds.");
        }
    }

    private void releaseBed() {
        System.out.print("\nEnter Bed Number to release: ");
        String bedNumber = scanner.nextLine();
        system.releaseBedForInpatient(bedNumber);
    }

    // Reports Menu
    private void reportMenu() {
        int choice;
        do {
            System.out.println("\n--- Reports ---");
            System.out.println("1. All Patients");
            System.out.println("2. Available Beds");
            System.out.println("3. Occupied Beds");
            System.out.println("4. Patient Statistics");
            System.out.println("5. Bed Statistics");
            System.out.println("6. Ward Occupancy %");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = getIntInput();

            switch (choice) {
                case 1 -> system.reportAllPatients();
                case 2 -> system.reportAvailableBeds();
                case 3 -> system.reportOccupiedBeds();
                case 4 -> system.reportTotalPatients();
                case 5 -> system.reportTotalOccupiedBeds();
                case 6 -> system.reportOccupancyPercentage();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        new HospitalAdmissionApp().runApp();
    }
}