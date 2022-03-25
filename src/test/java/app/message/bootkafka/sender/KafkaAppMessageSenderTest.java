package app.message.bootkafka.sender;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KafkaAppMessageSenderTest {

    @Autowired
    KafkaAppMessageSender kafkaAppMessageSender;

    @Test
    void sendMessage() {
        IntStream.rangeClosed(15000, 20000)
            .parallel()
            .mapToObj(String::valueOf)
            .forEach(msg -> kafkaAppMessageSender.sendMessage("test", msg));
    }
}