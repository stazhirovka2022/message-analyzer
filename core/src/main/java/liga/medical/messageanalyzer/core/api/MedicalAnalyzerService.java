package liga.medical.messageanalyzer.core.api;

import liga.medical.DeviceIdentificationDto;

/**
 * Сервис по анализу показателей пациента.
 */
public interface MedicalAnalyzerService {

    /**
     * Анализ пациента и информирование ою ухудшении состояния.
     *
     * @param deviceInfo модель с данными о пациенте
     */
    void analyze(DeviceIdentificationDto deviceInfo);
}
