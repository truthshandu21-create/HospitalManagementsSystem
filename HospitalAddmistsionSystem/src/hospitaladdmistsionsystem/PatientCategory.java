package hospitaladdmistsionsystem;

public enum PatientCategory {
    INPATIENT("Inpatient"),
    OUTPATIENT("Outpatient"),
    EMERGENCY("Emergency");

    private final String label;

    PatientCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}