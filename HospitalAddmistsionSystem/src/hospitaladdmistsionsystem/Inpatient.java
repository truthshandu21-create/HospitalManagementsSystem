package hospitaladdmistsionsystem;


import hospitaladdmistsionsystem.Patient;

public class Inpatient extends Patient {
    private int wardNumber;
    private String bedNumber;

    public Inpatient(String patientID, String firstName, String lastName,
                     int age, String gender, String medicalCondition,
                     int wardNumber, String bedNumber) {
        super(patientID, firstName, lastName, age, gender, medicalCondition, PatientCategory.INPATIENT);
        this.wardNumber = wardNumber;
        this.bedNumber = bedNumber;
    }

    public int getWardNumber() { return wardNumber; }
    public String getBedNumber() { return bedNumber; }
    public void setWardNumber(int wardNumber) { this.wardNumber = wardNumber; }
    public void setBedNumber(String bedNumber) { this.bedNumber = bedNumber; }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Ward Number: " + wardNumber);
        System.out.println("Bed Number: " + bedNumber);
    }

    @Override
    public String toString() {
        return super.toString() + " | Ward: " + wardNumber + " | Bed: " + bedNumber;
    }
}