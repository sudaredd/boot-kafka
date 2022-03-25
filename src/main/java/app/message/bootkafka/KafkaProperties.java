package app.message.bootkafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app.boot")
public class KafkaProperties {

  private String kafkaAppAddress;

  private String kafkaConsumerGroup;
}
