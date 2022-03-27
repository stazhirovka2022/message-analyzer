package liga.medical.messageanalyzer.core.listener;

import liga.medical.DeviceIdentificationDto;
import liga.medical.messageanalyzer.core.api.MedicalAnalyzerService;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
@Slf4j
public class RabbitMqListener {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MedicalAnalyzerService medicalAnalyzerService;

    /**
     * Получаем информацию о сообщении.
     *
     * @param message сообщение
     */
    @RabbitListener(queues = "medical")
    public void processRabbitMessage(String message) {

        try {
            DeviceIdentificationDto deviceInfo =
                    objectMapper.readValue(message, DeviceIdentificationDto.class);
            medicalAnalyzerService.analyze(deviceInfo);
            System.out.println(deviceInfo);
        } catch (JsonProcessingException e) {
            log.info("Error while parsing incoming message {}", e.getMessage());
        }

        // TODO: передавать в сервис логирования все поступающие показания

        log.info("Получены данные пациента " + message);
    }
}