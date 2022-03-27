package liga.medical.messageanalyzer.core.constants;

/**
 * Константы приложения.
 */
public enum ApplicationConstants {

    PATIENT_ALERT("patient-alert");

    private String medicalQueue;

    ApplicationConstants(String queueName) {
        this.medicalQueue = queueName;
    }

    public String getMedicalQueue() {
        return medicalQueue;
    }
}
