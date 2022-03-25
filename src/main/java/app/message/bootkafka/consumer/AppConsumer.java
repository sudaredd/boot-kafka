package app.message.bootkafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppConsumer {

    private static final String APP_TOPIC = "test";

    @KafkaListener(
        topics = APP_TOPIC,
        containerFactory = "appKafkaListenerContainerFactory"
    )
    public void depositFound(@Payload String message)  {
        log.info("message received {}", message);
    }
}
